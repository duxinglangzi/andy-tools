package com.andy.codeCollector;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2018/5/25 </p>
 */
public class TestHashmap {

    public static void main(String[] args) {


        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("a", "vb");
        hashmap.put("s", "er");
        hashmap.put("d", "fg");

//        Iterator<Map.Entry<String, String>> iterators = hashmap.entrySet().iterator();

//        while (iterators.hasNext()) {
//            System.out.println(iterators.next().getValue());
//            if(iterators.next().getKey().equals("s")){
//
//                iterators.remove();// 正常
//            }
////            hashmap.remove("d");//直接从hashtable增删数据就会报错
////			hashmap.put("f", "ff");
//            // hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，会快速失败 (一检测到修改，马上抛异常)
//        }


        Set<String> stringSet = new HashSet<>(hashmap.keySet());
        for(String s : stringSet){
            System.out.println(s);
            hashmap.remove("s");
        }
        System.out.println("-----------");
        Set<String> newString = new HashSet<>(hashmap.keySet());
        for(String s : newString){
            System.out.println(s);
        }


    }



}
