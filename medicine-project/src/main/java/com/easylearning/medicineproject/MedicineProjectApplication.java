package com.easylearning.medicineproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MedicineProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineProjectApplication.class, args);
    }

}
