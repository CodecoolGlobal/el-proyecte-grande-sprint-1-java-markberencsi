package com.codecool.proyecteGrande.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
