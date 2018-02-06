package junitTest.model;

import java.time.LocalDateTime;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/2/6 16:58 </p>
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toLocalDate().toString() + " " + LocalDateTime.now().toLocalTime().toString());
    }

}
