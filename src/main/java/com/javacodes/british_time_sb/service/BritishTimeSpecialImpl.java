package com.javacodes.british_time_sb.service;

import com.javacodes.british_time_sb.constant.Constants;
import org.springframework.stereotype.Service;


@Service
public class BritishTimeSpecialImpl implements BritishTimeService{

    /**
     * Method to convert the special time into the british spoken format
     * ex: 12:00, 1:00, 0:00
     * @param hr
     * @param minute
     * @return
     */
    @Override
    public String generateBritishSpokenTime(int hr, int minute) {

        if(hr == 12){
            return Constants.NOON;
        }else if ( hr == 0){
            return Constants.MID_NIGHT;
        }
        else {
            StringBuilder time = new StringBuilder(Constants.TIME.get(hr))
                    .append(" ").append(Constants.OCLOCK);
            return time.toString();
        }

    }
}
