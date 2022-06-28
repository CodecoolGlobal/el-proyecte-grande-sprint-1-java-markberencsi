package com.codecool.proyecteGrande.config;

import com.codecool.proyecteGrande.controller.HouseController;
import com.codecool.proyecteGrande.dao.HouseDao;
import com.codecool.proyecteGrande.dao.implementation.HouseDaoMem;
import com.codecool.proyecteGrande.service.HouseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HouseConfig {
    @Bean
    public HouseDao getHouseDao(){
        return new HouseDaoMem();
    }
}
