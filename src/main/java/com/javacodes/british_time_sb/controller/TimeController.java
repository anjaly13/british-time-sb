package com.javacodes.british_time_sb.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("/british-time")
    public ResponseEntity getBritishTime(@RequestParam("time") @DateTimeFormat(pattern = "HH:mm") LocalTime localTime){
        System.out.println("Write the logic for getting british spoken time of " + localTime);
        return new ResponseEntity(HttpStatus.OK);
    }
}
