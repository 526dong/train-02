package dong.test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 2017/9/7.
 */
public class StringFormatDemo {
    public static void main(String[] args){
        /*NumberFormat nf = NumberFormat.getInstance();

        Long a = 11111111111111l;
        int a1 = 33333;
        double a2 = 22222222.33;
        System.out.println(nf.format(a));
        System.out.println(nf.format(a1));
        System.out.println(nf.format(a2));

        System.out.println(String.format("" ,a));*/

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();

        while (true) {
            iterator.hasNext();
        }

    }
}
