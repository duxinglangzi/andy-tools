package junitTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2020/12/10 </p>
 */
public class MapTest {


    public static void main(String[] args) {

//        HashMap map = new HashMap();
//        new Thread(()->{
//            for(int i=0;i<100000;i++){
//                map.put(i,i*i);
//            }
//        }).start();
//        new Thread(()->{
//            map.keySet().stream().forEach(o -> System.out.println(map.get(o)));
//        }).start();

        Map<Object, Object> m1 = new HashMap<>();
        Map<Object, Object> m2 = new TreeMap<>();
        Map<Object, Object> m3 = new Hashtable<>();
        Map<Object, Object> m4 = new ConcurrentHashMap<>();


        try {
            m1.put("zzz", null);
        } catch (Exception e) {
            System.out.println("m1-a：" + e.getMessage());
        }
        try {
            m1.put(null, null);
        } catch (Exception e) {
            System.out.println("m1-b：" + e.getMessage());
        }
        try {
            m2.put("zzz", null);
        } catch (Exception e) {
            System.out.println("m2-a：" + e.getMessage());
        }
        try {
            m2.put(null, null);
        } catch (Exception e) {
            System.out.println("m2-b：" + e.getMessage());
        }
        try {
            m3.put("zzz", null);
        } catch (Exception e) {
            System.out.println("m3-a：" + e.getMessage());
        }
        try {
            m3.put(null, null);
        } catch (Exception e) {
            System.out.println("m3-b：" + e.getMessage());
        }
        try {
            m4.put("zzz", null);
        } catch (Exception e) {
            System.out.println("m4-a：" + e.getMessage());
        }
        try {
            m4.put(null, null);
        } catch (Exception e) {
            System.out.println("m4-b：" + e.getMessage());
        }


    }

}
