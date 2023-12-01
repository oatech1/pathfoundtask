package com.oatech.PathFoundTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.oatech.PathFoundTask.enums.Days;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;


}
