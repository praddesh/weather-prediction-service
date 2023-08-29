package com.springboot.weatherpredictionservice.configuration;

import lombok.Data;

@Data
public class MessageConfig {
    private String type;
    private String operator;
    private String parameter;
    private String message;
}
