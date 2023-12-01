package com.oatech.PathFoundTask.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oatech.PathFoundTask.dto.*;
import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.Member;
import com.oatech.PathFoundTask.repository.MemberRepository;
import com.oatech.PathFoundTask.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepo;
    private final ObjectMapper objectMapper;


    @Override
    public BaseResponse saveMember(String collect) throws JsonProcessingException {
        MemberRequest membertrans = memberBodyData(collect);

        Member member = Member.builder()
                .name(membertrans.getName())
                .build();
        Member savedMember = memberRepo.save(member);
        log.info("List of Coacges:{}",savedMember);
        return new BaseResponse(HttpStatus.CREATED, "Member saved successfully", null, savedMember);
    }


    private MemberRequest memberBodyData(String collect) throws JsonProcessingException {


        MemberRequest memberRequest=objectMapper.readValue(collect,MemberRequest.class);

        return memberRequest;
    }
}