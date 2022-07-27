package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.DTO.StudentDTO;
import com.codecool.proyecteGrande.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("all")
    public List<StudentDTO> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentEntity getStudentById(@PathVariable Long id){

        return studentService.getStudentById(id).isPresent() ? studentService.getStudentById(id).get() : null;}
}
