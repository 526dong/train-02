package dong.sort;

import java.util.List;

/**
 * @author Created by xzd on 2017/11/20.
 * @Description 冒泡排序java实现
 * 冒泡排序是一种交换排序，它的基本思想是两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为止。
 * 冒泡排序的思想就是不断地交换，通过交换完成最终的排序。
 * 时间复杂度：O(n^2)
 * 一般情况下不会使用冒泡排序算法，因为它的比较次数和移动次数和其他排序算法相比，都是最多的，它的唯一好处是算法简单，便于理解。
 * 所以在数据量很小的时候可以使用。
 */
public class BubbleSort {
    public static void main(String[] args) {
        //test array
        int[] arrays = {23, 4, 15, 37, 6, 59};

        bubbleSortMyOwn(arrays);

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    /**
     * 冒泡排序的主要思想就是交换
     * @param arr
     */
    public static void bubbleSortMyOwn(int[] arr){
        long start = System.currentTimeMillis();
        //改进版本，加入一个布尔类型的控制
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            /*flag = false;*/
            for (int j = i+1; j < arr.length && flag; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    /*//交换完成，赋值为true
                    flag = true;*/
                }
            }
            /*System.out.println("第"+(i+1)+"趟排序后：");
            for (int k = 0; k < arr.length; k++) {
                System.out.print("["+arr[k]+"]");
            }
            System.out.println("第"+(i+2)+"趟排序前：");*/
        }
        long end = System.currentTimeMillis();
        System.out.println("排序时间为："+(end - start));
    }

    public static void bubbleSortTest(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后：");
            for (int k = 0; k < arr.length; k++) {
                System.out.print("["+arr[k]+"]");
            }
            System.out.println("第"+(i+2)+"趟排序前：");
        }
    }

    /**
     * 冒泡排序-优化后的冒泡排序，可以加入一个布尔类型变量加入标记
     */
    private static void bubbleSortUpdate(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 冒泡排序java实现
     * @param arrays 需要排序的数组
     * @return
     */
    public static int[] bubbleSort(int[] arrays){
        //中间值
        int temp = 0;

        //数组长度
        int count = arrays.length;

        if (count > 0) {
            for (int i = 0; i < count; i++) {
                for (int j = i+1; j < count; j++) {
                    //如果前边的值大于后边的值
                    if (arrays[i] > arrays[j]) {
                        temp = arrays[i];
                        arrays[i] = arrays[j];
                        arrays[j] = temp;
                    }
                }
            }
        }

        return arrays;
    }

    /**
     * 常见版本中的冒泡排序方法
     * @param arrays 排序数组
     * @return
     */
    public static int[] bubbleSort2(int[] arrays){
        int temp = 0;
        int count = arrays.length;

        if (count > 0) {
            for (int i = 0; i < count-1; i++) {
                for (int j = 0; j < count-1-i; j++) {
                    if (arrays[j] > arrays[j+1]) {
                        temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                    }
                }
            }
        }

        return arrays;
    }

    /**
     * 常见版本中的冒泡排序方法
     * @param arrays 排序数组
     * @return
     */
    public static int[] myBubbleSort(int[] arrays){
        int temp = 0;
        int count = arrays.length;

        if (count > 0) {
            for (int i = 0; i < count-1; i++) {
                for (int j = 0; j < count-1-i; j++) {
                    if (arrays[j] > arrays[j+1]) {
                        temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                    }

                    StringBuilder str1 = new StringBuilder();

                    for (int n = 0; n < count; n++) {
                        str1.append(arrays[n]+"||");
                    }

                    System.out.println("第"+i+"次排序:"+str1);
                }

                StringBuilder str2 = new StringBuilder();

                for (int m = 0; m < count; m++) {
                    str2.append(arrays[m]+"||");
                }
            }
        }

        return arrays;
    }
}
