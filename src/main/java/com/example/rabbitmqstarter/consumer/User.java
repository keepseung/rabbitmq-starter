package com.example.rabbitmqstarter.consumer;

import com.example.rabbitmqstarter.config.MessageConfig;
import com.example.rabbitmqstarter.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("큐에게 받은 메세지 = " + orderStatus);
    }
}
