package dong.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ${xzd} on 2017/12/4.
 * @Description
 */
public class DemoMap {
    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap<>();

        map.put(1, "key");
        map.put(2, "value");

        boolean b = map.containsKey(1);

        System.out.println(b);

        /*for (Map.Entry entry:map.entrySet()) {
            Integer key = (Integer) entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"|"+value);
        }*/
    }
}
