package com.javacodes.british_time_sb.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javacodes.british_time_sb.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
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
            //LocalTime t = localTime.toLocalTime();
            return new ResponseEntity(timeService.getBritishSpokenTime(localTime),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/sample")
    public ResponseEntity sample(){
        try{

            return new ResponseEntity(LocalTime.now(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
