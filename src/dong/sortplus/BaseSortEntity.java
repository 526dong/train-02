package dong.sortplus;

import java.util.Random;

/**
 * @author Created by xzd on 2018/1/23.
 * @Description �����㷨���ģ��
 */
public class BaseSortEntity {
    /**
     * ����ʵ��
     * @param arr ����������
     */
    public static void sort(Comparable[] arr) {
        // ���ָ�����������룬����ʵ��
        // ......
        bubbleSortPlus1(arr);
    }

    /**
     * ð������
     * ʱ�临�Ӷȣ������� O(N) �������� O(N^2)��ƽ����� O(n^2)
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
     * �Ż����� ��һ�֣���¼ÿ�����������һ�ν��н�����λ�ã���Ϊ��һ�˱ȽϽ�����λ��
     * @param arr
     */
    public static void bubbleSortPlus1(Comparable[] arr) {
        // ��һ�˽�����λ��
        int indexI = arr.length - 1;
        while (indexI > 0) {
            // ���ڼ�¼������λ��
            int pos = 0;
            for (int indexJ = 0; indexJ < indexI; indexJ++) {
                if (compare(arr[indexJ + 1], arr[indexJ])) {
                    // ��¼���һ�ν�����λ��
                    pos = indexJ;
                    swap(arr, indexJ + 1, indexJ);
                }
            }
            // �� pos ��Ϊ��һ�˽�����λ��
            indexI = pos;
            /*System.out.println(indexI);
            print(arr);*/
        }
    }

    /**
     * �Ż����� �ڶ��֣���ͳð��������ÿһ���������ֻ���ҵ�һ�����ֵ����Сֵ�����ǿ���������ÿ�������н�����������ð�ݵķ�����
     * һ�εõ���������ֵ�����ֵ & ��Сֵ�����Ӷ�ʹ����������������һ�롣
     * @param arr
     */
    public static void bubbleSortPlus2(Comparable[] arr){
        int low = 0;
        int high = arr.length - 1;
        int indexI;
        while (low < high) {
            // ����ð���ҳ����ֵ
            for (indexI = low; indexI < high; ++indexI) {
                if (compare(arr[indexI+1], arr[indexI])) {
                    swap(arr, indexI+1, indexI);
                }
            }
            // �޸� high ֵ��ǰ��һλ
            --high;
            // ����ð�ݣ��ҳ���Сֵ
            for (indexI = high; indexI > low; --indexI) {
                if (compare(arr[indexI], arr[indexI-1])) {
                    swap(arr, indexI, indexI-1);
                }
            }
            // �޸� low ֵ������һλ
            ++low;
        }
    }

    /*public static void insertSort(Comparable[] arr){
        //����ֵ
        Integer insertVal;
        //�Ѿ��ź�����±�
        int sortIndex;
        for (int i = 1; i < arr.length; i++) {
            if (compare(arr[i], arr[i-1])) {
                for (sortIndex = i-1; sortIndex >= 0 && compare(arr[sortIndex+1], insertVal); sortIndex--) {

                }
            }
        }
    }*/

    /**
     * �Ƚ�����Ԫ�صĴ�С
     * @param comparableA ���Ƚ�Ԫ��A
     * @param comparableB ���Ƚ�Ԫ��B
     * @return �� A < B,���� true,���򷵻� false
     */
    private static boolean compare(Comparable comparableA, Comparable comparableB) {
        return comparableA.compareTo(comparableB) < 0;
    }

    /**
     * ������Ԫ�ؽ���λ��
     * @param arr ������Ԫ�����ڵ�����
     * @param indexI ��һ��Ԫ������
     * @param indexJ �ڶ���Ԫ������
     */
    private static void swap(Comparable[] arr, int indexI, int indexJ) {
        Comparable temp = arr[indexI];
        arr[indexI] = arr[indexJ];
        arr[indexJ] = temp;
    }

    /**
     * ��ӡ���������
     * @param arr ����ӡ������
     */
    private static void print(Comparable[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    /**
     * �ж������Ƿ�����
     * @param arr ���ж�����
     * @return ���������򣬷��� true�����򷵻� false
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

        int length = 100000;// �����µļ���
        Integer[] arr = new Integer[length];
        Integer[] arr2 = new Integer[length];
        Integer[] arr3 = new Integer[length];
        for (int index = 0; index < length; index++) {
            arr[index] = new Random().nextInt(length) + 1;
        }
        //��Ч��������ķ���
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.arraycopy(arr, 0, arr3, 0, arr.length);

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("�ķ�ʱ�䣺" + (end - start) + "ms");

        start = System.currentTimeMillis();
        bubbleSortPlus1(arr2);
        end = System.currentTimeMillis();
        System.out.println("�ķ�ʱ�䣺" + (end - start) + "ms");

        start = System.currentTimeMillis();
        bubbleSortPlus2(arr3);
        end = System.currentTimeMillis();
        System.out.println("�ķ�ʱ�䣺" + (end - start) + "ms");

        /*assert isSort(arr);
        print(arr);*/
    }
}
