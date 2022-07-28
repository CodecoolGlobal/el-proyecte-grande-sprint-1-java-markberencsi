package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.dao.HouseRepository;
import com.codecool.proyecteGrande.dao.StudentRepository;
import com.codecool.proyecteGrande.model.HouseEntity;
import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SignUpController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody StudentEntity student){
        if(studentRepository.findByEmail(student.getEmail()) == null){
            StudentEntity se = new StudentEntity();
            se.setEmail(student.getEmail());
            se.setFirst_name(student.getFirst_name());
            se.setLast_name(student.getLast_name());
            String encodedPassword = new BCryptPasswordEncoder().encode(student.getPassword());
            se.setPassword(encodedPassword);
            se.setHouse(houseRepository.findByName("Gryffindor"));
            se.setPoints(10);
            studentRepository.save(se);
            return ResponseEntity.ok("User created!");
        }else{
            return ResponseEntity.badRequest().body("Username already exists!");
        }
    }

}
