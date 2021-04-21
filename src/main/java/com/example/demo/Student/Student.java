package com.example.demo.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int ID;
    private String Name;
    private LocalDate Dob;
    private String Email;
    @Transient
    private int Age;


    public Student() {
    }

    public Student(int ID, String name, LocalDate dob, String email) {
        this.ID = ID;
        Name = name;
        Dob = dob;
        Email = email;
    }

    public Student(String name, LocalDate dob, String email) {
        Name = name;
        Dob = dob;
        Email = email;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Period.between(this.Dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Dob=" + Dob +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                '}';
    }
}
