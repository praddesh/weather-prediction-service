package com.springboot.weatherpredictionservice.model;

import lombok.Data;

@Data
public class WeatherForcast {
	private String main;
	private String description;
	private String icon;
}
