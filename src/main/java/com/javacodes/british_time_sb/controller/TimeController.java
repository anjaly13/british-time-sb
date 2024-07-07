package com.javacodes.british_time_sb.controller;

import com.javacodes.british_time_sb.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/british-time")
    public ResponseEntity getBritishTime(@RequestParam("time") @DateTimeFormat(pattern = "hh:mm") LocalTime localTime){
        try{
            if(localTime == null || (localTime.getHour() > 12)){
                throw new Exception("Invalid Time..");
            }
            return new ResponseEntity(timeService.getBritishSpokenTime(localTime),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
