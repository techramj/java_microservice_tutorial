package com.easylearning.patientmedicalinfoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PatientMedicalInfoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMedicalInfoProjectApplication.class, args);
    }

}
