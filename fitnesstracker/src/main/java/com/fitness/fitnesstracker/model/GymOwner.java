package com.fitness.fitnesstracker.model;

import java.util.List;

import javax.management.relation.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymOwner {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String userName;
    private String password;
    private String email;
    private Role role;
    @OneToMany(mappedBy = "gymOwner")
    List<UserMeal> userMeal;
    @OneToMany(mappedBy = "gymOwner")
    List<UserExercise> userExercises;


}
