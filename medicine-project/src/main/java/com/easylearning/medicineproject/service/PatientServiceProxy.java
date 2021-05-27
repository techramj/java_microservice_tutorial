package com.easylearning.medicineproject.service;

import com.easylearning.medicineproject.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient", url = "localhost:8000")
public interface PatientServiceProxy {

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id);
}
