package com.andy.common.utils;

import java.time.*;
import java.util.Date;

/**
 * <p>Description: 日期调整类 </p>
 * <p>@author wuqiong  2018/1/29 11:09 </p>
 */
public class LocalDateTimeUtils {

    /**
     * 使用系统默认时区
     */
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * 方法描述: 将java.time.LocalDate 转化为 java.util.Date
     *
     * @return Date
     * @params LocalDate
     * @author wuqiong  2018/1/29 11:17
     */
    public static Date localDateToDate(final LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZONE_ID);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 方法描述: 将java.time.LocalDateTime 转化为 java.util.Date
     *
     * @return Date
     * @params LocalDateTime
     * @author wuqiong  2018/1/29 11:21
     */
    public static Date localDateTimeToDate(final LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZONE_ID);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 方法描述: 将java.utils.Date 转化为 java.time.LocalDateTime
     *
     * @return LocalDateTime
     * @params date
     * @author wuqiong  2018/2/5 10:08
     */
    public static LocalDateTime dateToLocalDateTime(final Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
    }

    /**
     * 方法描述: 获取两个时间差
     *
     * @return Duration 返回一个持续时间
     * <p>Duration.toNanos()//纳秒</p>
     * <p>Duration.toMillis()//毫秒</p>
     * <p>Duration.toMinutes()//分钟</p>
     * <p>Duration.toHours()//小时</p>
     * <p>Duration.toDays()//天数</p>
     * @params LocalDateTime beginTime,LocalDateTime endTime
     * @author wuqiong  2018/1/29 13:05
     */
    public static Duration localBetween(final LocalDateTime beginTime, final LocalDateTime endTime) {
        return Duration.between(beginTime, endTime);
    }


}
