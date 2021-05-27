package com.easylearning.patientproject.service;

import com.easylearning.patientproject.bean.Patient;
import com.easylearning.patientproject.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    public Patient savePatient(Patient patient){
        return patientDao.save(patient);
    }

    public List<Patient> fetchAllPatient() {
        return patientDao.findAll();
    }

    public Patient getPatientById(Long id){
        Optional<Patient> byId = patientDao.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }




}
