package com.oatech.PathFoundTask.repository;

import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach,Long> {
    // Optional<Coach> findByTrainingSession(TrainingSession trainingSession);
}
