package com.example.springamqpexam;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    private static final String QUEUE_NAME = "order.queue";

    @Autowired
    RabbitTemplate rabbitTemplate;


    @GetMapping("/send")
    public String sendMsg(@RequestParam String msg){
        rabbitTemplate.convertAndSend(QUEUE_NAME, msg);
        return "OK";
    }
}
