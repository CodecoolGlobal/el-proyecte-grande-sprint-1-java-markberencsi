package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.model.Teacher;
import com.codecool.proyecteGrande.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> getTeachers(){
        return teacherService.getAll();
    }
}
