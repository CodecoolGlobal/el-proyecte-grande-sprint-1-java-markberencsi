package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.HouseDao;
import com.codecool.proyecteGrande.model.House;

import java.util.List;

public class HouseService {
    private HouseDao houseDao;

    public HouseService(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    public List<House> getAll(){
        return houseDao.getAll();
    }
}
