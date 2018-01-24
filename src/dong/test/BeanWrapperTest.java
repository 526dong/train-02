package dong.test;

import java.util.*;

/**
 * Created by user on 2017/9/12.
 */
public class BeanWrapperTest {
    static int hashSeed;

    public static void main(String[] args) {
        /*DecimalFormat df = new DecimalFormat("#,###.00");
        String format = df.format(23423111111.20);
        System.out.println(format);
         String str = "23423111111.20";
        int i = str.lastIndexOf("0");
        System.out.println(i);*/
        //int i = 0, j = 1;

        /*//&二进制运算符
        //0-0000，1-0001
        System.out.println(i&j);

        //2-0010，16-0001 0000
        System.out.println(2&16);

        //2-0010，6-0110
        System.out.println(2&6);*/

        /*int h = 12;
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println(h >>> 20);
        System.out.println(h >>> 12);
        System.out.println(h);*/


        /*String a = "";
        String b = " ";

        System.out.println(a);
        System.out.println("a:"+a.length());
        System.out.println("b:"+b.length());*/

        Set<String> set = new HashSet<>();
        boolean flag1 = set.add("hello world");
        boolean flag2 = set.add("hello world");

        System.out.println(flag1 +"|"+ flag2);

        /*Map<Integer, Object> myMap = getMap();

        for (Map.Entry<Integer, Object> entry : myMap.entrySet()) {
            int hash = hash(entry.getKey());
            int index = indexFor(hash, myMap.size());
            System.out.println(entry.getKey()+":"+entry.getValue()+"|"+index);
        }*/

        /*Map map = new HashMap();

        for (int i = 0; i < 10000000; i++) {
            map.put(i, i);
        }

        long start = System.currentTimeMillis();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + ":" + val);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/

        /*long start = System.currentTimeMillis();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object val = map.get(key);
            System.out.println(key + ":" + val);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);*/

        /*myMap.put("1", "hello");
        Object world = myMap.put("2", "world");
        System.out.println(world);
        myMap.put(null, null);

        System.out.println(myMap);*/

        //Map<Integer, Object> map = getObject();


        /*for (int i = 1; i < map.size(); i++) {
            Object obj = map.get(i);

            if (obj != null) {
                try {
                    if (obj instanceof String) {
                        System.out.println(obj.toString());
                    } else if (obj instanceof Integer) {
                        System.out.println(Integer.valueOf(obj.toString()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    public static Map<Integer, Object> getMap(){
        //非线程安全
        Map<Integer, Object> map = new HashMap<>();
        //线程安全
        Map<Integer, Object> securityMap = Collections.synchronizedMap(map);

        map.put(33, "hello");
        map.put(2, "world");

        /*for (int i = 0; i < 20; i++) {
            map.put(i, "hello world");
        }*/
        return map;
    }


    /*//计算key的hash
    static final int hash(Object key) {
        int var2 = hashSeed;
        if(0 != var2 && key instanceof String) {
            return Hashing.stringHash32((String)key);
        } else {
            var2 ^= key.hashCode();
            var2 ^= var2 >>> 20 ^ var2 >>> 12;
            return var2 ^ var2 >>> 7 ^ var2 >>> 4;
        }
    }*/

    //寻找数组下标
    static int indexFor(int hash, int tabLength) {
        return hash & tabLength - 1;
    }
}
