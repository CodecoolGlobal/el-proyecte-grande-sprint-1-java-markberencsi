package com.codecool.proyecteGrande.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import javax.persistence.*;

@Entity(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private HouseEntity house;
}
