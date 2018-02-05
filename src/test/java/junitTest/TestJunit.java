package junitTest;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>ClassName: 加入单独测试方式 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/30 17:08 </p>
 */
public class TestJunit extends TestCase {


    public void test_jion(){
        System.out.println(9>>>1);//除以2   位移计算

        Assert.assertEquals(new Long(123L),new Long(123L));

    }

    public void test_sub_list(){
        List<String> phone=new ArrayList<>();
        phone.add("三星");    //索引为0
        phone.add("苹果");    //索引为1
        phone.add("锤子");    //索引为2
        phone.add("华为");    //索引为3
        phone.add("小米");    //索引为4
        //原list进行遍历
        for(String pho:phone){
            System.out.println(pho);
        }
        //生成新list
        phone=phone.subList(1, 4);  //.subList(fromIndex, toIndex)      //利用索引1-4的对象重新生成一个list，但是不包含索引为4的元素，4-1=3
        for (int i = 0; i < phone.size(); i++) { // phone.size() 该方法得到list中的元素数的和
            System.out.println("新的list包含的元素是"+phone.get(i));
        }
    }

    public void test_list_addAll(){
        List<String> phone=new ArrayList<>();
        phone.add("三星");    //索引为0
        phone.add("苹果");    //索引为1
        phone.add("锤子");    //索引为2
        phone.add("华为");    //索引为3
        phone.add("mac");
        phone.add("sony");
        phone.add("dell");
        phone.add("mac1");
        phone.add("sony2");
        phone.add("dell3");


        int index=1;
        while (index >= 1){
            int fromIndex,toIndex= (3*index);
            if(index==1){
                fromIndex =0;
            }else{
                fromIndex = (3*(index-1));
            }
            if(phone.size()>toIndex){
                index ++;
            }else{
                toIndex = phone.size();
                index = -1;
            }
            List<String> lists= phone.subList(fromIndex,toIndex);
            System.out.println(lists);
        }

    }

}
