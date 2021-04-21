package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentReponsitory studentReponsitory){
        return args->{
            Student PhuCuong = new Student(
                    "Phú Cường",
                    LocalDate.of(1999, Month.OCTOBER, 8),
                    "cv9cuong@gmail.com"
            );

            Student Alex = new Student(
                    "Alex",
                    LocalDate.of(2000, Month.OCTOBER, 11),
                    "Alex@gmail.com"
            );
            ArrayList<Student> st = new ArrayList<Student>();
            st.add(PhuCuong);
            st.add(Alex);
            studentReponsitory.saveAll(st);
        };
    }
}
