package com.oatech.PathFoundTask.dto;

import com.oatech.PathFoundTask.enums.Days;

public record TrainingSessRequest(Long gymId,
                                  Days dofwk,
                                  Long memberId,
                                  Long coachId) {
    public TrainingSessRequest(Long gymId, Days dofwk, Long memberId, Long coachId) {
        this.gymId = gymId;
        this.dofwk = dofwk;
        this.memberId = memberId;
        this.coachId = coachId;
    }
}
