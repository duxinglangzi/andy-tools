package junitTest;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

import java.time.LocalDateTime;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/12/20 11:25 </p>
 */
public class TestFastJsonLocalDateTime extends TestCase {


    public void test_isse() {

        VO vo=new VO();
        vo.setLocalDateTime(LocalDateTime.now());


        System.out.println(JSON.toJSONString(vo));

//        String str = "{\"localDateTime\":1513740725187}";

        VO vo1 = JSON.parseObject(JSON.toJSONString(vo),VO.class);
        assertEquals(vo.getLocalDateTime(),vo1.getLocalDateTime());
    }


    public static class VO {
        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public LocalDateTime localDateTime;




    }
}