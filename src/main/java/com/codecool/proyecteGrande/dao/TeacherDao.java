package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.Subject;
import com.codecool.proyecteGrande.model.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Teacher teacher);

    void addTeacher(String firstName, String lastName, String email, String password, Subject taughtSubject);

    void removeTeacherById(int id);

    void updateTeacher(int id, Subject newTaughtSubject);

    List<Teacher> getAll();
    Teacher getTeacherById(int id);
}
