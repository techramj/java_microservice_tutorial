package com.easylearning.patientmedicalinfoproject.service;


import com.easylearning.patientmedicalinfoproject.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="patient", url="localhost:8000")
public interface PatientServiceProxy {

    @GetMapping("/patient")
    public List<Patient> retriveAllPatient();

}
