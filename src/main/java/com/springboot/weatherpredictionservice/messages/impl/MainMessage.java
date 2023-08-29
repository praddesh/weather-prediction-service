package com.springboot.weatherpredictionservice.messages.impl;

import com.springboot.weatherpredictionservice.messages.MessageType;
import com.springboot.weatherpredictionservice.model.WeatherData;
import lombok.Data;

import java.util.function.Predicate;

@Data
public class MainMessage implements MessageType {
    private String type = "main";
    private String operator;
    private String parameter;
    private String message;


    @Override
    public String getPredictionMessage(WeatherData wData) {
        final String[] message = {null};
        Predicate<Float> condition = operator.equals(">")? i-> (i>Float.valueOf(parameter)) : i-> (i<=Float.valueOf(parameter));
        wData.getList().forEach(e -> {
            if (condition.test(Float.valueOf(e.getMain().getTemp()))){
                message[0] = this.message;
            }
        });

        return message[0];

    }
}
