package com.learn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Movie.class, cascade = CascadeType.ALL, mappedBy = "author")
	private Set<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovie() {
		return movies;
	}

	public void setMovie(Set<Movie> movies) {
		this.movies = movies;
	}
	
	
}
