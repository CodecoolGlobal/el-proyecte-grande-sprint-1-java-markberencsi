package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.HouseDao;
import com.codecool.proyecteGrande.dao.HouseRepository;
import com.codecool.proyecteGrande.model.House;
import com.codecool.proyecteGrande.model.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    public List<HouseEntity> getAll(){
        return houseRepository.findAll();
    }
}
