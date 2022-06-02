package com.codecool.proyecteGrande.config;

import com.codecool.proyecteGrande.dao.TeacherDao;
import com.codecool.proyecteGrande.dao.implementation.TeacherDaoMem;
import com.codecool.proyecteGrande.service.TeacherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {
    @Bean
    public TeacherDao getTeacherDao(){
        return new TeacherDaoMem();
    }

    @Bean
    public TeacherService getTeacherService(){
        return new TeacherService(getTeacherDao());
    }
}
