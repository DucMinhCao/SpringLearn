package com.student.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@RequestMapping("/students/{id}")
	public Student findById(@PathVariable String id) {
		return studentService.findStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public void updateStudentByIdEntire(@RequestBody Student student, @PathVariable String id) {
		studentService.updateStudentById(student, id);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/students/{id}") 
	public void updateStudentByIdPartial(@RequestBody Student student, @PathVariable String id) {
		studentService.updateStudentByIdPartial(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudentById(@PathVariable String id) {
		studentService.deleteStudentById(id);
	}
	
	@RequestMapping("/findmax")
	public Student maxGpaStudent() {
		return studentService.findMaxGpa();
	}
}
