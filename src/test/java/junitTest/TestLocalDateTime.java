package junitTest;

import com.andy.common.utils.LocalDateTimeUtils;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * <p>ClassName: 日期操作 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/29 13:40 </p>
 */
public class TestLocalDateTime extends TestCase {

    public void test_time() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.toString());
        System.out.println(localDateTime.plusDays(30L).toString());     //加30天
        System.out.println(localDateTime.minusHours(3L).toString());    //减3小时
        System.out.println(localDateTime.minusDays(90L).toString());    //减90天


        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(localDate.plusDays(30L).toString());     //加30天
        System.out.println(localDate.minusDays(90L).toString());    //减90天
        System.out.println(localDate.getDayOfYear());           //当前年的 第几天， 返回值区间  1-366之间
        System.out.println(localDate.minusDays(1L).getDayOfWeek().getValue()); //返回当前天是本周的 第几天， 数值区间 1-7

        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());//获取毫秒数
        System.out.println("test github push ");


        LocalDate localDate1 = localDate.minusMonths(1L);


        System.out.println(localDate1.with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println(LocalDateTimeUtils.localDateToDate(localDate1.with(TemporalAdjusters.firstDayOfMonth())));
        System.out.println(
                LocalDateTimeUtils.localDateTimeToDate(
                        LocalDateTime.of(localDate1.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.of(23, 59, 59))));

        Date date = LocalDateTimeUtils.localDateToDate(LocalDateTime.now().toLocalDate().minusMonths(1L));
        System.out.println(LocalDateTimeUtils.dateToLocalDateTime(date).toString());


    }

}
