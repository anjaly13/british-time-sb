package com.javacodes.british_time_sb.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@Service
public class TimeServiceImpl implements TimeService{

    @Autowired
    private BritishTimeSpecialImpl britishTimeSpecial;

    @Autowired
    private BritishTimeBeforeThirtyMinuteImpl britishTimeBeforeThirtyMinute;

    @Autowired
    private BritishTimeAfterThirtyMinuteImpl britishTimeAfterThirtyMinute;

    /**
     * Create a navigatable map to collect the required instance details, for different time ranges
     * design - factory
     */
    public static final NavigableMap<Integer,BritishTimeService> serviceHandler = new TreeMap<>();
    @PostConstruct
    public Map<Integer, BritishTimeService> getObject() {
        serviceHandler.put(0,britishTimeSpecial);
        serviceHandler.put(30,britishTimeBeforeThirtyMinute);
        serviceHandler.put(59,britishTimeAfterThirtyMinute);
        return serviceHandler;
    }

    /**
     * Method to make call to the exact instance for each time range
     * @param time
     * @return
     * @throws Exception
     */
    @Override
    public String getBritishSpokenTime(LocalTime time) throws Exception {
        int hr = time.getHour();
        int minute = time.getMinute();

        BritishTimeService britishTime = serviceHandler.get(serviceHandler.ceilingKey(minute));
        if (britishTime == null){
            throw new Exception("Invalid service request, service handler failed..");
        }
        return britishTime.generateBritishSpokenTime(hr, minute);
    }
}
