package com.springboot.weatherpredictionservice.messages;

import com.springboot.weatherpredictionservice.model.WeatherData;

public interface MessageType {
    String getPredictionMessage(WeatherData wData);
   // void setWeatherMessage(WeatherMessage type);
    void setOperator(String operator);
    void setParameter(String parameter);
    void setMessage(String message);
}
