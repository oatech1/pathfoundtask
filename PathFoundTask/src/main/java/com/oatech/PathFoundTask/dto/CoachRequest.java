package com.oatech.PathFoundTask.dto;

import com.oatech.PathFoundTask.entity.Member;
import com.oatech.PathFoundTask.enums.Days;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoachRequest implements Serializable {
    private String name;

}
