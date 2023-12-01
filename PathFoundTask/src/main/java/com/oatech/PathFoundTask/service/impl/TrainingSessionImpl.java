package com.oatech.PathFoundTask.service.impl;

import com.oatech.PathFoundTask.dto.BaseResponse;
import com.oatech.PathFoundTask.dto.TrainingSessRequest;
import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.Gym;
import com.oatech.PathFoundTask.entity.Member;
import com.oatech.PathFoundTask.entity.TrainingSession;
import com.oatech.PathFoundTask.enums.Days;
import com.oatech.PathFoundTask.exeption.CoachOverBookException;
import com.oatech.PathFoundTask.repository.CoachRepository;
import com.oatech.PathFoundTask.repository.GymRepository;
import com.oatech.PathFoundTask.repository.MemberRepository;
import com.oatech.PathFoundTask.repository.TrainingSessionRepository;
import com.oatech.PathFoundTask.service.TrainingSessionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TrainingSessionImpl implements TrainingSessionService {
    private final TrainingSessionRepository trainingSessionRepository;
    private final GymRepository gymRepository;
    private final CoachRepository coachRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    @Override
    public BaseResponse fetchAllTrainingSess() {
        List<TrainingSession> trainingSessionList= trainingSessionRepository.findAll()
                .stream().map(trainingSession -> {
                   TrainingSession trainingSessRes=modelMapper.map(trainingSession,TrainingSession.class);
                   Gym gym = gymRepository.findById(trainingSession.getGym().getId()).orElse(null);
                   trainingSessRes.setGym(modelMapper.map(gym,Gym.class));
                   Member member= memberRepository.findById(trainingSession.getMember().getId()).orElse(null);
                   trainingSessRes.setMember(modelMapper.map(member,Member.class));
                  Coach coach= coachRepository.findById(trainingSession.getCoach().getId()).orElse(null);
                   trainingSessRes.setCoach(modelMapper.map(coach,Coach.class));
                   Days day=trainingSession.getDofwk();
                return trainingSessRes;

                })

                .toList();

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .message("Session Successfully fetched")
                .result(trainingSessionList)
                .error(null)
                .build();
    }



    @Override
    public BaseResponse saveTrainSess(TrainingSessRequest trainingRequest) {
        List<TrainingSession> sessions = trainingSessionRepository.findTrainingSessionsByCoachId(trainingRequest.coachId());
        List<TrainingSession> session2 =trainingSessionRepository.findSessionsByCoachIdAndMemberId(trainingRequest.coachId(),trainingRequest.memberId());
        if (sessions.size() >= 4 || session2.size() >= 2 ) {
            throw new CoachOverBookException("Coach limit exceeded", HttpStatus.NOT_ACCEPTABLE);
        }
            Gym rtgym = gymRepository.findById(trainingRequest.gymId()).orElse(null);
            Coach coach = coachRepository.findById(trainingRequest.coachId()).orElse(null);

            Member member = memberRepository.findById(trainingRequest.memberId()).orElse(null);
            TrainingSession trainingSession = TrainingSession.builder()
                    .gym(rtgym)
                    .dofwk(trainingRequest.dofwk())
                    .member(member)
                    .coach(coach)
                    .build();
            TrainingSession savedTrainingSess = trainingSessionRepository.save(trainingSession);
            return BaseResponse.builder()
                    .status(HttpStatus.CREATED)
                    .result(savedTrainingSess)
                    .error(new ArrayList<>())
                    .build();

    }

    @Override
    public List<TrainingSession> findByCoachAndDOfWkIn(Long coach, Set<String> days) {
        return trainingSessionRepository.findByCoachIdAndDofwk(coach,days);

    }

    @Override
    public BaseResponse fetchTrainingSessionByCoachAndDays(Long coachId, Set<String> days) {
        List<Days> daysList= Arrays.asList(Days.MON,Days.WED,Days.FRI,Days.SAT);
         List<TrainingSession> trainingSessionByCoachIdDays=trainingSessionRepository.findById(coachId)
                 .stream()
                 .filter(trainingSession -> trainingSession.getCoach().equals(coachId)
                         && days.contains(daysList))
                 .toList();
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .message("")
                .result(trainingSessionByCoachIdDays)
                .build();
    }

    @Override
    @Cacheable(cacheNames = "cancsatnotbksat")
    public BaseResponse fetchTrainingSessionSatCanNotWed() {
        List<TrainingSession> trainingSessSatCanNotWed= trainingSessionRepository.findAll()
                .stream().filter(session -> !session.getDofwk().equals(Days.WED)
                        && !session.getDofwk().equals(Days.SAT)).toList();
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .message("")
                .result(trainingSessSatCanNotWed)
                .build();
    }


   /* public BaseResponse fetchTrainingSessionByCoachAndDays(Coach coach, Set<Days> days) {

        TrainingSession trainingSessionByCoachIdDays=trainingSessionRepository.findAllById(coach.getId()).stream().filter()
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .message("")
                .result(trainingSessionByCoachIdDays)
                .build();
    }*/

    BaseResponse  findByCoachAndDOfWkIn(Coach coach){
           return null;
            }

}
