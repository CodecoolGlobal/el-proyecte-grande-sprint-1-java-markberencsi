package com.codecool.proyecteGrande.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name ="student")
public class StudentEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    @NonNull
    private String first_name;
    @Column(name = "last_name", nullable = false)
    @NonNull
    private String last_name;
    @Column(name = "email", nullable = false)
    @NonNull
    private String email;
    @Column(name = "password", nullable = false)
    @NonNull
    private String password;
    @Column(columnDefinition = "integer default 0")
    private Integer points;

//TODO: connect with house
//    @JoinColumn(name = "house_id",referencedColumnName = "id")
//    private House house;


}
