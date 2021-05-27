package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PartTimeEmployee extends  Employee {

    private BigDecimal hourlyWage;

    private PartTimeEmployee(String name, BigDecimal hourlyWage){
        super(name);
    }
}
