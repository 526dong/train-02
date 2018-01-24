package dong.sort;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description 希尔排序
 * 将原本有大量记录数的记录进行分组，分割成若干个子序列，此时每个子序列待排序的记录个数就比较少了，
 * 然后在这些子序列内分别进行直接插入排序，当整个序列都基本有序时，再对全体记录进行一次直接插入排序。
 * 所谓的基本有序，就是小的关键字基本在前面，大的基本在后面，不大不小的基本在中间，像{2, 1, 3, 6, 4, 7, 5, 8, 9}这样可以称为基本有序了。
 * 希尔排序时间复杂度：O(nlogn)
 * 希尔排序并不是一种稳定的排序算法。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 希尔排序
        shellSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 希尔排序
     */
    private static void shellSort(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j = j - gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

}
