package com.learn.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

//@Entity
public class Project extends AbstractPersistable<Long>{
//	private String name;
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long projectId;
//	
//	@ManyToMany(mappedBy = "projects")
//	private List<User> userList;
//
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Long getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(Long projectId) {
//		this.projectId = projectId;
//	}
}
