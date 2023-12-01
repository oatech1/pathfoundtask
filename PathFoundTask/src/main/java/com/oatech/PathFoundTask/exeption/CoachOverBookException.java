package com.oatech.PathFoundTask.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class CoachOverBookException extends RuntimeException{

    private HttpStatus status;

    public CoachOverBookException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    
}
