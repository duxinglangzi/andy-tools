package junitTest;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>ClassName: 日期操作 </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/29 13:40 </p>
 */
public class TestLocalDateTime extends TestCase {

    public void test_time(){
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



    }

}
