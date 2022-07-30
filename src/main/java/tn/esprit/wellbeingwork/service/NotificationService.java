package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getNotifications();

    Notification addNotification(Notification notification);
    Notification findNotificationById(Long id);

}
