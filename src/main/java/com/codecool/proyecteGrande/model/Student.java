package com.codecool.proyecteGrande.model;

public class Student {
    private  static int nextId=0;
    private int id;
    private String firstName;
    private String lastName;

    private String email;

    private String password;


    public Student(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = nextId++;
        this.email=email;
        this.password=password;
    }


}
