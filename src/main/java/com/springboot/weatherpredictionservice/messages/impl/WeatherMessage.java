package com.springboot.weatherpredictionservice.messages.impl;

import com.springboot.weatherpredictionservice.messages.MessageType;
import com.springboot.weatherpredictionservice.model.WeatherData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Data
@Slf4j
public class WeatherMessage implements MessageType {
    private String type="weather";
    private String operator;
    private String parameter;
    private String message;


    @Override
    public String getPredictionMessage(WeatherData wData) {
        final String[] message = {null};
        Predicate<String> condition = i-> (i.equalsIgnoreCase(parameter));
        try{
        if(wData.getList() != null) {
            wData.getList().forEach(e -> {
                e.getWeather().forEach(element -> {
                    if (condition.test(element.getMain())) {
                        message[0] = this.message;
                    }
                });
            });
        }
        } catch(Exception e){
            log.info("[WPS] Exception while retrieving message: " + e.getMessage());
        }
        return message[0];
    }
}
