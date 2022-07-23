package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Post;
import tn.esprit.wellbeingwork.repository.PostRepository;
import tn.esprit.wellbeingwork.service.PostService;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> retrieveAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post p) {
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
}
