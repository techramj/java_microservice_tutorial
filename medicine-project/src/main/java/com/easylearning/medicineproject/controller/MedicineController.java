package com.easylearning.medicineproject.controller;


import com.easylearning.medicineproject.bean.CustomResponseBody;
import com.easylearning.medicineproject.bean.Medicine;
import com.easylearning.medicineproject.bean.Patient;
import com.easylearning.medicineproject.service.MedicineService;
import com.easylearning.medicineproject.service.PatientServiceProxy;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @GetMapping("/medicine")
    public List<Medicine> fetchAllMedicine(){
        return medicineService.fetchAllMedicine();
    }

   /* @GetMapping("/medicine")
    public MappingJacksonValue fetchAllMedicine(){
        List<Medicine> medicines = medicineService.fetchAllMedicine();
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.serializeAll();

        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("medicineFilter",filter);
        MappingJacksonValue mapping =  new MappingJacksonValue(medicines);

        mapping.setFilters(filterProvider);
        return mapping;
    }

    @GetMapping("/medicine1")
    public MappingJacksonValue fetchAllMedicine1(){
        List<Medicine> medicines = medicineService.fetchAllMedicine();
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id","name");

        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("medicineFilter",filter);
        MappingJacksonValue mapping =  new MappingJacksonValue(medicines);

        mapping.setFilters(filterProvider);
        return mapping;
    }*/


   @PostMapping("/medicine")
    public Medicine saveMedicine(@RequestBody Medicine medicine){
        Long patientId = medicine.getPatientId().get(0);
        Patient patientById = patientServiceProxy.getPatientById(patientId);



        System.out.println(patientById);

        return medicine;
    }

    @PostMapping("/medicine1")
    public Medicine saveMedicine1(@RequestBody Medicine medicine){

       if(medicine.getPatientId()!=null && medicineService.validatePatients(medicine.getPatientId())){
           medicineService.saveMedicine(medicine);
       }
       return medicine;
    }


    @PostMapping("/medicine2")
    public ResponseEntity<CustomResponseBody> saveMedicine2(@RequestBody Medicine medicine){
        Long patientId = medicine.getPatientId().get(0);


        Map<String,String> uriVariables=new HashMap<>();
        uriVariables.put("id",patientId+"");
        ResponseEntity<CustomResponseBody> customEntity=null;

        ResponseEntity<Patient> responseEntity= new RestTemplate().getForEntity(
                "http://localhost:8000/patient/{id}", Patient.class,uriVariables);

        Patient patient=responseEntity.getBody();
        System.out.println(patient);
        if(patient!=null){
            CustomResponseBody body=new CustomResponseBody(medicine,"SUCCESS","Data saved Sucessfuly");
            customEntity=new ResponseEntity<>(body, HttpStatus.CREATED);
        }else{
            CustomResponseBody body=new CustomResponseBody(medicine,"ERROR","Invalid PatientId: "+patientId);
            customEntity=new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        return customEntity;
    }


}
