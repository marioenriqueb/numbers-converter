package com.exercise.service.utils;

import java.util.TreeMap;

public class RomanNumberUtils {
    private final static TreeMap<Long, String> map = new TreeMap<Long, String>();

    static {
        map.put(1000L, "M");
        map.put(900L, "CM");
        map.put(500L, "D");
        map.put(400L, "CD");
        map.put(100L, "C");
        map.put(90L, "XC");
        map.put(50L, "L");
        map.put(40L, "XL");
        map.put(10L, "X");
        map.put(9L, "IX");
        map.put(5L, "V");
        map.put(4L, "IV");
        map.put(1L, "I");
    }

    public final static String toRoman(Long number) {
        Long l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}
