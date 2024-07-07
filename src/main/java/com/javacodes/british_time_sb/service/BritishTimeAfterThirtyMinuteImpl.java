package com.javacodes.british_time_sb.service;

import com.javacodes.british_time_sb.constant.Constants;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BritishTimeAfterThirtyMinuteImpl implements BritishTimeService{
    @Override
    public String generateBritishSpokenTime(int hr, int minute) {
        StringBuilder time = new StringBuilder();
        if(minute > 30 && minute < 35){
            time.append(Constants.TIME.get(hr)).append(" ").append(Constants.TIME.get(minute));
            return time.toString();
        }
        int remainingMinute = 60 - minute;
        int nextHour = hr + 1;
        time.append(Constants.TIME.get(remainingMinute)).append(" to ").append(Constants.TIME.get(nextHour));
        return time.toString();
    }
}
