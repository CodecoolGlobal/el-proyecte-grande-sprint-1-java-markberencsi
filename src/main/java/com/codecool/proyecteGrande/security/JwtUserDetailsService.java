package com.codecool.proyecteGrande.security;

import com.codecool.proyecteGrande.dao.StudentRepository;
import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StudentEntity student = studentRepository.findByEmail(email);
        if(student == null){
            throw new UsernameNotFoundException(email);
        }
        UserDetails user = User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .authorities(new ArrayList<>()).build();
        return user;
    }
}
