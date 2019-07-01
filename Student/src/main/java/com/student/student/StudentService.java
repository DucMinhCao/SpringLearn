package com.student.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("1752013", "Cao Minh Duc", 9.2));
        studentList.add(new Student("1752014", "Cao Minh Tri", 6.5));
        studentList.add(new Student("1752015", "Lu Ngoc Chi Cuong", 8.5));
        studentList.add(new Student("1752016", "Dau Phuc Duc", 9.1));
        studentList.add(new Student("1752017", "Vong Khai My", 9.5));
        studentList.add(new Student("1752018", "Luu Pham Manh Ha", 9.7));
        studentList.add(new Student("1752019", "Ngo Thanh Truc", 9.2));
        studentList.add(new Student("1752020", "Mai Bao Tran", 7.6));
        studentList.add(new Student("1752021", "Ngo Chanh Duc", 9.2));
        studentList.add(new Student("1752022", "Cao Van Huan", 8.7));
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    //POST
    public void addStudent(Student student) {
        // TODO Auto-generated method stub
        studentList.add(student);
    }

    //PUT
    public void updateStudentById(Student student, String id) {
        for (Student tempStudent : studentList) {
            if (tempStudent.getId().equals(id)) {
                studentList.set(studentList.indexOf(tempStudent), student);
                return;
            }
        }
    }

    //DELTE
    public void deleteStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                return;
            }
        }
    }

    //PATCH
    public void updateStudentByIdPartial(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                Student newStudent = new Student("PATCH NEW ID", "PATCH NEW NAME", 10.0);
                studentList.set(studentList.indexOf(student), newStudent);
                return;
            }
        }

    }

    public Student findMaxGpa() {
        Student maxGpaStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > maxGpaStudent.getGpa()) {
                maxGpaStudent = student;
            }
        }
        return maxGpaStudent;
    }


}
