package dong.sortplus;

import java.util.Random;

/**
 * @author Created by xzd on 2018/1/23.
 * @Description 排序算法类的模板
 */
public class BaseSortEntity {
    /**
     * 排序实现
     * @param arr 待排序数组
     */
    public static void sort(Comparable[] arr) {
        // 各种各样的排序代码，后续实现
        // ......
        bubbleSortPlus1(arr);
    }

    /**
     * 冒泡排序
     * 时间复杂度：最佳情况 O(N) 、最差情况 O(N^2)、平均情况 O(n^2)
     * @param arr
     */
    public static void bubbleSort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (compare(arr[j], arr[i])) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 优化方案 第一种：记录每趟排序中最后一次进行交换的位置，作为下一趟比较结束的位置
     * @param arr
     */
    public static void bubbleSortPlus1(Comparable[] arr) {
        // 第一趟结束的位置
        int indexI = arr.length - 1;
        while (indexI > 0) {
            // 由于记录交换的位置
            int pos = 0;
            for (int indexJ = 0; indexJ < indexI; indexJ++) {
                if (compare(arr[indexJ + 1], arr[indexJ])) {
                    // 记录最后一次交换的位置
                    pos = indexJ;
                    swap(arr, indexJ + 1, indexJ);
                }
            }
            // 将 pos 作为下一趟结束的位置
            indexI = pos;
            /*System.out.println(indexI);
            print(arr);*/
        }
    }

    /**
     * 优化方案 第二种：传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值，我们考虑利用在每趟排序中进行正反两向冒泡的方法，
     * 一次得到两个最终值（最大值 & 最小值），从而使排序趟数几乎减少一半。
     * @param arr
     */
    public static void bubbleSortPlus2(Comparable[] arr){
        int low = 0;
        int high = arr.length - 1;
        int indexI;
        while (low < high) {
            // 正向冒泡找出最大值
            for (indexI = low; indexI < high; ++indexI) {
                if (compare(arr[indexI+1], arr[indexI])) {
                    swap(arr, indexI+1, indexI);
                }
            }
            // 修改 high 值，前移一位
            --high;
            // 反向冒泡，找出最小值
            for (indexI = high; indexI > low; --indexI) {
                if (compare(arr[indexI], arr[indexI-1])) {
                    swap(arr, indexI, indexI-1);
                }
            }
            // 修改 low 值，后移一位
            ++low;
        }
    }

    /*public static void insertSort(Comparable[] arr){
        //插入值
        Integer insertVal;
        //已经排好序的下标
        int sortIndex;
        for (int i = 1; i < arr.length; i++) {
            if (compare(arr[i], arr[i-1])) {
                for (sortIndex = i-1; sortIndex >= 0 && compare(arr[sortIndex+1], insertVal); sortIndex--) {

                }
            }
        }
    }*/

    /**
     * 比较两个元素的大小
     * @param comparableA 待比较元素A
     * @param comparableB 待比较元素B
     * @return 若 A < B,返回 true,否则返回 false
     */
    private static boolean compare(Comparable comparableA, Comparable comparableB) {
        return comparableA.compareTo(comparableB) < 0;
    }

    /**
     * 将两个元素交换位置
     * @param arr 待交换元素所在的数组
     * @param indexI 第一个元素索引
     * @param indexJ 第二个元素索引
     */
    private static void swap(Comparable[] arr, int indexI, int indexJ) {
        Comparable temp = arr[indexI];
        arr[indexI] = arr[indexJ];
        arr[indexJ] = temp;
    }

    /**
     * 打印数组的内容
     * @param arr 待打印的数组
     */
    private static void print(Comparable[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序
     * @param arr 待判断数组
     * @return 若数组有序，返回 true，否则返回 false
     */
    public static boolean isSort(Comparable[] arr) {
        for (int index = 1; index < arr.length; index++) {
            if (compare(arr[index], arr[index - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{23, 4, 15, 37, 6, 59};

        int length = 100000;// 万以下的级别
        Integer[] arr = new Integer[length];
        Integer[] arr2 = new Integer[length];
        Integer[] arr3 = new Integer[length];
        for (int index = 0; index < length; index++) {
            arr[index] = new Random().nextInt(length) + 1;
        }
        //高效复制数组的方法
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.arraycopy(arr, 0, arr3, 0, arr.length);

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start) + "ms");

        start = System.currentTimeMillis();
        bubbleSortPlus1(arr2);
        end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start) + "ms");

        start = System.currentTimeMillis();
        bubbleSortPlus2(arr3);
        end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start) + "ms");

        /*assert isSort(arr);
        print(arr);*/
    }
}
