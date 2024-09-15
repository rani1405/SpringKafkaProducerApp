package com.example.springbootproducer.controller;


import com.example.springbootproducer.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/postEvents")
    public void postEvents() {
        kafkaProducer.sendMessage1();
        kafkaProducer.sendMessage2();
    }

}
