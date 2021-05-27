package com.easylearning.patientmedicalinfoproject.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Medicine {

    private Long id;
    private String name;
    private List<Long> patientId;

}
