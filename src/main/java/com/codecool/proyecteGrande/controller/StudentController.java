package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.model.Student;
import com.codecool.proyecteGrande.model.StudentEntity;
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


//    @GetMapping("all")
//    public List<Student> getStudents(){
//       return  studentService.getAllStudents();
//    }
    @GetMapping("all")
    public List<StudentEntity> getAllStudents(){
        return  studentService.getAll();
    }

    @GetMapping("{id}")
    public StudentEntity getStudentById(@PathVariable Long id){

        return studentService.getStudentById(id).isPresent() ? studentService.getStudentById(id).get() : null;}
}
