package at.fhtw.swen3.notification.producer;

import at.fhtw.swen3.notification.model.Notification;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification-demo")
public class NotificationProducerController {
    @Autowired
    private KafkaTemplate<String, Notification> kafkaTemplate;

    @GetMapping(produces = "application/json")
    public String parcelNotification(ParcelEntity parcelEntity) {
        Notification notification = Notification.builder()
                .id(parcelEntity.getTrackingId())
                .parcel(parcelEntity)
                .build();
        kafkaTemplate.send("topicName", notification);
        return "Hello World.";
    }
}