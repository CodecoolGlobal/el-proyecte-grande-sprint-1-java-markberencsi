package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.StudentDao;
import com.codecool.proyecteGrande.model.Student;

import java.util.List;

public class StudentService {
    StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAll();
    }
}
