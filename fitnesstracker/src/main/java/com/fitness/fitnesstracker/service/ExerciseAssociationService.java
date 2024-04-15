package com.fitness.fitnesstracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitness.fitnesstracker.model.ExerciseAssociation;
import com.fitness.fitnesstracker.repo.ExerciseAssociationRepository;

@Service
public class ExerciseAssociationService {

    @Autowired
    private ExerciseAssociationRepository exerciseAssociationRepository; 

    public List<ExerciseAssociation> findAll() {
        return exerciseAssociationRepository.findAll();
    }

    public Optional<ExerciseAssociation> findById(int id) {
        return exerciseAssociationRepository.findById(id);
    }

    public ExerciseAssociation save(ExerciseAssociation exerciseAssociation) {
        return exerciseAssociationRepository.save(exerciseAssociation);
    }

    public void deleteById(int id) {
        exerciseAssociationRepository.deleteById(id);
    }

    public void deleteAll() {
        exerciseAssociationRepository.deleteAll();
    }
}
