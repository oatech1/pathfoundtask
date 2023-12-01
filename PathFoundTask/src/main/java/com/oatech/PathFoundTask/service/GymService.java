package com.oatech.PathFoundTask.service;

import com.oatech.PathFoundTask.dto.BaseResponse;
import com.oatech.PathFoundTask.dto.GymRequest;
import com.oatech.PathFoundTask.dto.MemberRequest;
import com.oatech.PathFoundTask.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymService {

      BaseResponse saveGym(GymRequest gymRequest);
}
