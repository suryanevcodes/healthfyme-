package com.fitness.fitnesstracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitness.fitnesstracker.model.GymOwner;
import com.fitness.fitnesstracker.repo.GymOwnerRepository;

@Service
public class GymOwnerService {

    @Autowired
    private GymOwnerRepository gymOwnerRepository; 

    public List<GymOwner> findAll() {
        return gymOwnerRepository.findAll();
    }

    public Optional<GymOwner> findById(int id) {
        return gymOwnerRepository.findById(id);
    }

    public GymOwner save(GymOwner gymOwner) {
        return gymOwnerRepository.save(gymOwner);
    }

    public void deleteById(int id) {
        gymOwnerRepository.deleteById(id);
    }

    public void deleteAll() {
        gymOwnerRepository.deleteAll();
    }
}
