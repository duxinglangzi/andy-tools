package junitTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2020/12/10 </p>
 */
public class TestMap2 {
    public static void main(String[] args) {
        Map<String, String> source = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            source.put("key" + i, "value" + i);
        }

        System.out.println("Source:" + source);
        fastFailSceneWhenRemove(source);
        commonSceneWhenRemove(source);

    }

    private static void commonSceneWhenRemove(Map<String, String> source) {
        Iterator<Map.Entry<String, String>> iterator = source.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().contains("2")) {
                iterator.remove();
            }
        }
        System.out.println(source);
    }

    private static void fastFailSceneWhenRemove(Map<String, String> source) {
        for (Map.Entry<String, String> entry : source.entrySet()) {
            if (entry.getKey().contains("1")) {
                source.remove(entry.getKey());
            }
        }
        System.out.println(source);
    }
}
