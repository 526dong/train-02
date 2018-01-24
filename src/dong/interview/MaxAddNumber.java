package dong.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description
 */
public class MaxAddNumber {
    public static final String number = "28953456323";

    public static void main(String[] args) {

    }

    public static void getMaxAdd(){
        List<Integer> list = new ArrayList<>();
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                /*if () {

                }*/
            }
        }

        //找到递增的元素后放到list里边，然后通过compare排序，找到最大值

    }
}
