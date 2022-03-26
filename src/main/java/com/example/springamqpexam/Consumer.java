package com.example.springamqpexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
    private static final String QUEUE_NAME = "order.queue";

    @RabbitListener(queues = QUEUE_NAME)
    public void consumer(Message message){
        log.info("Rabbitmq consumer msg : {}", message.toString());
    }
}
