package com.javacodes.british_time_sb.service;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.NavigableMap;
import java.util.TreeMap;


@SpringBootTest
class TimeServiceImplTest {

    public static final NavigableMap<Integer,BritishTimeService> serviceHandler = new TreeMap<>();

    @Mock
    private BritishTimeSpecialImpl britishTimeSpecial;

    @Mock
    private BritishTimeBeforeThirtyMinuteImpl britishTimeBeforeThirtyMinute;

    @Mock
    private BritishTimeAfterThirtyMinuteImpl britishTimeAfterThirtyMinute;

    @InjectMocks
    private TimeServiceImpl timeService ;//= new TimeServiceImpl();

    @Mock
    private BritishTimeService britishTimeService;

    /**
     * Tests for each time ranges as input
     *
     * @throws Exception
     */
    @Test
    public void testBeforeThirtyMinutes() throws Exception {
        LocalTime localTime = LocalTime.of(4,15);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(new String());
        assertEquals("quarter past four",timeService.getBritishSpokenTime(localTime));
    }

    @Test
    public void testAfterThirtyMinute() throws Exception {
        LocalTime localTime = LocalTime.of(6,32);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(new String());
        assertEquals("six thirty two",timeService.getBritishSpokenTime(localTime));

    }
    @Test
    public void testAfterThirtyFive() throws Exception {
        LocalTime localTime = LocalTime.of(7,35);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(null);
        assertEquals("twenty five to eight",timeService.getBritishSpokenTime(localTime));
    }

    @Test
    public void testAtNoon() throws Exception {
        LocalTime localTime = LocalTime.of(12,00);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(null);
        assertEquals("noon",timeService.getBritishSpokenTime(localTime));
    }
    @Test
    public void testAtMidnight() throws Exception {
        LocalTime localTime = LocalTime.of(0,00);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(null);
        assertEquals("midnight",timeService.getBritishSpokenTime(localTime));
    }
    @Test
    public void testAtExactHour() throws Exception {
        LocalTime localTime = LocalTime.of(1,00);
        Mockito.when(britishTimeService.generateBritishSpokenTime(localTime.getHour(),localTime.getMinute())).thenReturn(null);
        assertEquals("one o'clock",timeService.getBritishSpokenTime(localTime));
    }

}