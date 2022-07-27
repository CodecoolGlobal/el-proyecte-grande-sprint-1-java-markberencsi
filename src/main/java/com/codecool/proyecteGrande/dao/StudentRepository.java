package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findAllByOrderByIdAsc();
    StudentEntity findByEmail(String email);
}
