package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.model.House;
import com.codecool.proyecteGrande.model.HouseEntity;
import com.codecool.proyecteGrande.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/all")
    public List<HouseEntity> getHouses(){
        return houseService.getAll();
    }

    @GetMapping("/{house_id}")
    public HouseEntity getHouseById(@PathVariable("house_id") Long id){
        return houseService.getById(id);
    }

    @GetMapping("/name/{house_name}")
    public HouseEntity getHouseByName(@PathVariable("house_name") String name){
        return houseService.getByName(name);
    }
}
