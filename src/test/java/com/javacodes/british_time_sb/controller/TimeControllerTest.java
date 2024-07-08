package com.javacodes.british_time_sb.controller;

import com.javacodes.british_time_sb.service.TimeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeControllerTest {

    @InjectMocks
    private TimeController timeController;

    @Mock
    private TimeService timeService;
    @Test
    void getBritishTime() {
        LocalTime time = LocalTime.now();
        timeController.getBritishTime(time);
    }
    @Test
    void getBritishTimeInvalid() {
        assertEquals(new ResponseEntity<>("Invalid Time..", HttpStatus.INTERNAL_SERVER_ERROR),timeController.getBritishTime(null));
    }
}