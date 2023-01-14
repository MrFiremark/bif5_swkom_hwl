package at.fhtw.swen3.notification.service.impl;

import at.fhtw.swen3.notification.model.Notification;
import at.fhtw.swen3.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendPushNotification(Notification notification) {
        String expoPushToken = "ExponentPushToken[BLO-nqOVMqTrzZULkiycd8]";
        String message = "{\"to\":\"" + expoPushToken + "\", \"title\":\"Expo Test!\", \"body\":\"Hello World!\", \"data\":{\"customData\":\"" + notification.getParcel().getTrackingId() + "\"}}";
        String url = "https://exp.host/--/api/v2/push/send";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
