package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee  {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(nullable = false)
    private String name;

    public Employee(String name){
        this.name=name;
    }

}
