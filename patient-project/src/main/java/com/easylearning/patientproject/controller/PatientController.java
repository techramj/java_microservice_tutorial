package com.easylearning.patientproject.controller;


import com.easylearning.patientproject.bean.Patient;
import com.easylearning.patientproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List <Patient >getPatients(){
        return patientService.fetchAllPatient();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id){
        System.out.println("Id: "+id);
        return patientService.getPatientById(id);
    }
}
