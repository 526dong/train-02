package dong.sortplus;

import java.util.Random;

/**
 * @author Created by xzd on 2018/1/23.
 * @Description
 */
public class MyBaseSort {
    public static void main(String[] args) {
        int length = 10;
        // 主要用来构造数组
        Integer[] arr = new Integer[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(length) + 1;
        }
        print(arr);
        //借助Comparable接口来简化、精确数值比较
        selectPlus(arr);
        print(arr);
    }

    /**
     * 加入比较器进行泛型化
     * 定义：每一趟依次比较相邻的两个数，将小数放在前面，大数放在后面，直到一趟只剩下一个元素。
     * 名字的由来：因为越小的元素会经由交换慢慢"浮"到数列的顶端。
     * 冒泡排序的基本思路：
     * 1、比较相邻的元素，如果第一个大于第二个，就交换它们的位置；
     * 2、从开始第一对到最后一对，对每一对相邻的元素做同样的工作，这样在最后的元素应该是最大的元素；
     * 3、针对所有的元素重复以上的步骤，除了最后一个；
     * 4、重复步骤 1~3，直到排序完成。
     * @param arr
     */
    public static void bubbleSort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(arr[j], arr[i])) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 正冒泡，每趟选出一个最大值，逐步缩小范围
     * @param arr
     */
    public static void bubbleSortPlus1(Comparable[] arr){
        //逐步缩小范围的下标
        int markIndex = arr.length - 1;
        while (markIndex > 0) {
            int pos = 0;
            for (int i = 0; i < markIndex; i++) {
                if (compare(arr[i+1], arr[i])) {
                    swap(arr, i, i + 1);
                    pos = i;
                }
            }
            markIndex = pos;
        }
    }

    /**
     * 正冒泡选择出最大值
     * 反冒泡选择出最小值
     * 前后逐步缩小范围
     * @param arr
     */
    public static void bubbleSortPlus2(Comparable[] arr){
        int low = 0;
        int high = arr.length-1;
        int i;
        while (low < high) {
            for (i = low; i < high; ++i) {
                if (compare(arr[i+1], arr[i])) {
                    swap(arr, i, i+1);
                }
            }
            --high;
            for (i = high; i > low; --i) {
                if (compare(arr[i], arr[i-1])) {
                    swap(arr, i, i-1);
                }
            }
            ++low;
        }
    }

    /**
     * 基本思想
     * 这是思路最简单的排序算法。
     * 1、找到数组中最小的那个元素；
     * 2、将它和数组的第一个元素交换位置（如果第一个元素就是最小元素，那么它就和自己交换）；
     * 3、在剩下的元素中找出最小的元素，将它与剩余元素中的第一个元素交换（即数组第二个元素）；
     * 重复执行 3 ，直到将整个数组排序。
     */
    public static void selectSort(Comparable[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            //默认第一个值为最小值，记录最小值的下标
            int min = i;
            for (int k = i+1; k < arr.length; k++) {
                if (compare(arr[k], arr[min])) {
                    min = k;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * 选择排序，从当前排序中先选出来一个最小值，把最小值和第一个位置互换。再从后边的序列中再选出最小的值，和当前序列中的第一个元素互换位置
     * 不停的这么做，直到只剩下一个元素
     * 需要对序列做两次循环，第一次循环找到最小值，第二次循环进行位置交换，必须清楚的知道该算法的基本思想，并可以手动写出
     */
    public static void mySelect(Comparable[] arr) {
        //array length
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            //初始化最小值下标
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (compare(arr[j], arr[min])) {
                    min = j;
                }
            }
            //选出最小值之后再进行位置交换 select min val to swap position
            swap(arr, i, min);
        }
    }

    /**
     * 改进版本：选出最大值和最小值，逐步缩小范围
     * @param arr
     */
    public static void selectPlus (Comparable[] arr) {
        for (int left = 0, right = arr.length - 1; left < right; left++,right--) {
            int min = left;
            int max = right;
            for (int i = left; i < right; i++) {
                if (compare(arr[i], arr[min])) {
                    min = i;
                }
                if (compare(arr[max], arr[i])) {
                    max = i;
                }
            }
            swap(arr, min, left);
            if (left == max) {
                max = min;
            }
            swap(arr, max, right);
        }
    }

    /**
     * 比较两个数值的大小
     * @param right
     * @param left
     * @return
     */
    public static boolean compare(Comparable right, Comparable left){
        return right.compareTo(left) < 0;
    }

    /**
     * 互换位置跟角标没关系
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印排序后的数组
     * @param arr
     */
    public static void print(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
