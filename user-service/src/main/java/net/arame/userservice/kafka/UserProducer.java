package net.arame.userservice.kafka;

import lombok.RequiredArgsConstructor;
import net.arame.userservice.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendUserCreated(User user) {
        kafkaTemplate.send("user-events", user);
    }

}
