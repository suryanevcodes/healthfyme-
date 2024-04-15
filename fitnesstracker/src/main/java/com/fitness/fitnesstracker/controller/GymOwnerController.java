package com.fitness.fitnesstracker.controller;

import com.fitness.fitnesstracker.model.GymOwner;
import com.fitness.fitnesstracker.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gym-owners")
public class GymOwnerController {

    @Autowired
    private final GymOwnerService gymOwnerService;

    public GymOwnerController(GymOwnerService gymOwnerService) {
        this.gymOwnerService = gymOwnerService;
    }

    @GetMapping("GymOwner/findAll")
    public ResponseEntity<List<GymOwner>> getAllGymOwners() {
        List<GymOwner> gymOwners = gymOwnerService.findAll();
        return ResponseEntity.ok(gymOwners);
    }

    @GetMapping("GymOwner/findById/{id}")
    public ResponseEntity<GymOwner> getGymOwnerById(@PathVariable int id) {
        Optional<GymOwner> gymOwner = gymOwnerService.findById(id);
        return gymOwner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("GymOwner/create")
    public ResponseEntity<GymOwner> createGymOwner(@RequestBody GymOwner gymOwner) {
        GymOwner createdGymOwner = gymOwnerService.save(gymOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGymOwner);
    }

    @PutMapping("GymOwner/update/{id}")
    public ResponseEntity<GymOwner> updateGymOwner(@PathVariable int id, @RequestBody GymOwner gymOwner) {
        if (!gymOwnerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        gymOwner.setId(id);
        GymOwner updatedGymOwner = gymOwnerService.save(gymOwner);
        return ResponseEntity.ok(updatedGymOwner);
    }

    @DeleteMapping("GymOwner/delete/{id}")
    public ResponseEntity<Void> deleteGymOwner(@PathVariable int id) {
        gymOwnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("GymOwner/deleteAll")
    public ResponseEntity<Void> deleteAllGymOwners() {
        gymOwnerService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
