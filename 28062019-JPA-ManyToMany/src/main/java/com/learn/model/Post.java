package com.learn.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "post_id")
	private Long id;
	private String content;
	private String desciption;
	private Date lastUpdatedAt = new Date();
	private Date postedAt = new Date();
	private String title;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Tag.class, cascade = CascadeType.ALL)
	@JoinTable(name = "post_tags", joinColumns = {@JoinColumn(referencedColumnName = "post_id")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "tag_id")})
	private Set<Tag> tags = new HashSet<>();

	public Post() {}
	
	public Post(String content, String description, String title) {
		this.content = content;
		this.title = title;
		this.desciption = description;
	}
	
	public Post(Long id, String content, String desciption, Date lastUpdatedAt, Date postedAt, String title) {
		this.id = id;
		this.content = content;
		this.desciption = desciption;
		this.lastUpdatedAt = lastUpdatedAt;
		this.postedAt = postedAt;
		this.title = title;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDesciption() {
		return desciption;
	}
	
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	
	public Date getPostedAt() {
		return postedAt;
	}
	
	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
