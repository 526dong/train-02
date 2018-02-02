package dong.sort;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description �鲢����-�����㷨
 * �����ʼ���к���n��Ԫ�أ����ǿ��԰���������n������������У�ÿ�������еĳ���Ϊ1��Ȼ�������ϲ����õ�n/2������Ϊ2�����������У��������鲢...
 * ����ظ���ֱ���õ�һ������Ϊn����������λ�ã��������򷽷���Ϊ2·�鲢����
 * ʱ�临�Ӷȣ�O(nlogn)
 * ���㷨�Ǿ���ķ��β��ԣ���������ֳ�һЩС������Ȼ��ݹ���⣬���εĽ׶��򽫷ֵĽ׶ν�õĸ����޲���һ�𣬷ֶ���֮�ǵݹ�ǳ���Ч���÷���
 * �鲢������һ�ֱȽ�ռ���ڴ棬��ȴЧ�ʸ����ȶ����㷨��
 */
public class MergeSort {

    /*public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // �鲢����
        mergeSort(arr);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    *//**
     * �鲢����
     *//*
    public static void mergeSort(int[] arr) {
        //���¸����һ��ͬ����С�����鵫�ǲ���������
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }

    *//**
     *
     * @param arr
     * @param tmpArr
     * @param low ��λ
     * @param high ��λ
     *//*
    private static void mergeSort(int[] arr, int[] tmpArr, int low, int high) {
        if (low < high) {
            //������һ��Ϊ2���õ�������ֵ
            int middle = (low + high) / 2;
            //�ݹ����ҵ���-ǰ�벿��
            mergeSort(arr, tmpArr, low, middle);
            //�ݹ����ҵ���-��벿�֣�����int����������ȡ�������Ҫmiddle+1
            mergeSort(arr, tmpArr, middle + 1, high);
            //���й鲢
            myMerge(arr, tmpArr, low, middle + 1, high);
        }
        *//*if (low < high) {
            // ������arr��Ϊarr[0..mid]��arr[mid+1..high]
            int middle = (low + high) / 2;
            // �ݹ齫arr[low..mid]�鲢Ϊ�����tmpArr[low..mid]
            mergeSort(arr, tmpArr, low, middle);
            // �ݹ齫arr[mid+1..high]�鲢Ϊ�����tmpArr[mid+1..high]
            mergeSort(arr, tmpArr, middle + 1, high);
            // ��arr[low..mid]��arr[mid+1..high]�鲢��tmpArr[low..high]
            merge(arr, tmpArr, low, middle + 1, high);
        }*//*
    }

    *//**
     * �ϲ�
     * @param arr
     * @param tempArr
     * @param low ��λ
     * @param nextMiddle ��λ
     * @param high ��λ
     *//*
    private static void myMerge(int[] arr, int[] tempArr, int low, int nextMiddle, int high){
        int preMiddle = nextMiddle - 1;
        int tempPos = low;
        int elementNumbers = high - low + 1;

        // ��arr�еļ�¼��С����鲢��tempArr
        while (low <= preMiddle && nextMiddle <= high) {
            if (arr[low] <= arr[nextMiddle]) {
                // �ӵ�һ��Ԫ�ؿ�ʼcopy
                tempArr[tempPos++] = arr[low++];
            } else {
                // ���м�ֵ����һ����ʼcopy
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


    // �������arr[low..mid]��arr[mid+1..high]�鲢Ϊ�����tmpArr[low..high]
    private static void merge(int[] arr, int[] tmpArr, int lowPos, int highPos, int highEnd) {
        int lowEnd = highPos - 1;
        int tmpPos = lowPos;
        int numElements = highEnd - lowPos + 1;

        // ��arr�еļ�¼��С����鲢��tmpArr
        while (lowPos <= lowEnd && highPos <= highEnd){
            if (arr[lowPos] <= arr[highPos]){
                tmpArr[tmpPos++] = arr[lowPos++];
            }else{
                tmpArr[tmpPos++] = arr[highPos++];
            }
        }

        // ��ʣ���arr[low..mid]���Ƶ�tmpArr
        while (lowPos <= lowEnd){
            tmpArr[tmpPos++] = arr[lowPos++];
        }
        // ��ʣ���arr[mid+1..high]���Ƶ�tmpArr
        while (highPos <= highEnd){
            tmpArr[tmpPos++] = arr[highPos++];
        }
        // Copy tmpArr back
        for (int i = 0; i < numElements; i++, highEnd--){
            arr[highEnd] = tmpArr[highEnd];
        }
    }*/


    /**
     * �鲢����-��Ҫ�����÷���˼�룬��һ��������зָ�ɶ��С�����н�������Ȼ���ٽ��й鲢���
     * ����ʹ�õ���2·�鲢����Ե�ǰ���н��й鲢����
     */

    /**
     * ����ݹ�
     */
    public static void sort(int[] arr){
        int[] tempArr = new int[arr.length];
        diGuiSort(arr, tempArr, 0, arr.length-1);
    }

    /**
     *
     * @param arr ��������
     * @param tempArr ��ֵ����
     * @param low ��λ
     * @param high ��λ
     */
    public static void diGuiSort(int[] arr, int[] tempArr, int low, int high){
        /**
         * һ��ͨ�����ַ������в��ϵĽ��ж��ַָ�
         */
        //int������ȡ��
        int middle = (low + high) / 2;
        //ǰ�벿�ֽ��еݹ����
        diGuiSort(arr, tempArr, low, middle);
        //��벿�ֽ��еݹ����
        diGuiSort(arr, tempArr, middle+1, high);
        //�������й鲢
        mergeSort(arr, tempArr, low, middle+1, high);
    }

    /**
     * �������ݹ鲢
     * @param arr �������
     * @param tempArr �м����飬���ڽ�������
     * @param low ��λ
     * @param middle ��λ
     * @param high ��λ
     */
    public static void mergeSort(int[] arr, int[] tempArr, int low, int middle, int high) {
        //�������λ
        int preMiddle = middle - 1;
        //�����м�ֵ�����ڲ��ϵĸ��±仯
        int tempPos = low;
        //��ǰ�ڵ�����
        int eleNumbers = high - low + 1;
        while (low <= preMiddle && middle <= high) {
            //�����ߵ�ֵ����ǰ�ߵ�ֵ
            if (arr[low] <= arr[middle]) {
                tempArr[tempPos++] = arr[low++];
            } else {
                tempArr[tempPos++] = arr[middle++];
            }
        }
        //��λ��ֵ
        while (low <= preMiddle) {
            tempArr[tempPos++] = arr[low++];
        }
        //��λ��ֵ
        while (middle <= high) {
            tempArr[tempPos++] = arr[middle++];
        }
        //�����������︳ֵ
        for (int i = 0; i < eleNumbers; i++, high--) {
            arr[high] = tempArr[high];
        }
    }
}
