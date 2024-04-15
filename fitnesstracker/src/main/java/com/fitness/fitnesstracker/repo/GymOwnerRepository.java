package com.fitness.fitnesstracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.fitnesstracker.model.GymOwner;

@Repository
public interface GymOwnerRepository extends JpaRepository<GymOwner, Integer> {
    
}
