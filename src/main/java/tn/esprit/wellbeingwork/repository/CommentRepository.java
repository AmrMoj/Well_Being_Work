package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.wellbeingwork.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
