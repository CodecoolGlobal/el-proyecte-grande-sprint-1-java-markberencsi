package com.codecool.proyecteGrande.security;


import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ)),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.SUBJECT_READ,ApplicationUserPermission.SUBJECT_WRITE,ApplicationUserPermission.STUDENT_READ,ApplicationUserPermission.STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }
}
