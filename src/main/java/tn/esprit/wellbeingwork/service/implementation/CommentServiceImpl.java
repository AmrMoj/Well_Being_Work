package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Comment;
import tn.esprit.wellbeingwork.repository.CommentRepository;
import tn.esprit.wellbeingwork.service.CommentService;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> retrieveAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment c) {
        return commentRepository.save(c);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateComment(Comment c) {
        return commentRepository.save(c);
    }

    @Override
    public Comment retrieveComment(Long id) {
        return commentRepository.findById(id).get();
    }
}
