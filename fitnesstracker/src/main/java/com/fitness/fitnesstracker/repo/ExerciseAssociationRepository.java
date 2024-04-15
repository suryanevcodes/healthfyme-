package com.fitness.fitnesstracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.fitnesstracker.model.ExerciseAssociation;
@Repository
public interface ExerciseAssociationRepository extends JpaRepository<ExerciseAssociation, Integer> {
    // Add custom queries if needed
}
