package com.example.rabbitmqstarter.publisher;

import com.example.rabbitmqstarter.config.MessageConfig;
import com.example.rabbitmqstarter.dto.Order;
import com.example.rabbitmqstarter.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{name}")
    public String bookOrder(@RequestBody Order order, @PathVariable String name) {
        order.setOrderId(UUID.randomUUID().toString());
        // 레스토랑 서비스 로직이 있다고 가정
        // 결제 서비스 수행했다고 가정

        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "주문이 " + name + "에 성공적으로 접수됐습니다.");
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);

        return "Success !!";
    }
}
