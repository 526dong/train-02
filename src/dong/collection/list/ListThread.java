package dong.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ��֤ArrayListΪ�̲߳���ȫ�Լ��������
 * @author microsoft
 *
 */
public class ListThread {

    public ListThread() {

        long start = System.currentTimeMillis();

        ThreadGroup group = new ThreadGroup("testGroup");

        MyThread at = new MyThread();

        for(int i = 0;i < 1000000;i++){
            Thread th = new Thread(group, at, String.valueOf(i));
            th.start();
        }

        while (group.activeCount() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        /*System.out.println(at.list0.size());
        System.out.println(at.list0.get(0));*/

    }

    public static void main(String[] args) {
        new ListThread();
    }

    class MyThread implements Runnable {

        //Vector<String> list0 = new Vector<String>(); //thread not safe
        List<String> list0 = new ArrayList<String>(); //thread not safe
        //List<String> list0 = Collections.synchronizedList(new ArrayList<String>()); //thread safe
        public void run() {
            try {
                Thread.sleep((int)(Math.random()*2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list0.add(Thread.currentThread().getName());
        }
    }
}