package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.dao.HouseRepository;
import com.codecool.proyecteGrande.model.HouseEntity;
import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    public List<HouseEntity> getAll(){
        List<HouseEntity> houses = houseRepository.findAll();
        houses.forEach(this::setPoints);
        setStanding(houses);
        return houses;
    }

    public HouseEntity getById(Long id){
        HouseEntity house = houseRepository.findById(id).get();
        setPoints(house);
        return house;
    }

    public HouseEntity getByName(String name){
        HouseEntity house = houseRepository.findByName(name);
        setPoints(house);
        return house;
    }

    private void setPoints(HouseEntity house){
         house.setTotalPoints(house.getStudents().stream()
                .map(StudentEntity::getPoints)
                .reduce(0, Integer::sum));
    }

    private void setStanding(List<HouseEntity> houses){
        houses.sort(Comparator.comparingInt(HouseEntity::getTotalPoints));
        houses.forEach(
                houseEntity -> houseEntity.setStanding(houses.indexOf(houseEntity)+1)
        );
    }
}
