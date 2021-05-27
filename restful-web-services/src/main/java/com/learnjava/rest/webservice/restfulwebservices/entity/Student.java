package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString
@NamedQuery(name = "get_all_student", query = "select s from Student  s")
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Passport passport;

    public Student(String name){
        this.name=name;
    }


}
