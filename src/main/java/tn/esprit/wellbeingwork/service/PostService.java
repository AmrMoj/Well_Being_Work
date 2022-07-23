package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Post;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface PostService {
    List<Post> retrieveAllPosts();

    Post addPost(Post p);

    void deletePost(Long id);

    Post updatePost(Post p);

    Post retrievePost(Long id);

    void addActualites() throws IOException, ParseException;
}
