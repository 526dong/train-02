package dong.sort;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description 归并排序-分治算法
 * 假设初始序列含有n个元素，我们可以把它看成是n个有序的子序列，每个子序列的长度为1，然后两两合并，得到n/2个长度为2的有序子序列，再两两归并...
 * 如此重复，直至得到一个长度为n的有序序列位置，这种排序方法称为2路归并排序
 * 时间复杂度：O(nlogn)
 * 次算法是经典的分治策略，它将问题分成一些小的问题然后递归求解，而治的阶段则将分的阶段解得的各答案修补在一起，分而治之是递归非常有效的用法。
 * 归并排序是一种比较占用内存，但却效率高且稳定的算法。
 */
public class MergeSort {

    public static void main(String[] args) {
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

    public static void myMergeSort(int[] arr){
        int[] tmepArr = new int[arr.length];

    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }

    private static void mySort(int[] arr, int[] tempArr, int low, int high){
        if (low < high) {
            //拆分为部分
            int middle = (low+high) / 2;
            //递归前半部分进行再拆分
            mySort(arr, tempArr, low, middle);
            //递归后半部分进行再拆分
            mySort(arr, tempArr, middle+1, high);
            myMerge(arr, tempArr, low, middle+1, high);
        }
    }

    private static void mergeSort(int[] arr, int[] tmpArr, int low, int high) {
        if (low < high) {
            // 将数组arr分为arr[0..mid]和arr[mid+1..high]
            int middle = (low + high) / 2;
            // 递归将arr[low..mid]归并为有序的tmpArr[low..mid]
            mergeSort(arr, tmpArr, low, middle);
            // 递归将arr[mid+1..high]归并为有序的tmpArr[mid+1..high]
            mergeSort(arr, tmpArr, middle + 1, high);
            // 将arr[low..mid]和arr[mid+1..high]归并到tmpArr[low..high]
            merge(arr, tmpArr, low, middle + 1, high);
        }
    }

    private static void myMerge(int[] arr, int[] tempArr, int lowPos, int highPos, int highEnd){
        int lowEnd = highPos - 1;
        int tempPos = lowPos;
        int numElements = highEnd - lowPos + 1;

        while (lowPos <= lowEnd && highPos <= highEnd) {
            if (arr[lowPos] <= arr[highPos]) {
                tempArr[tempPos++] = arr[lowPos++];
            } else {
                tempArr[tempPos++] = arr[highPos++];
            }
        }

        // 将剩余的arr[low..mid]复制到tmpArr
        while (lowPos <= lowEnd){
            tempArr[tempPos++] = arr[lowPos++];
        }
        // 将剩余的arr[mid+1..high]复制到tmpArr
        while (highPos <= highEnd){
            tempArr[tempPos++] = arr[highPos++];
        }
        // Copy tmpArr back
        for (int i = 0; i < numElements; i++, highEnd--){
            arr[highEnd] = tempArr[highEnd];
        }
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
    }
}
