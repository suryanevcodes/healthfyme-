package com.fitness.fitnesstracker.controller;

import com.fitness.fitnesstracker.model.ExerciseAssociation;
import com.fitness.fitnesstracker.service.ExerciseAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercise-associations")
public class ExerciseAssociationController {
    
    @Autowired
    private final ExerciseAssociationService exerciseAssociationService;

    public ExerciseAssociationController(ExerciseAssociationService exerciseAssociationService) {
        this.exerciseAssociationService = exerciseAssociationService;
    }

    @GetMapping("/ExerciseAssociation/findAll")
    public ResponseEntity<List<ExerciseAssociation>> getAllExerciseAssociations() {
        List<ExerciseAssociation> exerciseAssociations = exerciseAssociationService.findAll();
        return ResponseEntity.ok(exerciseAssociations);
    }

    @GetMapping("/ExerciseAssociation/findById/{id}")
    public ResponseEntity<ExerciseAssociation> getExerciseAssociationById(@PathVariable int id) {
        Optional<ExerciseAssociation> exerciseAssociation = exerciseAssociationService.findById(id);
        return exerciseAssociation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/ExerciseAssociation/Create")
    public ResponseEntity<ExerciseAssociation> createExerciseAssociation(@RequestBody ExerciseAssociation exerciseAssociation) {
        ExerciseAssociation createdExerciseAssociation = exerciseAssociationService.save(exerciseAssociation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExerciseAssociation);
    }

    @PutMapping("/ExerciseAssociation/findById/{id}")
    public ResponseEntity<ExerciseAssociation> updateExerciseAssociation(@PathVariable int id, @RequestBody ExerciseAssociation exerciseAssociation) {
        if (!exerciseAssociationService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        exerciseAssociation.setId(id);
        ExerciseAssociation updatedExerciseAssociation = exerciseAssociationService.save(exerciseAssociation);
        return ResponseEntity.ok(updatedExerciseAssociation);
    }

    @DeleteMapping("/ExerciseAssociation/deleteById(/{id}")
    public ResponseEntity<Void> deleteExerciseAssociation(@PathVariable int id) {
        exerciseAssociationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ExerciseAssociation/deleteAll/{id}")
    public ResponseEntity<Void> deleteAllExerciseAssociations() {
        exerciseAssociationService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
