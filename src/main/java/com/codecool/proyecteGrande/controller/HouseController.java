package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.service.HouseService;

public class HouseController {
    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }
}
