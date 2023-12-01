package com.oatech.PathFoundTask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oatech.PathFoundTask.dto.*;
import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.TrainingSession;
import com.oatech.PathFoundTask.enums.Days;
import com.oatech.PathFoundTask.service.CoachService;
import com.oatech.PathFoundTask.service.GymService;
import com.oatech.PathFoundTask.service.MemberService;
import com.oatech.PathFoundTask.service.TrainingSessionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/training")
@RequiredArgsConstructor
public class TrainingSessController {
    private final TrainingSessionService trainingSessionService;
    private final GymService gymService;
    private final MemberService memberService;
    private final CoachService coachService;
    @GetMapping("/trainings")
    @Operation(summary = "Get all trainings")
    public BaseResponse getAllTrainSession(){
        return  trainingSessionService.fetchAllTrainingSess();
    }
    @PostMapping
    @Operation(summary = "Create a new Training Session")
    public BaseResponse createTrainSession(@RequestBody TrainingSessRequest trainingSessRequest){
        return  trainingSessionService.saveTrainSess(trainingSessRequest);
    }
    @PostMapping("/gym")
    @Operation(summary = "Create a new Gym")
    public BaseResponse createGym(@RequestBody GymRequest gymRequest){
        return  gymService.saveGym(gymRequest);
    }

    @PostMapping("/member")
    @Operation(summary = "Create a new Member")
    public BaseResponse createMember(@RequestBody String collect) throws JsonProcessingException {
        return  memberService.saveMember(collect);
    }
    @PostMapping("/coach")
    @Operation(summary = "Create a new Coach")
    public BaseResponse createCoach(@RequestBody String collect)throws JsonProcessingException{
        //return  coachService.saveCoach(coachRequest);
        return coachService.saveCoach(collect);
    }
    @GetMapping("/coach-weekdays/{coachId}/{days}")
    @Operation(summary = "Get all trainings by a coach on set of days")
    public List<TrainingSession> getAllTrainSessionByCoachIdByDays(@PathVariable Long coachId, @PathVariable  Set<String> days){
        return  trainingSessionService.findByCoachAndDOfWkIn(coachId,days);
     }
    @GetMapping("/trainisatcannotwed")
    @Operation(summary = "Get all trainings")
    public BaseResponse getAllTrainSessionNtStWd(){
        return  trainingSessionService.fetchTrainingSessionSatCanNotWed();
    }
}
