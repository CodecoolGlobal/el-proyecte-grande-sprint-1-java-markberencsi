package com.codecool.proyecteGrande.controller;

import com.codecool.proyecteGrande.dao.StudentRepository;
import com.codecool.proyecteGrande.model.StudentEntity;
import com.codecool.proyecteGrande.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LogInOutController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody StudentEntity student) throws Exception {
        Authentication auth = new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword());
        auth = authenticate(auth);

        String token = jwtTokenUtil.generateToken(auth.getName());
        return ResponseEntity.ok(token);
    }

    private Authentication authenticate(Authentication authentication) throws Exception {
        try {
            return authenticationManager.authenticate(authentication);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
