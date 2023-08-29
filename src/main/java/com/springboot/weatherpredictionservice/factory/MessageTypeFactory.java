package com.springboot.weatherpredictionservice.factory;

import com.springboot.weatherpredictionservice.messages.MessageType;
import com.springboot.weatherpredictionservice.messages.Messages;
import com.springboot.weatherpredictionservice.messages.impl.MainMessage;
import com.springboot.weatherpredictionservice.messages.impl.WeatherMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MessageTypeFactory {

    HashMap<String, MessageType> instanceMap = new HashMap<>();

    public void populateInstanceMap(){
        instanceMap.put(Messages.MAIN,new MainMessage());
        instanceMap.put(Messages.WEATHER,new WeatherMessage());
    }
    public void addInstance(String type, MessageType instance){
        instanceMap.put(type,instance);
    }

    public MessageType getWeatherMessageType(String type){
        MessageType messageType = null;
        switch (type){
            case Messages.MAIN -> {
                messageType = instanceMap.get(Messages.MAIN);
            }
            case Messages.WEATHER -> {
                messageType = instanceMap.get(Messages.WEATHER);
            }
        }

        return messageType;
    }
}
