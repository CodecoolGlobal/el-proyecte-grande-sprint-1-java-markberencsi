package com.codecool.proyecteGrande.dao.implementation;

import com.codecool.proyecteGrande.dao.HouseDao;
import com.codecool.proyecteGrande.model.House;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HouseDaoMem implements HouseDao {
    private List<House> houses;

    public HouseDaoMem() {
        houses = new ArrayList<>();
    }

    @Override
    public void add(House house) {

    }

    @Override
    public House find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<House> getAll() {
        return null;
    }
}
