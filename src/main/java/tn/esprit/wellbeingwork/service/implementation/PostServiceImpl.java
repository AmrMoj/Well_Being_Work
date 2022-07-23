package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import tn.esprit.wellbeingwork.entity.Post;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.PostRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.PostService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public List<Post> retrieveAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post p) {
        List<User> users = findUserByFavouriteThemePost(p.getTheme());
        sendEmails(users, p);
        return postRepository.save(p);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Post p) {
        return postRepository.save(p);
    }

    @Override
    public Post retrievePost(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void addActualites() throws IOException, ParseException {
        Document doc = Jsoup.connect("https://www.zdnet.fr/actualites/").timeout(60000).get();
        Elements body = doc.select("div.river");
        for(Element e : body.select("article")){
            if(!e.select("div.row").text().trim().equals("")){
                Post post = new Post();
                String postDate = e.select("div.row div.column-6 div.content p.meta").text().trim();
                post.setPostDate(new SimpleDateFormat("dd MMM yyyy", Locale.FRENCH)
                        .parse(postDate.split(" ")[1] + " " + postDate.split(" ")[2]+ " " + postDate.split(" ")[3] + ""));
                Date dt = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.DATE, -2);
                if (post.getPostDate().before(c.getTime())){
                    break;
                }
                Post existPost = postRepository.findByTitle(e.select("div.row div.column-6 h3 a").text()).orElse(null);
                if (existPost != null){
                    break;
                }
                post.setTheme(e.select("div.row div.column-2 h3 a").text());
                post.setTitle(e.select("div.row div.column-6 h3 a").text());
                post.setPostContent(e.select("div.row div.column-6 div.content p.summary").text());
                post.setUserPostCreator(userRepository.findById((long) 1).get());

                TransactionStatus transaction = this.transactionManager.getTransaction(null);

                try {
                    postRepository.save(post);
                    List<User> users = findUserByFavouriteThemePost(post.getTheme());
                    sendEmails(users, post);
                    this.transactionManager.commit(transaction);
                } catch (Throwable ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private void sendEmails(List<User> users, Post post) {
        for (User user : users){
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(user.getEmail());
            message.setSubject("Nouvel article");
            message.setText("Bonjour,\n" +
                    "\n" +
                    "Un nouvel article est publié sur WellBeingWork qui vous intéresse\n" +
                    "Soyez le premier à interagir sur cet article\n" +
                    "\n" +
                    "Cordialement");

            // Send Message!
            this.emailSender.send(message);
        }
    }

    public List<User> findUserByFavouriteThemePost (String theme){
        List<User> allUsers = userRepository.findAll();
        List<User> users = new ArrayList<User>();
        for (User user : allUsers){
            List<String> favoutiteThemes = userRepository.findFavouriteUserTheme(user.getIdUser());
            for(String favTheme : favoutiteThemes){
                if(favTheme.equals(theme)){
                    users.add(user);
                }
            }
        }
        return users;
    }
}
