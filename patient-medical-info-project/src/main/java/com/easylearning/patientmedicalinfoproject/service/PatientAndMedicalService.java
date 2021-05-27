package com.easylearning.patientmedicalinfoproject.service;

import com.easylearning.patientmedicalinfoproject.bean.Medicine;
import com.easylearning.patientmedicalinfoproject.bean.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientAndMedicalService {

    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @Autowired
    private MediceServiceProxy mediceServiceProxy;

    public List<Patient> fetchPatientDetails(){
        return patientServiceProxy.retriveAllPatient();
    }

    public List<Medicine> retreiveMedicine(){
        return mediceServiceProxy.retriveMedicineWithOUtPatientDetail();
    }

    public List<Medicine> fetchMedicineDetailOfPatient(String patientId){

        return null;
    }

}
