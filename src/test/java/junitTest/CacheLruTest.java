package junitTest;

import com.andy.Test.CacheLRU;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2020/12/17 </p>
 */
public class CacheLruTest {


    public static void main(String[] args) {

        CacheLRU<String,Integer> cacheLRU = new CacheLRU<>(16,0.75F,true);


        cacheLRU.put("a",1);
        cacheLRU.put("b",1);
        cacheLRU.put("c",1);
        cacheLRU.put("d",1);
        cacheLRU.put("e",1);

        cacheLRU.get("a");
        cacheLRU.get("h");
        cacheLRU.get("d");
        cacheLRU.get("d");
        cacheLRU.get("c");

        System.out.println(cacheLRU.keySet());





    }



}
