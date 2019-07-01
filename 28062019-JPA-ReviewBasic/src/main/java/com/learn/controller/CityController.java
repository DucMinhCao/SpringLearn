package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.City;
import com.learn.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/findall")
	public Iterable<City> getAllCity() {
		return cityService.findAll();
	}
}
