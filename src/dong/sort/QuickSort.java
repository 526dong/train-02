package dong.sort;

/**
 * @author Created by xzd on 2017/11/20.
 * @Description 快速排序
 * 通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的元素均比另一部分记录的元素小，然后分别对这两部分记录继续进行排序，从而达到整个序列有序的目的。
 * 快速排序是冒泡排序的升级版，因为它的思想也是元素的交换。
 * 上面代码的核心是int pivot = partition(arr, low, high); 在执行它之前，数组值为：{50, 10, 90, 30, 70, 40, 80, 60, 20}
 * partition函数要做的就是先选取当中的一个关键字，比如选择第一个关键字50，然后想尽办法将它放到一个位置，使得它左边的值都比它小，右边的值比它大，
 * 我们将这样的关键字称为枢轴(pivot)。
 * 经过第一次partition函数执行之后，数组变成{20, 10, 40, 30,50, 70, 80, 60, 90}, 并返回5给pivot，数字5表明50放置在数组下标为5的位置。
 * 时间复杂度：O(logn)
 * 由于关键字的比较和交换是跳跃进行的，所以快速排序是一种不稳定的排序方法。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 快速排序
        quickSort(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // 将数组一分为2，返回枢轴值pivot所在的位置
            quickSort(arr, low, pivot - 1); // 对低位子序列递归排序
            quickSort(arr, pivot + 1, high); // 对高位子序列递归排序
        }
    }

    public static void myQuick(int[] arr, int low, int high){
        if (low < high) {
            int div = partition(arr, low, high);
            quickSort(arr, low, div - 1);
            quickSort(arr, div + 1, high);
        }
    }

    /**
     * 使枢轴记录到达正确的位置，并返回其所在的位置
     */
    private static int partition(int[] arr, int low, int high) { // 选定枢轴为low所对应的值
        int pivot = arr[low]; // 序列的第一条记录作为枢轴元素
        while (low < high) { // 从低位往高位遍历
            while (low < high && pivot <= arr[high]) { // 在高位找到比枢轴大的元素，符合要求，继续寻找
                high--;
            }
            arr[low] = arr[high]; // 将比枢轴元素小的记录交换到低位
            while (low < high && pivot >= arr[low]) { // 在低位找到比枢轴小的元素，符合要求，继续寻找
                low++;
            }
            arr[high] = arr[low]; // 将比枢轴记录大的元素交换到高位
        }
        arr[low] = pivot; // 将枢轴放在正确的排序位置
        return low; // 返回枢轴元素所在的位置
    }

    private static int myPart(int[] arr, int low, int high) {
        int div = arr[low];
        //从低位到高位遍历
        while (low < high) {
            //在高位中找到比枢轴大的值，符合要求，继续寻找
            while (low < high && div <= arr[high]) {
                high--;
            }
            arr[low] = arr[low];
            while (low < high && div >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = div;
        return low;
    }

}
