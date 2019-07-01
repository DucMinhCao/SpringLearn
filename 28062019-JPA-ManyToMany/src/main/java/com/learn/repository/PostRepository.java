package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
