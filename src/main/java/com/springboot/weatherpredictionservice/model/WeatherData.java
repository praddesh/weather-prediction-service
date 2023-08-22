package com.springboot.weatherpredictionservice.model;

import java.util.List;

import lombok.Data;

@Data
public class WeatherData {
	private String message;
	private int cnt;
	private List<WeatherDetails> list;
	private CityDetails city;
}
