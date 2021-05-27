package com.easylearning.patientmedicalinfoproject.controller;


import com.easylearning.patientmedicalinfoproject.bean.Medicine;
import com.easylearning.patientmedicalinfoproject.bean.Patient;
import com.easylearning.patientmedicalinfoproject.service.PatientAndMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalPatientController {

    @Autowired
    private PatientAndMedicalService patientAndMedicalService;


    @GetMapping("/medicine")
    public List<Medicine>  retreiveAllMedicine(){
        return patientAndMedicalService.retreiveMedicine();
    }


    @GetMapping("/patient")
    public List<Patient> retreiveAllPatient(){
        return  patientAndMedicalService.fetchPatientDetails();
    }


}
