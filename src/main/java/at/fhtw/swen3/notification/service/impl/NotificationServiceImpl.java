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
        String expoPushToken = notification.getParcel().getSender().getExpoPushToken();
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("{\"to\":\"" + expoPushToken + "\",");
        messageBuilder.append("\"title\":\"Parcel update!\",");
        messageBuilder.append("\"body\":\"Parcel " + notification.getParcel().getTrackingId() +"\",");
        messageBuilder.append("\"data\":{\"trackingId\":\"" + notification.getParcel().getTrackingId() + "\", \"ParcelState\":\"" + notification.getParcel().getState().name() + "\"}}");
        //String message = "{\"to\":\"" + expoPushToken + "\", \"title\":\"Expo Test!\", \"body\":\"Hello World!\", \"data\":{\"trackingId\":\"" + notification.getParcel().getTrackingId() + "\", \"ParcelState\":\"" + notification.getParcel().getState().name() + "\"}}";
        String url = "https://exp.host/--/api/v2/push/send";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(messageBuilder.toString()))
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
