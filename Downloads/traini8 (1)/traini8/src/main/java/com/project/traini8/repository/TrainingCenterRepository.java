package com.project.traini8.repository;

import com.project.traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this as a repository (data access layer)
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
