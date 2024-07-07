package com.javacodes.british_time_sb.service;

import com.javacodes.british_time_sb.constant.Constants;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BritishTimeSpecialImpl implements BritishTimeService{
    @Override
    public String generateBritishSpokenTime(int hr, int minute) {

        if(hr == 12){
            return "noon";
        }else if ( hr == 0){
            return "midnight";
        }
        else {
            StringBuilder time = new StringBuilder(Constants.TIME.get(hr))
                    .append(" o'clock");
            return time.toString();
        }

    }
}
