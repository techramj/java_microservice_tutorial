package com.learnjava.rabbitmq.demo.publisher;


import com.learnjava.rabbitmq.demo.config.MessagingConfig;
import com.learnjava.rabbitmq.demo.dto.Order;
import com.learnjava.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{resturantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String resturantName){
        order.setOrderId(UUID.randomUUID().toString());

        //ressturantService
        //payementService

        OrderStatus status=new OrderStatus(order,"PROCESS","Order places successfully in Resturant "+resturantName);
        template.convertAndSend(MessagingConfig.EXCHANGE_NAME,MessagingConfig.ROUTING_KEY,status);
        return "Order Booked";
    }
}
