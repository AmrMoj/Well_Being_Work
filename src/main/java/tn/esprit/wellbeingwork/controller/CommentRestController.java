package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Comment;
import tn.esprit.wellbeingwork.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("comment")
@Api(tags = "Comment management")
public class CommentRestController {

    @Autowired
    CommentService commentService;

    @ApiOperation(value="Add new comment")
    @PostMapping("addComment")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @ApiOperation(value = "Get all comments")
    @GetMapping("getAllComments")
    public List<Comment> retrieveAllComments(){
        return commentService.retrieveAllComments();
    }

    @ApiOperation(value = "Get a comment")
    @GetMapping("getComment/{commentId}")
    public Comment retrieveComment(@PathVariable("postId") long id){
        return commentService.retrieveComment(id);
    }

    @ApiOperation(value = "Delete a post")
    @DeleteMapping("deletePost/{postId}")
    public void deleteComment(@PathVariable("postId") long id){
        commentService.deleteComment(id);
    }

    @ApiOperation(value = "Update a comment")
    @PutMapping("updateComment")
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }
}
