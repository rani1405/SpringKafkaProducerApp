package com.example.springbootproducer.producer;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {


    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name1}")
    public String topicName1;

    @Value("${topic.name2}")
    public String topicName2;

    @Value("${topic.name3}")
    public String topicName3;

//    @EventListener(ApplicationReadyEvent.class)
    @Async
    public void sendMessage1() {

        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(topicName1, "Hello-" + i);
            log.info("Thread Name in sendMessage1-"+Thread.currentThread().getName());
            log.info("Message successfully sent!!" + topicName1);
        }

    }

    @Async
    public void sendMessage2() {

        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(topicName2, "Hey-" + i);
            log.info("Thread Name in sendMessage2 -"+Thread.currentThread().getName());
            log.info("Message successfully sent to topic- " + topicName2);
        }

    }


    @Async
    public void sendMessage3() {

        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(topicName3, "bonjour-" + i);
            log.info("Thread Name in sendMessage3 -"+Thread.currentThread().getName());
            log.info("Message successfully sent to topic! " + topicName3);
        }

    }
}
