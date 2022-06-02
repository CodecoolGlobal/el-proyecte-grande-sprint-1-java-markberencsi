package com.codecool.proyecteGrande.dao.implementation;

import com.codecool.proyecteGrande.dao.TeacherDao;
import com.codecool.proyecteGrande.model.Subject;
import com.codecool.proyecteGrande.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoMem implements TeacherDao {

    private final List<Teacher> teachers = new ArrayList<>();

    @Override
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    @Override
    public void addTeacher(String firstName, String lastName, String email, String password, Subject taughtSubject){
        teachers.add(new Teacher(firstName,lastName,email,password,taughtSubject));
    }
    @Override
    public void removeTeacherById(int id){
        Teacher teacherToRemove = getTeacherById(id);
        if(teacherToRemove != null) teachers.remove(teacherToRemove);
    }

    @Override
    public void updateTeacher(int id, Subject newTaughtSubject) {
        getTeacherById(id).setTaughtSubject(newTaughtSubject);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher getTeacherById(int id) {
        for(Teacher t : teachers){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

}
