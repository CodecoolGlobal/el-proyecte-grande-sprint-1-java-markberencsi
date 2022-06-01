package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.Student;

import java.util.List;

public interface StudentDao {
     void add(Student newStudent);
     List<Student> getAll();


}
