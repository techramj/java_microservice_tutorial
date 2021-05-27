package com.easylearning.medicineproject.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Patient {

    private Long id;
    private String name;
    private String request;

}
