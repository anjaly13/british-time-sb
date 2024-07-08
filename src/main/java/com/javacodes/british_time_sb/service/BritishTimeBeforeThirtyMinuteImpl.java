package com.javacodes.british_time_sb.service;

import com.javacodes.british_time_sb.constant.Constants;
import org.springframework.stereotype.Service;


@Service
public class BritishTimeBeforeThirtyMinuteImpl implements BritishTimeService{
    /**
     * Method to create the british spoken time format, if the input time minutes are less than thirty.
     * The appending key word is 'past' here
     * @param hr
     * @param minute
     * @return
     */
    @Override
    public String generateBritishSpokenTime(int hr, int minute) {
        StringBuilder time = new StringBuilder(Constants.TIME.get(minute))
                .append(" past ").append(Constants.TIME.get(hr));
        return time.toString();
    }
}
