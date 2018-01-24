package dong.async.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by ${xzd} on 2018/1/7.
 * @Description
 */
public class MyTest {
    public static void main(String[] args) {
        loop();
    }

    public static void loop(){
        Map<Integer, String> map = new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }
        List<String> list = new ArrayList<>(10);
        map.forEach((k,v)-> {
            list.add(v);
        });
        list.forEach(val -> {
            System.out.println(val);
        });
    }
}
