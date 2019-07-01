package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{

}
