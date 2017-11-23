package com.andy.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * asdf
 *
 * @author sunny
 * @create 2017/11/23 17:59
 **/
public class LocatDateUtil {
    public static void main(String[] args) {
        System.out.println(parseTime("01:00",false));
    }
    private static LocalTime parseTime(String time, boolean isStart) {
        if (time.split(":").length < 3) {
            time = time + (isStart ? ":00" : ":59");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime ret = LocalTime.parse(time, formatter);
        return ret;
    }
}
