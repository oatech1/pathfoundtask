package com.oatech.PathFoundTask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oatech.PathFoundTask.dto.BaseResponse;

public interface CoachService{
    BaseResponse saveCoach(String payload)throws JsonProcessingException;
}
