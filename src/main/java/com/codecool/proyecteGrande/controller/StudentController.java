package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.DTO.StudentDTO;
import com.codecool.proyecteGrande.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


//    @GetMapping("all")
//    public List<Student> getStudents(){
//       return  studentService.getAllStudents();
//    }
    @GetMapping("all")
    public List<StudentDTO> getAllStudents(){
        System.out.println(studentService.getAllStudents());
        return  studentService.getAllStudents();
    }

}
