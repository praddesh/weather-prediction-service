package com.springboot.weatherpredictionservice.resource;

import com.springboot.weatherpredictionservice.configuration.WeatherMessagesConfigProperties;
import com.springboot.weatherpredictionservice.factory.MessageTypeFactory;
import com.springboot.weatherpredictionservice.messages.MessageType;
import com.springboot.weatherpredictionservice.model.WeatherData;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@Slf4j
public class WeatherResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherMessagesConfigProperties configProperties;

	@Autowired
	MessageTypeFactory factory;

	@PostConstruct
	public void updateWeatherMessageType(){

		factory.populateInstanceMap();
		configProperties.getList().forEach(e ->{
			MessageType obj = factory.getWeatherMessageType(e.getType());
			obj.setOperator(e.getOperator());
			obj.setParameter(e.getParameter());
			obj.setMessage(e.getMessage());
			factory.addInstance(e.getType(),obj);
		});
	}

	@GetMapping("/forecast/{city}")
	public WeatherData getForcast(@PathVariable String city) {
		String params = city + "/18";
		WeatherData response = restTemplate.getForObject("http://weather-data-service/weather/"+params, WeatherData.class);
		if(response.getCod().equals("200")) {
			response.setWeatherMessages(new ArrayList<>());
			configProperties.getList().forEach(e -> {
				MessageType messageType = factory.getWeatherMessageType(e.getType());
				if (messageType != null) {
					String message = messageType.getPredictionMessage(response);
					if (message != null) {
						response.getWeatherMessages().add(message);
					}
				}
			});
		}
		return response;
	}
}
