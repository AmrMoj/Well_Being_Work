package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.entity.Publicity;
import tn.esprit.wellbeingwork.entity.User;

@Repository
public interface PublicityRepository extends JpaRepository<Publicity, Long> {

}
