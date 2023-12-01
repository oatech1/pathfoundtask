package com.oatech.PathFoundTask.exeption;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorManager {

    private String errorMessage;

    private HttpStatus status;

    private String timeStamp;
}
