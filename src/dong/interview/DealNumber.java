package dong.interview;

import java.util.*;

/**
 * @author Created by xzd on 2018/1/16.
 * @Description
 */
public class DealNumber {

    /**
     * 实现步骤
     * 1、数组
     * 2、把数组放到map中，key为数字，value为数字出现个数
     * 3、遍历map，读map进行自定义排序，主要是通过value来排序，value相同，则通过key来排序
     */

    private static final int[] arr =
            {1,1,1,1,1,2,2,3,3,3,3,3,3,3,3,4,5,5,5,345,6,64,676,37,8,8,8};

    public static void putNumberToMap(Map<Integer, Integer> map){
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (map.get(number) != null) {
                //存在+1
                map.put(number, map.get(number)+1);
            } else {
                map.put(number, 1);
            }
        }
        System.out.println("一共有"+map.size()+"个不同的数字");
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(100);
        putNumberToMap(map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                Integer key1 = o1.getKey();
                Integer key2 = o2.getKey();
                Integer value1 = o1.getValue();
                Integer value2 = o2.getValue();
                if (value1.compareTo(value2) == 0) {
                    return key1.compareTo(key2);
                } else {
                    return value1.compareTo(value2);
                }
            }
        });
        System.out.println(list);
    }
}
