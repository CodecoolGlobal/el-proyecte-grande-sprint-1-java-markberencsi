package com.codecool.proyecteGrande.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    SUBJECT_READ("subject:read"),
    SUBJECT_WRITE("subject:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
