package net.arame.notificationservice.kafka;

import net.arame.notificationservice.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "user-events", groupId = "notification-group")
    public void consume(User user) {
        System.out.println("📥 Notification reçue pour nouvel utilisateur : " +
                user.getName() + " <" + user.getEmail() + ">");
    }
}
