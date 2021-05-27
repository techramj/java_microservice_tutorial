package com.learnjava.rabbitmq.demo.consumer;


import com.learnjava.rabbitmq.demo.config.MessagingConfig;
import com.learnjava.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {


    @RabbitListener(queues = MessagingConfig.QUEUE_NAME)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from the queue: "+orderStatus);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderStatus.setStatus("COMPLETED");
        System.out.println("Message received from the queue: "+orderStatus);
        System.out.println("-----------------------------------------------");




    }

}
