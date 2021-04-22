package com.example.demo.Student;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.DataInput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
//@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping({"/Post"})
    public void registerNewStudent(@RequestBody String st) throws JsonProcessingException, JSONException {

        JSONObject jsonObj = new JSONObject(st);
        String name = jsonObj.getString("name");
        
        LocalDate dt = LocalDate.parse(jsonObj.getString("dob"));

        String mail = jsonObj.getString("email");
        Student a = new Student(name, dt, mail);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Student s = objectMapper.readValue(st, Student.class);

//        int age = jsonObj.getInt("age");
//        System.out.println(age);
          studentService.addNewStudent(a);

//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(a);
    }

    @GetMapping({"/Home"})
    public ModelAndView Home(ModelAndView modelAndView){

        modelAndView.setViewName("Home");

        return modelAndView;
    }
}
