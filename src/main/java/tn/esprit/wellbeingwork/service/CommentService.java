package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> retrieveAllComments();

    Comment addComment(Comment p);

    void deleteComment(Long id);

    Comment updateComment(Comment c);

    Comment retrieveComment(Long id);
}
