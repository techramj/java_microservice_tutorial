package com.example.java8.demo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString

public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;
}
