package com.oatech.PathFoundTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oatech.PathFoundTask.enums.Days;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class TrainingSession {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="gymId")
    private Gym gym;
    @Column
    @Enumerated(EnumType.STRING)
    private Days dofwk;
    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;
    @ManyToOne
    @JoinColumn(name="coachId")
    private Coach coach;

}
