package com.oatech.pathfoud.client.entity;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class TrainingSession  {



    private Gym gym;

    private String dofwk;

    private Coach coach;

    private Member member;

}
