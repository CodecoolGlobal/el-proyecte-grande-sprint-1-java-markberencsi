package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.model.Student;
import com.codecool.proyecteGrande.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;


    @GetMapping("students")
    public List<Student> getStudents(){
       return  studentService.getAllStudents();
    }

}
