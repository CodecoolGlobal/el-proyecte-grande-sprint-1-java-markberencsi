package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.TeacherDao;
import com.codecool.proyecteGrande.model.Subject;
import com.codecool.proyecteGrande.model.Teacher;
import com.codecool.proyecteGrande.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        addDummyDataToDb();
    }

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    private void addDummyDataToDb(){
        teacherRepository.save(new Teacher(1L, "Severus", "Snape", "ilovesnakes@hotmail.com","python", Subject.DEFENSE_AGAINST_DARK_ARTS ));
        teacherRepository.save(new Teacher(2L,"Dolores","Umbridge","f*ckharrybutnotsexually@citromail.hu","pinkzebra999",Subject.DEFENSE_AGAINST_DARK_ARTS ));
        teacherRepository.save(new Teacher(3L, "Rubeus","Hagrid","rubeus.hagrid@gmail.com","MissYouFluffy",Subject.HERBOLOGY));
    }
}
