package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.HouseDao;

public class HouseService {
    private HouseDao houseDao;

    public HouseService(HouseDao houseDao) {
        this.houseDao = houseDao;
    }
}
