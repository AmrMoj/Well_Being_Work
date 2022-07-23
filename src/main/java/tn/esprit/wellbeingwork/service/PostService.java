package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> retrieveAllPosts();

    Post addPost(Post p);

    void deletePost(Long id);

    Post updatePost(Post p);

    Post retrievePost(Long id);
}
