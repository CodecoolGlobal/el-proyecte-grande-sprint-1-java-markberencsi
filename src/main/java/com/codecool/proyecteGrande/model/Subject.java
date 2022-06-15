package com.codecool.proyecteGrande.model;

public enum Subject {

    POTIONS("Potions"),DEFENSE_AGAINST_DARK_ARTS("Defense-against-dark-arts"),HERBOLOGY("Herbology");

    private final String string;

    Subject(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
