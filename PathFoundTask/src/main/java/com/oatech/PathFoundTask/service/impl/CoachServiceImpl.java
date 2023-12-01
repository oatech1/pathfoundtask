package com.oatech.PathFoundTask.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oatech.PathFoundTask.dto.BaseResponse;
import com.oatech.PathFoundTask.dto.CoachRequest;
import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.Member;
import com.oatech.PathFoundTask.repository.CoachRepository;
import com.oatech.PathFoundTask.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepo;
    private final ObjectMapper objectMapper;
    @Override
    public BaseResponse saveCoach(String coachD) throws JsonProcessingException {
        CoachRequest coachTrans=memberBodyData(coachD);
        Coach coach =Coach.builder()
               .name(coachTrans.getName())
               // .member(memberlist)

                .build();
                  Coach savedCoach=coachRepo.save(coach);
        return new BaseResponse(HttpStatus.CREATED,"Member saved successfully",null,savedCoach);
    }

    private CoachRequest memberBodyData(String collect) throws JsonProcessingException {


        CoachRequest coachRequest=objectMapper.readValue(collect, CoachRequest.class);

        return coachRequest;
    }
}
