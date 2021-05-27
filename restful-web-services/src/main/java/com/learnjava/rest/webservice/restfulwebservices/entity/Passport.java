package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@NamedQuery(name = "get_all_passport", query = "select p from Passport  p")
@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long  id;

    @Column(name = "passport_no")
    private String  passportNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy ="passport" )
    private Student student;

    public Passport(String passportNumber){
        this.passportNumber=passportNumber;
    }



}
