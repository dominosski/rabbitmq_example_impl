package com.example.springbootrabbitmqdemo.controller;

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

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
