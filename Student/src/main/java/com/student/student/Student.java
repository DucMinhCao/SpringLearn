package com.student.student;

public class Student {
	private String id;
	private String name;
	private double gpa;

	public Student() {}
	
	public Student(String id) {
		super();
		this.id = id;
	}

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Student(String id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
