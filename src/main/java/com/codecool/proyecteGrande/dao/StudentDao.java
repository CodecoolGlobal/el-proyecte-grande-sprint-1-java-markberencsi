package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.Student;

import java.util.List;

public interface StudentDao {
    public void add(Student newStudent);
    public List<Student> getAll();
}
