package at.fhtw.swen3.notification.service;

import at.fhtw.swen3.notification.model.Notification;

public interface NotificationService {
    void sendPushNotification(Notification notification);
}
