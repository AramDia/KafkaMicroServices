package net.arame.notificationservice.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  net.arame.notificationservice.model.User;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserDeSerializer implements Deserializer<User> {
    @Override
    public User deserialize(String s, byte[] data) {
        try {
            return new ObjectMapper().readValue(new String(data),User.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}