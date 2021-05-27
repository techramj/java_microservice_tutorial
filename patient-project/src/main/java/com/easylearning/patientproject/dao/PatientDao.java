package com.easylearning.patientproject.dao;

import com.easylearning.patientproject.bean.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao  extends JpaRepository<Patient,Long> {

}
