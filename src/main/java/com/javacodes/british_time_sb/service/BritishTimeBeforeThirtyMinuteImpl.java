package com.javacodes.british_time_sb.service;

import com.javacodes.british_time_sb.constant.Constants;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BritishTimeBeforeThirtyMinuteImpl implements BritishTimeService{
    @Override
    public String generateBritishSpokenTime(int hr, int minute) {
        StringBuilder time = new StringBuilder(Constants.TIME.get(minute))
                .append(" past ").append(Constants.TIME.get(hr));
        return time.toString();
    }
}
