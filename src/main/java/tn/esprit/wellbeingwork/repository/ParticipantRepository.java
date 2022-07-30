package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Event;
import tn.esprit.wellbeingwork.entity.Participant;
import tn.esprit.wellbeingwork.entity.User;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query(
            "SELECT u from User u " +
                    "join Participant p ON p.userParticipant=u " +
                    "where p.event=:idEvent and u.address like CONCAT('%',:address,'%')"
    )
    List<User> findUserWithMatchingAddress (@Param("idEvent") Event event, @Param("address") String address );
}
