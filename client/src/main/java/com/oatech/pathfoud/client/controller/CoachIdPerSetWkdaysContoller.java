package com.oatech.pathfoud.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oatech.pathfoud.client.entity.TrainingSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class CoachIdPerSetWkdaysContoller {
    private final RestTemplate restTemplate;


    @GetMapping("/gymschedule/{id}/{days}")
    public String fetchTrainSessByCoaInSetWk(
            @PathVariable Long id, @PathVariable Set<String> days, Model model) throws JsonProcessingException {
        String daysString = String.join(",", days);
        String apiUrl = "http://localhost:7071/api/v1/training/coach-weekdays/" + id + "/" + daysString;
        ResponseEntity<String> rs = restTemplate.getForEntity(apiUrl, String.class);

        List dataList = null;
        if (rs.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
      try {
          TrainingSession[] trainingSessions = objectMapper.readValue(rs.getBody(), TrainingSession[].class);
          model.addAttribute("gymData",trainingSessions);

      }catch (HttpClientErrorException e){

          String statusText = e.getStatusText();
          String responseBody = e.getResponseBodyAsString();


          System.err.println("Status Text: " + statusText);
          System.err.println("Response Body: " + responseBody);
      }


        } else {

        }
        return "coachidwkdays";
    }
}