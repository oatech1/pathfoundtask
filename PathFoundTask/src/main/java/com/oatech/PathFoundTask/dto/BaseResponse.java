package com.oatech.PathFoundTask.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;
@Builder
public record BaseResponse<T>(HttpStatus status, String message,List<Object> error, T result) {

    public BaseResponse(HttpStatus status, String message, List<Object> error, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.error=error;
    }
}






