package com.oatech.PathFoundTask.service.impl;

import com.oatech.PathFoundTask.dto.BaseResponse;
import com.oatech.PathFoundTask.dto.GymRequest;
import com.oatech.PathFoundTask.entity.Gym;
import com.oatech.PathFoundTask.repository.GymRepository;
import com.oatech.PathFoundTask.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepo;
    @Override
    public BaseResponse saveGym(GymRequest gRequest) {
        Gym coach =Gym.builder()
                .name(gRequest.name())
                .build();
        Gym savedGym=gymRepo.save(coach);

        return new BaseResponse(HttpStatus.CREATED,"Member saved successfully",null,savedGym);
    }

            public BaseResponse  getGym(Long id){
               Gym gym= gymRepo.findById(id).orElse(null);
          return new BaseResponse(HttpStatus.OK, "Gym Id "+gym.getId(), null,gym);
            }
}
