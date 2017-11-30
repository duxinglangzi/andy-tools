package junitTest;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * <p>ClassName: 加入单独测试方式 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/30 17:08 </p>
 */
public class TestJunit extends TestCase {


    public void test_jion(){


        Assert.assertEquals(new Long(123L),new Long(123L));

    }


}
