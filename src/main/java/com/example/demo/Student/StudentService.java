package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentReponsitory studentReponsitory;
    @Autowired
    public StudentService(StudentReponsitory studentReponsitory){

        this.studentReponsitory = studentReponsitory;
    }

    public List<Student> getStudent(){

        return studentReponsitory.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail =
                studentReponsitory.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentReponsitory.save(student);
    }
}
