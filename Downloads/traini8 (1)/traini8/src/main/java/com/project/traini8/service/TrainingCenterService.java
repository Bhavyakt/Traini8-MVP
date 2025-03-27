package com.project.traini8.service;


import com.project.traini8.model.TrainingCenter;
import com.project.traini8.repository.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a service component
@RequiredArgsConstructor  // Auto-generates constructor with final fields
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    // Saves the object into DB
    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {

        return repository.save(trainingCenter);
    }

    // Retrieves all training centers
    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
    public TrainingCenter getTrainingCenterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training Center not found with ID: " + id));
    }
}
