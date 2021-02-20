package com.andy.codeCollector;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


/**
 * <p>Description: 描述该类实现了什么功能 </p>
 *
 * @author wuqiong  2017年8月18日
 */
public class ConcurrentHashMapTest {

    /**
     * 方法描述:
     *
     * @param args
     * @return void
     * @author wuqiong 2017年8月18日 下午2:49:12
     */
    public static void main(String[] args) {

        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put("a", "vb");
        table.put("s", "er");
        table.put("d", "fg");
        table.remove("d");
        Iterator<Entry<String, String>> iterator = table.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
            iterator.remove();// 采用iterator直接进行修改 程序正常
            //table.put("c", "wc");//直接从hashtable增删数据就会报错
            //table.remove("d");//直接从hashtable增删数据就会报错 hashtable，hashmap等非并发集合
            // 如果在迭代过程中增减了数据，
        }

        System.out.println("--------------------------------------------------");

        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("a", "vb");
        hashmap.put("s", "er");
        hashmap.put("d", "fg");
        Iterator<Entry<String, String>> iterators = hashmap.entrySet().iterator();

        while (iterators.hasNext()) {
            System.out.println(iterators.next().getValue());
            iterators.remove();// 正常
            hashmap.remove("d");//直接从hashtable增删数据就会报错
//			hashmap.put("f", "ff");
            // hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，会快速失败 (一检测到修改，马上抛异常)
        }

        System.out.println("-----------");

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "vb");
        map.put("s", "er");
        map.put("d", "fg");
        Iterator<Entry<String, String>> mapiterator = map.entrySet().iterator();

        while (mapiterator.hasNext()) {
            System.out.println(mapiterator.next().getValue());
            map.remove("d");// 正常 并发集合不存在快速失败问题
            map.put("c", "wc");// 正常 并发集合不存在快速失败问题
        }
        System.out.println("-----------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue() + ", " + entry.getKey());
        }
        System.out.println("-----------");
        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println(entry.getValue() + ", " + entry.getKey());
        }

    }

    /*
     * final Entry<K,V> nextEntry() { if (modCount != expectedModCount) throw
     * new ConcurrentModificationException(); Entry<K,V> e = next; if (e ==
     * null) throw new NoSuchElementException();
     *
     * if ((next = e.next) == null) { Entry[] t = table; while (index < t.length
     * && (next = t[index++]) == null) ; } current = e; return e; }
     */

}

