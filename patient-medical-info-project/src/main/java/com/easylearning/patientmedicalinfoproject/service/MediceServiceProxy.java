package com.easylearning.patientmedicalinfoproject.service;


import com.easylearning.patientmedicalinfoproject.bean.Medicine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="medicine-project", url="localhost:8100")
public interface MediceServiceProxy {


    //@GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/medicine1")
    public List<Medicine> retriveMedicineWithOUtPatientDetail();

    @GetMapping("/medicine")
    public List<Medicine> retriveMedicineWithPatientDetail();





}
