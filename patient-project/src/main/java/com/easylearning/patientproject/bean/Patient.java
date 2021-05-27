package com.easylearning.patientproject.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Patient(String name){
        this.name=name;
    }
}
