package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.StudentDao;
import com.codecool.proyecteGrande.dao.StudentRepository;
import com.codecool.proyecteGrande.model.Student;
import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentService {
    StudentDao studentDao;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAll();
    }

    public List<StudentEntity> getAll(){
        return studentRepository.findAllByOrderByIdAsc();
    }

    public Optional<StudentEntity> getStudentById(Long id){return studentRepository.findById(id);}
}
