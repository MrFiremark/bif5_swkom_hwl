package at.fhtw.swen3.notification.consumer;

import at.fhtw.swen3.notification.model.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationKafkaConsumer {

    @KafkaListener(topics = "topicName", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(Notification message) {
        System.out.println("Received Message: " + message.getParcel().getTrackingId());
    }
}
