package dong.sort;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description 插入排序，把数列中的第一个值当作插入值来进行排序
 * 关键：在前面已经排好序的序列中找到合适的插入位置
 * 步骤：
 * 1. 从第一个元素开始，该元素可以认为已经排好序。
 * 2. 取出下一个元素，在已经排好序的元素序列中从后往前扫描进行比较。
 * 3. 如果该元素(已排序) 大于新元素，则将该元素移到下一位置。
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置。
 * 时间复杂度：O(n^2)
 * 直接插入排序法比冒泡和简单选择排序性能要好一些。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+arr[i]+"]");
        }
        //调用插入排序算法
        myInsertSort(arr);
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+arr[i]+"]");
        }
    }

    /**
     * 自己写的插入排序
     * 第一步，先把第一个数当作插入值
     * arr array
     */
    public static void myInsertSort(int[] arr){
        //插入值，在不断变化、更新的插入值
        int insertNum;
        //已排序好的数列中最后一个值的索引
        int sortIndex;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                insertNum = arr[i];
                for (sortIndex = i-1; sortIndex >= 0 && arr[sortIndex] > insertNum ; sortIndex--) {
                    arr[sortIndex+1] = arr[sortIndex];
                }
                arr[sortIndex+1] = insertNum;
            }
        }
    }

    /**
     * 插入排序实现
     * @param arr
     */
    public static void insertSort(int[] arr){
        if (arr == null && arr.length == 0) {
            throw new RuntimeException("数组为空");
        }
        if (arr.length > 1) {
            // 循环数组时将第一个元素默认为插入元素,相当于插入元素在不停的改变
            // 记录当前已经排序的下标值
            int sortIndex;
            // 待排序的下标值
            int noSortIndex;
            for (int i = 1; i < arr.length; i++) {
                // 当前元素值小于他的前一个元素值
                if (arr[i] < arr[i-1]) {
                    // 赋值给待排序元素
                    noSortIndex = arr[i];
                    // 从后往前遍历已排序列表，逐个和待排序元素比较，如果已排序元素较大，则将它后移
                    for (sortIndex = i-1; sortIndex >= 0 && arr[sortIndex] > noSortIndex; sortIndex--) {
                        arr[sortIndex+1] = arr[sortIndex];
                    }
                    // 将待排序元素插入到正确的位置
                    arr[sortIndex+1] = noSortIndex;
                }
            }
        } else {
            throw new RuntimeException("数组只有一个字段，无需排序");
        }
    }

    public static void mySort(int[] arr){
        //插入值
        int insertNum;
        //排序下表
        int sortIndex;
        //两个值去比较，所以需要从下标1开始
        for (int i = 1; i < arr.length; i++) {
            //如果后边的数小于前边的数，才有必要进行排序，进行位置交换
            if (arr[i] < arr[i-1]) {
                //给插入值赋值
                insertNum = arr[i];
                //倒序比较，把插入值放到合适的位置
                for (sortIndex = i-1; sortIndex >=0 && insertNum < arr[sortIndex] ; i--) {
                    arr[sortIndex+1] = arr[sortIndex];
                }
                //第一个值赋值
                arr[sortIndex+1] = insertNum;
            }
        }
    }
}
