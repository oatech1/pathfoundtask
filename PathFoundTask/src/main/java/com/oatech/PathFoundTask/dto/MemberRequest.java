package com.oatech.PathFoundTask.dto;

import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.enums.Days;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest  implements Serializable {
    private String name;
}
