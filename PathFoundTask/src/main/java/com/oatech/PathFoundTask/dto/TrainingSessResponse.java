package com.oatech.PathFoundTask.dto;

import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.Gym;
import com.oatech.PathFoundTask.entity.Member;

public record TrainingSessResponse(Gym gym,
                                   String dayOfWeek,
                                   Member member,
                                   Coach coach
                           ) {
    public TrainingSessResponse(Gym gym, String dayOfWeek, Member member, Coach coach) {
        this.gym = gym;
        this.dayOfWeek = dayOfWeek;
        this.member = member;
        this.coach = coach;
    }
}
