package com.example.springbootrabbitmqdemo.controller;

import com.example.springbootrabbitmqdemo.DTO.User;
import com.example.springbootrabbitmqdemo.publisher.RabbitMQJsonProducer;
import com.example.springbootrabbitmqdemo.publisher.RabbitMQProducer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Data
@AllArgsConstructor
public class MessageController {
    private RabbitMQProducer producer;
    private RabbitMQJsonProducer jsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @PostMapping("/publish/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON message sent to RabbitMQ");
    }
}
