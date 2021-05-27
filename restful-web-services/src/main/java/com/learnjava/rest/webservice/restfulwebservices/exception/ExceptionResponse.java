package com.learnjava.rest.webservice.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;


}
