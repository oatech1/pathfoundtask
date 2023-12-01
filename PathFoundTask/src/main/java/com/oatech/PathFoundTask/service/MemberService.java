package com.oatech.PathFoundTask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oatech.PathFoundTask.dto.*;
import com.oatech.PathFoundTask.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberService {
    BaseResponse saveMember(String payload) throws JsonProcessingException;
}
