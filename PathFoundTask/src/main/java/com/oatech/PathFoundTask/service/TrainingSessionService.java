package com.oatech.PathFoundTask.service;

import com.oatech.PathFoundTask.dto.BaseResponse;
import com.oatech.PathFoundTask.dto.TrainingSessRequest;
import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.TrainingSession;
import com.oatech.PathFoundTask.enums.Days;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TrainingSessionService  {
         BaseResponse fetchAllTrainingSess();
    BaseResponse saveTrainSess(TrainingSessRequest trainingRequest);
   List<TrainingSession>  findByCoachAndDOfWkIn(Long coach, Set<String> days);
    BaseResponse fetchTrainingSessionSatCanNotWed();
    BaseResponse fetchTrainingSessionByCoachAndDays(Long coach, Set<String> days);
}
