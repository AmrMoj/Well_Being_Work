package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.EventCatego;

@Repository
public interface EventCategoRepository extends JpaRepository<EventCatego, Long> {

}
