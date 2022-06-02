package com.codecool.proyecteGrande.model;

public class House {
    private int id;
    private String name;
    private int points;
    private String description;

    public House(int id, String name, int points, String description) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getDescription() {
        return description;
    }

    public void increasePoints(int n){
        points+=n;
    }

    public void decreasePoints(int n){
        points-=n;
    }
}
