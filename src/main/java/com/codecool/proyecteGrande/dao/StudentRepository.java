package com.codecool.proyecteGrande.dao;

import com.codecool.proyecteGrande.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findAllByOrderByIdAsc();

    Optional<StudentEntity> findById(Long id);
}
