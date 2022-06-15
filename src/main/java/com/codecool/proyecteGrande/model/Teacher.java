package com.codecool.proyecteGrande.model;

public class Teacher {

    private int id;
    private final String firstName;
    private final String lastName;
    private String email;
    private String password;

    private Subject taughtSubject;

    public Teacher(String firstName, String lastName, String email, String password, Subject taughtSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.taughtSubject = taughtSubject;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTaughtSubject() {
        return taughtSubject.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaughtSubject(Subject taughtSubject) {
        this.taughtSubject = taughtSubject;
    }
}
