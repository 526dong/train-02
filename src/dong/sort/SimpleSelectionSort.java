package dong.sort;

/**
 * @author Created by xzd on 2018/1/16.
 * @Description 简单选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数中再找出最小的与第二个位置的数交换，如此循环至倒数第二个数和最后一个数比较为止。
 * 算法关键：找到最小的那个数，并用变量记住它的下标。
 * 时间复杂度：O(n^2)
 * 该算法最大的特点就是交换移动数据次数相当少，这会节约相应的时间。分析它的时间复杂度你会发现，无论最好最差的情况，其比较次数都是一样的多。
 * 简单选择排序的性能上还是要略优于冒泡排序。
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        int[] arr = { 9, 1, 5, 8, 3, 7, 4, 6, 2 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 简单选择排序
        simpleSelectionSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 简单选择排序
     */
    private static void simpleSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 元素交换位置
     */
    private static void swap(int[] arr, int i, int min) {
        int tmp = arr[min];
        arr[min] = arr[i];
        arr[i] = tmp;
    }

}
