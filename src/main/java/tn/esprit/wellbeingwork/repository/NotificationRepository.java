package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {


}
