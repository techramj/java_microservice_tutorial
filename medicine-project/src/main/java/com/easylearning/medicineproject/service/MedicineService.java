package com.easylearning.medicineproject.service;

import com.easylearning.medicineproject.bean.Medicine;
import com.easylearning.medicineproject.bean.Patient;
import com.easylearning.medicineproject.dao.MedicineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public List<Medicine> fetchAllMedicine(){
       return medicineDao.findAll();
    }

    public boolean validatePatients(List<Long> ids){
        ResponseEntity<Patient> responseEntity=null;
        for(Long id: ids){
            Map<String,String> uriVariables=new HashMap<>();
            uriVariables.put("id",id+"");
            responseEntity= new RestTemplate().getForEntity(
                    "http://localhost:8000/patient/{id}", Patient.class,uriVariables);
            Patient patient=responseEntity.getBody();
            if(patient==null){
                //valid
                return false;
            }
        }
        return  true;
    }

    public Medicine saveMedicine(Medicine medicine){
        return medicineDao.save(medicine);
    }
}
