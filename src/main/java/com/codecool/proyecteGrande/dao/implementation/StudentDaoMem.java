package com.codecool.proyecteGrande.dao.implementation;

import com.codecool.proyecteGrande.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoMem {
    List<Student> students;

    public StudentDaoMem() {
        students = new ArrayList<>();
        fillWithDummy();
    }

    private void fillWithDummy() {
        Student student1 = new Student("Harry", "Potter", "harrypotter@hogwarts.com", "Voldemort");
        Student student2 = new Student("Ron", "Weasley", "ronweasley@hogwarts.com", "ron123");
        students.add(student1);
        students.add(student2);
    }

    public void add(Student newStudent) {
        students.add(newStudent);
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }


}
