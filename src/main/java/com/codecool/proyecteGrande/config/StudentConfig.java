package com.codecool.proyecteGrande.config;

import com.codecool.proyecteGrande.dao.StudentDao;
import com.codecool.proyecteGrande.dao.implementation.StudentDaoMem;
import com.codecool.proyecteGrande.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public StudentService getStudentService(){
        return new StudentService(getStudentDao());
    }

    @Bean
    public StudentDao getStudentDao(){
        return new StudentDaoMem();
    }
}
