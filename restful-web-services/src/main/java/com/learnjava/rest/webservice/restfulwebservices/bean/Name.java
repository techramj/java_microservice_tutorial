package com.learnjava.rest.webservice.restfulwebservices.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Name {

    private String firstName;
    private String lastName;
}
