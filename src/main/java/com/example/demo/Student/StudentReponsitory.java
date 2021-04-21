package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentReponsitory extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.Email = ?1")
    Optional<Student> findStudentByEmail(String email);
}

