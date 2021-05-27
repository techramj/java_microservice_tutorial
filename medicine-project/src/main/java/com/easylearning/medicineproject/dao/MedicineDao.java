package com.easylearning.medicineproject.dao;

import com.easylearning.medicineproject.bean.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineDao extends JpaRepository<Medicine,Long> {
}
