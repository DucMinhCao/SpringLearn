package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.model.City;
import com.learn.repository.CityRepository;
import com.learn.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;
	
	public CityServiceImpl(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public Iterable<City> findAll() {
		return cityRepository.findAll();
	}

}
