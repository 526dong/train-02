package dong.collection.map;

import org.junit.Test;

import java.util.*;

/**
 * @author Created by ${xzd} on 2018/1/13.
 * @Description
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        my();
    }

    public static void base(){
        TreeMap<String, String> map = new TreeMap<>();
        putMap(map);
        System.out.println(map);
    }

    public static void my(){
        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        putMap(map);
        System.out.println(map);
    }

    @Test
    public void dealMyBusy(){
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("e");
        list.add("b");

        TreeMap<String, String> map = new TreeMap<>();

        list.forEach((val)->{
            map.put(val, "1");
        });

        System.out.println(map);
        List<String> newList = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            newList.add(next);
        }
        System.out.println(list);
        System.out.println(newList);
    }

    public static void putMap(TreeMap<String, String> map){
        map.put("二匍1", "1");
        map.put("性性", "1");
        map.put("a傍議", "1");
        map.put("a込込", "1");
        map.put("c", "1");
    }

    @Test
    public void testTreeSet(){
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("f");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("b");
        treeSet.add("e");
        System.out.println(treeSet);

        while (true) {

        }

    }
}
