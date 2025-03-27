package com.project.traini8.controller;


import com.project.traini8.model.TrainingCenter;
import com.project.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
@RequiredArgsConstructor
public class TrainingCenterController {

    private final TrainingCenterService service;


    @PostMapping("/create")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.saveTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TrainingCenter> getTrainingCenterById(@PathVariable Long id) {
        TrainingCenter center = service.getTrainingCenterById(id);
        return ResponseEntity.ok(center);

    }
}