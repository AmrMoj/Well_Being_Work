package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.wellbeingwork.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
