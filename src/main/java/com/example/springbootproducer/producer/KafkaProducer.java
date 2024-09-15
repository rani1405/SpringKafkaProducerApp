package com.example.springbootproducer.producer;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {


    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    public String topicName;

    @EventListener(ApplicationReadyEvent.class)
    public void send() {

        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(topicName, "Hello-" + i);
        }
        log.info("Message successfully sent!!");
    }
}
