package com.javacodes.british_time_sb.constant;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    private Constants(){}

    public static Map<Integer,String>TIME = new HashMap<>();
    static {
        TIME.put(1, "one");
        TIME.put(2, "two");
        TIME.put(3, "three");
        TIME.put(4, "four");
        TIME.put(5, "five");
        TIME.put(6, "six");
        TIME.put(7, "seven");
        TIME.put(8, "eight");
        TIME.put(9, "nine");
        TIME.put(10, "ten");
        TIME.put(11, "eleven");
        TIME.put(12, "twelve");
        TIME.put(13, "thirteen");
        TIME.put(14, "fourteen");
        TIME.put(15, "quarter");
        TIME.put(16, "sixteen");
        TIME.put(17, "seventeen");
        TIME.put(18, "eighteen");
        TIME.put(19, "nineteen");
        TIME.put(20, "twenty");
        TIME.put(21, "twenty one");
        TIME.put(22, "twenty two");
        TIME.put(23, "twenty three");
        TIME.put(24, "twenty four");
        TIME.put(25, "twenty five");
        TIME.put(26, "twenty six");
        TIME.put(27, "twenty seven");
        TIME.put(28, "twenty eight");
        TIME.put(29, "twenty nine");
        TIME.put(30, "half");
        TIME.put(31, "thirty one");
        TIME.put(32, "thirty two");
        TIME.put(33, "thirty three");
        TIME.put(34, "thirty four");
    }

    public static final String NOON = "noon";
    public static final String MID_NIGHT = "midnight";
    public static final String OCLOCK = "o'clock";
}
