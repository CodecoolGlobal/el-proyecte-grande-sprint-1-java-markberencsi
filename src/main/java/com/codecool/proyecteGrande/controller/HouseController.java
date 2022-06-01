package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.model.House;
import com.codecool.proyecteGrande.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/all")
    public List<House> getHouses(){
        return houseService.getAll();
    }
}
