package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.controller.exception.NoDataFoundException;
import tn.esprit.wellbeingwork.entity.Notification;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.NotificationRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.NotificationService;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public List<Notification> getNotifications()
    {
        List<Notification> notificationList= notificationRepository.findAll();
        for (Notification notification: notificationList){
            log.info("Notification: "+notification);
        }
        return notificationList;
    }

    @Override
    public Notification addNotification(Notification notification) {
        log.info("Adding notification: ");
        return notificationRepository.save(notification);
    }

    @Override
    public Notification findNotificationById(Long id) {
        return notificationRepository.findById(id).
                orElseThrow(NoDataFoundException::new);
    }

}
