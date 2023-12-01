package com.oatech.PathFoundTask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oatech.PathFoundTask.dto.MemberRequest;
import lombok.RequiredArgsConstructor;


public interface DataConverter<T> {
    T memberBodyData(String collect) throws JsonProcessingException;

}
