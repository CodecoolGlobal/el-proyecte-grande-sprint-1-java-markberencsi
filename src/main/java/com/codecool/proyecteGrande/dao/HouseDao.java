package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.House;

import java.util.List;

public interface HouseDao {
    void add(House house);
    House find(int id);
    void remove(int id);

    List<House> getAll();
}
