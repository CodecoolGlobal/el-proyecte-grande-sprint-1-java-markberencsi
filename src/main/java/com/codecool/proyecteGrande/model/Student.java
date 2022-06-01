package com.codecool.proyecteGrande.model;

public class Student {
    private  static int nextId=0;
    private int id;
    private String firstName;
    private String lastName;

    private String email;

    private String password;

    private int houseId;


    public Student(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = nextId++;
        this.email=email;
        this.password=password;
    }

    public void setHouseId(int houseId){
        this.houseId=houseId;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", houseId=" + houseId +
                '}';
    }
}
