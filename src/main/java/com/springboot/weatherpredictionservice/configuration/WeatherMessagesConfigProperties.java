package com.springboot.weatherpredictionservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix="weathermessages")
@Data
public class WeatherMessagesConfigProperties {
    List<MessageConfig> list;
}
