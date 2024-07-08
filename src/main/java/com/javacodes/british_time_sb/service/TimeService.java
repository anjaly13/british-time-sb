package com.javacodes.british_time_sb.service;

import java.time.LocalTime;

public interface TimeService {

    String getBritishSpokenTime(LocalTime time) throws Exception;
}
