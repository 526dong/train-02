package dong.sort;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description 归并排序-分治算法
 * 假设初始序列含有n个元素，我们可以把它看成是n个有序的子序列，每个子序列的长度为1，然后两两合并，得到n/2个长度为2的有序子序列，再两两归并...
 * 如此重复，直至得到一个长度为n的有序序列位置，这种排序方法称为2路归并排序
 * 时间复杂度：O(nlogn)
 * 此算法是经典的分治策略，它将问题分成一些小的问题然后递归求解，而治的阶段则将分的阶段解得的各答案修补在一起，分而治之是递归非常有效的用法。
 * 归并排序是一种比较占用内存，但却效率高且稳定的算法。
 */
public class MergeSort {

    /*public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 归并排序
        mergeSort(arr);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    *//**
     * 归并排序
     *//*
    public static void mergeSort(int[] arr) {
        //重新搞出来一个同样大小的数组但是不包含数据
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }

    *//**
     *
     * @param arr
     * @param tmpArr
     * @param low 低位
     * @param high 高位
     *//*
    private static void mergeSort(int[] arr, int[] tmpArr, int low, int high) {
        if (low < high) {
            //将数组一分为2，拿到数组中值
            int middle = (low + high) / 2;
            //递归自我调用-前半部分
            mergeSort(arr, tmpArr, low, middle);
            //递归自我调用-后半部分，由于int类型是向下取整，因此要middle+1
            mergeSort(arr, tmpArr, middle + 1, high);
            //进行归并
            myMerge(arr, tmpArr, low, middle + 1, high);
        }
        *//*if (low < high) {
            // 将数组arr分为arr[0..mid]和arr[mid+1..high]
            int middle = (low + high) / 2;
            // 递归将arr[low..mid]归并为有序的tmpArr[low..mid]
            mergeSort(arr, tmpArr, low, middle);
            // 递归将arr[mid+1..high]归并为有序的tmpArr[mid+1..high]
            mergeSort(arr, tmpArr, middle + 1, high);
            // 将arr[low..mid]和arr[mid+1..high]归并到tmpArr[low..high]
            merge(arr, tmpArr, low, middle + 1, high);
        }*//*
    }

    *//**
     * 合并
     * @param arr
     * @param tempArr
     * @param low 低位
     * @param nextMiddle 中位
     * @param high 高位
     *//*
    private static void myMerge(int[] arr, int[] tempArr, int low, int nextMiddle, int high){
        int preMiddle = nextMiddle - 1;
        int tempPos = low;
        int elementNumbers = high - low + 1;

        // 将arr中的记录由小到大归并入tempArr
        while (low <= preMiddle && nextMiddle <= high) {
            if (arr[low] <= arr[nextMiddle]) {
                // 从第一个元素开始copy
                tempArr[tempPos++] = arr[low++];
            } else {
                // 从中间值的下一个开始copy
                tempArr[tempPos++] = arr[nextMiddle++];
            }
        }

        if (low <= preMiddle) {
            tempArr[tempPos++] = arr[low++];
        }
        if (nextMiddle <= high) {
            tempArr[tempPos++] = arr[nextMiddle++];
        }

        // Copy tmpArr back
        for (int i = 0; i < elementNumbers; i++, high--){
            arr[high] = tempArr[high];
        }

        //arr = Arrays.copyOf(tempArr, elementNumbers);
    }


    // 将有序的arr[low..mid]和arr[mid+1..high]归并为有序的tmpArr[low..high]
    private static void merge(int[] arr, int[] tmpArr, int lowPos, int highPos, int highEnd) {
        int lowEnd = highPos - 1;
        int tmpPos = lowPos;
        int numElements = highEnd - lowPos + 1;

        // 将arr中的记录由小到大归并入tmpArr
        while (lowPos <= lowEnd && highPos <= highEnd){
            if (arr[lowPos] <= arr[highPos]){
                tmpArr[tmpPos++] = arr[lowPos++];
            }else{
                tmpArr[tmpPos++] = arr[highPos++];
            }
        }

        // 将剩余的arr[low..mid]复制到tmpArr
        while (lowPos <= lowEnd){
            tmpArr[tmpPos++] = arr[lowPos++];
        }
        // 将剩余的arr[mid+1..high]复制到tmpArr
        while (highPos <= highEnd){
            tmpArr[tmpPos++] = arr[highPos++];
        }
        // Copy tmpArr back
        for (int i = 0; i < numElements; i++, highEnd--){
            arr[highEnd] = tmpArr[highEnd];
        }
    }*/


    /**
     * 归并排序-主要是运用分治思想，将一个大的序列分割成多个小的序列进行排序，然后再进行归并结果
     * 本文使用的是2路归并排序对当前序列进行归并排序
     */

    /**
     * 进入递归
     */
    public static void sort(int[] arr){
        int[] tempArr = new int[arr.length];
        diGuiSort(arr, tempArr, 0, arr.length-1);
    }

    /**
     *
     * @param arr 输入数组
     * @param tempArr 赋值数组
     * @param low 低位
     * @param high 高位
     */
    public static void diGuiSort(int[] arr, int[] tempArr, int low, int high){
        /**
         * 一、通过二分法将序列不断的进行二分分割
         */
        //int是向下取整
        int middle = (low + high) / 2;
        //前半部分进行递归调用
        diGuiSort(arr, tempArr, low, middle);
        //后半部分进行递归调用
        diGuiSort(arr, tempArr, middle+1, high);
        //二、进行归并
        mergeSort(arr, tempArr, low, middle+1, high);
    }

    /**
     * 进行数据归并
     * @param arr 输出数组
     * @param tempArr 中间数组，用于接受数据
     * @param low 低位
     * @param middle 中位
     * @param high 高位
     */
    public static void mergeSort(int[] arr, int[] tempArr, int low, int middle, int high) {
        //定义低中位
        int preMiddle = middle - 1;
        //定义中间值，用于不断的更新变化
        int tempPos = low;
        //当前节点数量
        int eleNumbers = high - low + 1;
        while (low <= preMiddle && middle <= high) {
            //如果后边的值大于前边的值
            if (arr[low] <= arr[middle]) {
                tempArr[tempPos++] = arr[low++];
            } else {
                tempArr[tempPos++] = arr[middle++];
            }
        }
        //低位赋值
        while (low <= preMiddle) {
            tempArr[tempPos++] = arr[low++];
        }
        //高位赋值
        while (middle <= high) {
            tempArr[tempPos++] = arr[middle++];
        }
        //重新向数组里赋值
        for (int i = 0; i < eleNumbers; i++, high--) {
            arr[high] = tempArr[high];
        }
    }
}
