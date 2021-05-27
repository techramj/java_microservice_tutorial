package com.easylearning.microservices.limitsservice;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service" )
@NoArgsConstructor
@Data
public class Configuration {
    private int minimum;
    private int maximum;
}
