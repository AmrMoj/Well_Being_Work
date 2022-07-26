package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.entity.User;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
    public Collaborator findByUser(User user);

}
