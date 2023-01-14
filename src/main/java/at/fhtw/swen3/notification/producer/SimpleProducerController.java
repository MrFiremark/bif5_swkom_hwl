package at.fhtw.swen3.notification.producer;/*
package at.fhtw.swen3.notification.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
public class SimpleProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(produces = "application/json")
    public String getHelloWorld() {
        kafkaTemplate.send("topicName", "Hello World");
        return "Hello World.";
    }

}

 */
