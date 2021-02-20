package junitTest;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2019/7/15 </p>
 */
public class TimeTest {


    public static void main(String[] args) {


        System.out.println(new Date(1562783161000L));
        Instant instant = Instant.ofEpochMilli(1562783161000L);
        ZoneId zone = Clock.systemUTC().getZone();

        System.out.println(LocalDateTime.ofInstant(instant, zone));
        System.out.println(LocalDateTime.now(Clock.systemUTC()));


        //System.out.println(LocalDateTime.parse("2019-07-11T02:26:01.000Z"));
    }


}
