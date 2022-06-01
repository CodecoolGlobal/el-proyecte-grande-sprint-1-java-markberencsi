package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.HouseDao;
import com.codecool.proyecteGrande.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseService {
    @Autowired
    private HouseDao houseDao;

    public HouseService(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    public List<House> getAll(){
        return houseDao.getAll();
    }
}
