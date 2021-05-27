package com.example.java8.demo1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Trader {

    private final String name;
    private final String city;

}
