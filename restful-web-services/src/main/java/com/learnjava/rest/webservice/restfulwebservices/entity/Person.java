package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@NamedQuery(name = "find_all_person",query= "select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    private String location;

    private Date birthDate;

    public Person(String name,String location, Date birthDate){
        this.name = name;
        this.location = location;
        this.birthDate =birthDate;
    }


}
