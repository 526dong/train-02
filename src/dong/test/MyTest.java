package dong.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by xzd on 2017/11/28.
 * @Description
 */
public class MyTest {
    public static void main(String[] args) {
        /*int test = test();
        System.out.println(test);*/

        /*int i = 1;
        test(i);
        System.out.println(i);*/

        Map<String, Object> map = new HashMap<>();
        putValToMap(map);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("map", map);
        map.put("haha", 2);
        System.out.println(resultMap.size());
        for (Map.Entry my:resultMap.entrySet()) {
            System.out.println(my.getKey());
            System.out.println(my.getValue());
        }
    }

    public static void putValToMap(Map<String, Object> map){
        map.put("lala", 1);
    }

    public static void test(int i){
        try {
            i = 2;
        } catch (Exception e) {
            i = 3;
        } finally {
            i = 4;
        }
    }

    public static int test(){
        int i = 1;

        try {
            i = 2;
            return i;
        } catch (Exception e) {
            i = 3;
            return i;
        } finally {
            i = 4;
        }
    }
}
