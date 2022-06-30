package com.codecool.proyecteGrande.DTO;

import com.codecool.proyecteGrande.model.HouseEntity;
import com.codecool.proyecteGrande.model.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
@Data
public class StudentDTO {
     public StudentDTO(StudentEntity student, HouseEntity house){
         this.id=student.getId();
         this.first_name=student.getFirst_name();
         this.last_name=student.getLast_name();
         this.email=student.getEmail();
         this.points=student.getPoints();
         this.house=house;
     }

        private Long id;

        private String first_name;

        private String last_name;

        private String email;

        private Integer points;

        private HouseEntity house;
    }
