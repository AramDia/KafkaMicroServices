package net.arame.userservice.controller;

import lombok.RequiredArgsConstructor;
import net.arame.userservice.kafka.UserProducer;
import net.arame.userservice.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserProducer userProducer;

    @PostMapping
    public String createUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        userProducer.sendUserCreated(user);
        return "User created and event sent!";
    }
}
