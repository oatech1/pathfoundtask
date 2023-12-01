package com.oatech.PathFoundTask.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CoachOverBookException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorManager handlePasswordNotMatchedException(CoachOverBookException ex){
        String message = ex.getMessage();
        return ErrorManager.builder()
                .errorMessage(ex.getMessage())
                .status(ex.getStatus())
                .timeStamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                .build();
    }


}
