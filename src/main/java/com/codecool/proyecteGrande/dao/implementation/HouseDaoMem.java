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
        readFromFile();
    }

    private void readFromFile() {
        try (Reader reader = new InputStreamReader(
                Objects.requireNonNull(HouseDaoMem.class.getResourceAsStream("/houses.json")))) {
            Gson gson = new Gson();

            JsonObject data = gson.fromJson(reader, JsonObject.class);
            JsonArray houses = data.getAsJsonArray("houses");

            for (int i = 0; i < houses.size(); i++) {
                JsonObject category = houses.get(i).getAsJsonObject();
                add(new House(category.get("id").getAsInt(), category.get("name").getAsString(), category.get("points").getAsInt(), category.get("description").getAsString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(House house) {
        houses.add(house);
    }

    @Override
    public House find(int id) {
        return houses.stream()
                .filter(house -> house.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<House> getAll() {
        return null;
    }
}
