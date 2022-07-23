package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Post;
import tn.esprit.wellbeingwork.service.PostService;

import java.util.List;

@RestController
@RequestMapping("post")
@Api(tags = "Post management")
public class PostRestController {

    @Autowired
    PostService postService;

    @ApiOperation(value="Add new post")
    @PostMapping("addPost")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @ApiOperation(value = "Get all posts")
    @GetMapping("getAllPosts")
    public List<Post> retrieveAllPosts(){
        return postService.retrieveAllPosts();
    }

    @ApiOperation(value = "Get a post")
    @GetMapping("getPost/{postId}")
    public Post retrievePost(@PathVariable("postId") long id){
        return postService.retrievePost(id);
    }

    @ApiOperation(value = "Delete a post")
    @DeleteMapping("deletePost/{postId}")
    public void deletePost(@PathVariable("postId") long id){
        postService.deletePost(id);
    }

    @ApiOperation(value = "Update a post")
    @PutMapping("updatePost")
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }
}
