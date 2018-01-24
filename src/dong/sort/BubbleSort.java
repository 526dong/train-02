package dong.sort;

import java.util.List;

/**
 * @author Created by xzd on 2017/11/20.
 * @Description ð������javaʵ��
 * ð��������һ�ֽ����������Ļ���˼���������Ƚ����ڼ�¼�Ĺؼ��֣���������򽻻���ֱ��û�з���ļ�¼Ϊֹ��
 * ð�������˼����ǲ��ϵؽ�����ͨ������������յ�����
 * ʱ�临�Ӷȣ�O(n^2)
 * һ������²���ʹ��ð�������㷨����Ϊ���ıȽϴ������ƶ����������������㷨��ȣ��������ģ�����Ψһ�ô����㷨�򵥣�������⡣
 * ��������������С��ʱ�����ʹ�á�
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
     * ð���������Ҫ˼����ǽ���
     * @param arr
     */
    public static void bubbleSortMyOwn(int[] arr){
        long start = System.currentTimeMillis();
        //�Ľ��汾������һ���������͵Ŀ���
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            /*flag = false;*/
            for (int j = i+1; j < arr.length && flag; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    /*//������ɣ���ֵΪtrue
                    flag = true;*/
                }
            }
            /*System.out.println("��"+(i+1)+"�������");
            for (int k = 0; k < arr.length; k++) {
                System.out.print("["+arr[k]+"]");
            }
            System.out.println("��"+(i+2)+"������ǰ��");*/
        }
        long end = System.currentTimeMillis();
        System.out.println("����ʱ��Ϊ��"+(end - start));
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
            System.out.println("��"+(i+1)+"�������");
            for (int k = 0; k < arr.length; k++) {
                System.out.print("["+arr[k]+"]");
            }
            System.out.println("��"+(i+2)+"������ǰ��");
        }
    }

    /**
     * ð������-�Ż����ð�����򣬿��Լ���һ���������ͱ���������
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
     * ð������javaʵ��
     * @param arrays ��Ҫ���������
     * @return
     */
    public static int[] bubbleSort(int[] arrays){
        //�м�ֵ
        int temp = 0;

        //���鳤��
        int count = arrays.length;

        if (count > 0) {
            for (int i = 0; i < count; i++) {
                for (int j = i+1; j < count; j++) {
                    //���ǰ�ߵ�ֵ���ں�ߵ�ֵ
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
     * �����汾�е�ð�����򷽷�
     * @param arrays ��������
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
     * �����汾�е�ð�����򷽷�
     * @param arrays ��������
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

                    System.out.println("��"+i+"������:"+str1);
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
