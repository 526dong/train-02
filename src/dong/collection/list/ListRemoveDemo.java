package dong.collection.list;

import dong.collection.list.mycollection.MyArrayList;
import dong.collection.list.mycollection.MyList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Created by xzd on 2017/9/8.
 */
public class ListRemoveDemo {
    public static ArrayList<Integer> list = new ArrayList<>();

    public ListRemoveDemo(){
        list = add();
    }

    public static ArrayList<Integer> add(){
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        list.add(1);
        list.add(2);

        return list;
    }

    public static void remove(List<Integer> list){
        //删除一个元素的同时，下标-1
        for (int i = 0;i < list.size();i++) {
            list.remove(i);
            i--;
        }

        //倒序删除
        for (int i = list.size()-1; i >= 0; i--) {
            list.remove(i);
        }
    }

    public ArrayList<Integer> remove1(List<Integer> list){
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            Integer app = list.get(i);
            if(!newList.contains(app)){
                newList.add(app);
            }
        }

        return newList;
    }

    public ArrayList<Integer> remove2(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            Integer app1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Integer app2 = list.get(j);
                if (app1.compareTo(app2) == 0) {
                    list.remove(app2);
                    j--;
                    i--;
                    list.trimToSize();
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // int length = 10000000;    // 千万级别
        int length = 8000000;        // 百万级别
        Integer[] arr = new Integer[length];
        Integer[] arr2 = new Integer[length];
        for (int index = 0; index < length; index++) {
            arr[index] = new Random().nextInt(length) + 1;
        }

        // for() 循环方法
        long start = System.currentTimeMillis();
        for (int index = 0; index < length; index++) {
            arr2[index] = arr[index];
        }
        long end = System.currentTimeMillis();
        System.out.println("for()循环方法耗费时间：" + (end - start) + "ms");

        // Object.clone() 方法
        start = System.currentTimeMillis();
        arr2 = arr.clone();
        end = System.currentTimeMillis();
        System.out.println("Object.clone()方法耗费时间：" + (end - start) + "ms");

        // Arrays.copyOf() 方法
        start = System.currentTimeMillis();
        arr2 = Arrays.copyOf(arr, length);
        end = System.currentTimeMillis();
        System.out.println("Arrays.copyOf()方法耗费时间：" + (end - start) + "ms");

        // System.arraycopy() 方法
        start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr2, 0, length);
        end = System.currentTimeMillis();
        System.out.println("System.arraycopy()方法耗费时间：" + (end - start) + "ms");
    }

}
