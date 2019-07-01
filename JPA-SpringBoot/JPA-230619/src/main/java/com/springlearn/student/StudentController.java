package com.springlearn.student;

import com.springlearn.ResourceNotFoundException;
import com.springlearn.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/students")
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @RequestMapping("/students/{id}")
    public Student getStudentById(@PathVariable(value = "id") Integer id) {
        return studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","ID", id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody @Valid Student student) {
        studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public Student updateStudent(@RequestBody @Valid Student student, @PathVariable(name = "id") Integer id) {
        Student needleStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","ID", student));
        needleStudent.setName(student.getName());
        needleStudent.setGpa(student.getGpa());
        needleStudent.setFees(student.getFees());

        Student updatedStudent = studentRepository.save(needleStudent);
        return updatedStudent;
    }

    @RequestMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Integer id) {
        Student needleStudent = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","ID",id));
        studentRepository.delete(needleStudent);
        return ResponseEntity.ok().build();
    }
}
