package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.model.Post;
import com.learn.model.Tag;
import com.learn.repository.PostRepository;
import com.learn.repository.TagRepository;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired TagRepository tagRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAll();
		tagRepository.deleteAll();
		Post post = new Post("Hibernate Many to Many Example with Spring Boot","Learn How to map a many to many relationship using hibernate","Minh Duc Cao");
		Tag tag1 = new Tag("Spring boot");
		Tag tag2 = new Tag("Hibernate");
		
		post.getTags().add(tag1);
		post.getTags().add(tag2);
		
		tag1.getPosts().add(post);
		tag2.getPosts().add(post);
		
		postRepository.save(post);
	}

}
