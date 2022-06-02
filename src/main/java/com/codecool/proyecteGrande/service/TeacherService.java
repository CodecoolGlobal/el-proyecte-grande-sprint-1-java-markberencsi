package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.TeacherDao;
import com.codecool.proyecteGrande.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public List<Teacher> getAll(){
        return teacherDao.getAll();
    }
}
