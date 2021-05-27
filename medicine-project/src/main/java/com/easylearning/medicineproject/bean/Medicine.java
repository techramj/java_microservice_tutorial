package com.easylearning.medicineproject.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@JsonFilter("medicineFilter")
public class Medicine {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    //@JsonIgnore
    @ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
    private List<Long> patientId;

    public Medicine(String name){
        this.name=name;
    }
}
