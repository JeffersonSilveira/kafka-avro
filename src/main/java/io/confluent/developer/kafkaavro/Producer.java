package io.confluent.developer.kafkaavro;

import ch.qos.logback.classic.Logger;
import io.confluent.developer.User;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Producer Logger")
public class Producer {

    private static final String TOPIC = "users";

    @Autowired
    private  KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        kafkaTemplate.send(TOPIC, user.getName(), user);
        log.info(String.format("Produced user -> %s", user));
    }
}
