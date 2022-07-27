package com.codecool.proyecteGrande.service;

import com.codecool.proyecteGrande.DTO.StudentDTO;
import com.codecool.proyecteGrande.dao.StudentDao;
import com.codecool.proyecteGrande.dao.StudentRepository;
import com.codecool.proyecteGrande.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    StudentDao studentDao;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    public HouseService houseService;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

//    public List<Student> getAllStudents(){
//        return studentDao.getAll();
//    }

    public List<StudentEntity> getAll(){
        return studentRepository.findAllByOrderByIdAsc();
    }

    public Optional<StudentEntity> getStudentById(Long id){return studentRepository.findById(id);}

    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> students = new ArrayList<>();
        List<StudentEntity> studentEntities = studentRepository.findAllByOrderByIdAsc();
        for (StudentEntity student: studentEntities
             ) {
            HouseEntity house = houseService.getById(student.getHouse().getId());
            students.add(new StudentDTO(student, house ));
        }
        return students;
    }
}
