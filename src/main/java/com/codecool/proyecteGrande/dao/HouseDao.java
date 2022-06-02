package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.House;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HouseDao {
    void add(House house);
    House find(int id);
    void remove(int id);

    List<House> getAll();
}
