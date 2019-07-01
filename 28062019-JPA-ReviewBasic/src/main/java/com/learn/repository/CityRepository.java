package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.City;

public interface CityRepository extends CrudRepository<City, Long>{

}
