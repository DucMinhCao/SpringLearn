package com.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learn.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	@Query(value = "SELECT p FROM Person p WHERE p.lastName=?1")
	List<Person> getPersonInfoByLastName(String lastname);
	
	@Query(value = "SELECT p FROM Person p WHERE p.id = ?1")
	Person getPersonInfoById(int id);
}
