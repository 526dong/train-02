package dong.async;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ${xzd} on 2018/1/25.
 * @Description
 */
public class TestFastFail {
    public static List<Integer> list = new ArrayList<>(20);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        },"dong-train01");
        t1.start();
        Thread t2 = new Thread(new ThreadRemove(), "dong-train02");
        t2.start();

        Thread.sleep(3000);

        System.out.println(list.size());
    }

    static class ThreadFind implements Runnable{

        @Override
        public void run() {
            try {
                for (int i = 0; i < list.size(); i++) {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"Êä³ö£º"+list.get(i));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class ThreadRemove implements Runnable{

        @Override
        public void run() {
            list.remove(Thread.currentThread().getName()+"É¾³ý£º"+10);
        }
    }
}
