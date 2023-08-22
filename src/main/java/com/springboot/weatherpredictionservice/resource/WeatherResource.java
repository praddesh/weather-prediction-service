package com.springboot.weatherpredictionservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.weatherpredictionservice.model.WeatherData;

@RestController
public class WeatherResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/forcast/{city}")
	public WeatherData getForcast(@PathVariable String city) {
		String params = city + "/3";
		WeatherData response = restTemplate.getForObject("http://localhost:8080/weather/"+params, WeatherData.class);
		return response;
	}
}
