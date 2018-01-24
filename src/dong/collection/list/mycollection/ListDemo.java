package dong.collection.list.mycollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Created by ${xzd} on 2017/12/28.
 * @Description
 */
public class ListDemo {
    public static void main(String[] args) {

    }

    public List<Integer> listAdd() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        return list;
    }

    @Test
    public void listRemove() {
        List<Integer> integers = listAdd();

        /*for (int i = 0; i < integers.size(); i++) {
            integers.remove(i);
            i--;
        }*/

        /*for (int i = integers.size() - 1; i >= 0; i--) {
            integers.remove(i);
        }*/

        integers.clear();

        Iterator<Integer> it = integers.iterator();

        while (it.hasNext()) {
            if (it.next() != null) {
                it.remove();
            }
        }

        System.out.println(integers);
    }
}


