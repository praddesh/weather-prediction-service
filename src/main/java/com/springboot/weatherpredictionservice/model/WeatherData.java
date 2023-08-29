package com.springboot.weatherpredictionservice.model;

import java.util.List;

import lombok.Data;

@Data
public class WeatherData {
	private String cod;
	private String message;
	private int cnt;
	private List<WeatherDetails> list;
	private CityDetails city;
	private List<String> weatherMessages;
}

/*
	weathermessages:
		list:
		  -
		    type: [main],[weather],[clouds],[wind],[wind],[visibility],[pop],[rain],[snow]
		    operation: lt,gt,eq
		    parameter: [value]
		    message: [String]
		  -

 */
