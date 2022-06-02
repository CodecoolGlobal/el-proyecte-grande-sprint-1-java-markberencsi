package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.StudentDao;
import com.codecool.proyecteGrande.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    StudentDao studentDao;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAll();
    }
}
