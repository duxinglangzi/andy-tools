package com.andy.utils;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Date8Test {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());

        Instant now = Instant.now();
        System.out.println(now.toString());

        System.out.println(LocalDateTime.now());

        System.out.println(LocalTime.now());

        System.out.println(LocalDate.parse("2017-06-23"));

        System.out.println(LocalDateTime.of(LocalDate.now(),LocalTime.now()));

        System.out.println(DateFormat.getInstance().format(new Date()));

    }


}
