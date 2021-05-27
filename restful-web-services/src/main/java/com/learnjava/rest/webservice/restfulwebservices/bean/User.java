package com.learnjava.rest.webservice.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
//@JsonFilter("userFilter")
public class User {

    private Integer id;

    @Size(max = 6, min = 3, message = "Name mus be between 3 to 10 char long")
    private String name;

    //@JsonIgnore //use for static filtering of the field
    private Date birthDate;


}
