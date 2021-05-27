package com.learnjava.rest.webservice.restfulwebservices.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rating", nullable = false)
    private String rating;

    private String description;

    @ManyToOne
    private Course course;
}
