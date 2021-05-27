package com.learnjava.rabbitmq.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class RabbitmqDemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
       // SpringApplication.run(RabbitmqDemoApplication.class, args);
        System.out.println(Math.abs(-7.5));
        ConcurrentHashMap chm=new ConcurrentHashMap();
        chm.put(1,"welcome");
        chm.put(2,"to");
        chm.put(3,"java");
        chm.put(4,"world");
        chm.putIfAbsent(3,"world");
        //chm.remove(2,"to");
        chm.replace(3,"java","java8");
        System.out.println(chm);

    }



    @Override
    public void run(String... args) throws Exception {

    }
}
