package dong.collection.map;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 2017/9/18.
 */
public class HashAddThread {
    public static final HashMap<String, String> firstHashMap = new HashMap<String, String>();
    private static final int loopNum = 1*10;

    public static void main(String args[]) throws InterruptedException {
        HashAddThread TestThreadPool = new HashAddThread();
        long bt = System.currentTimeMillis();
        TestThreadPool.m1();
        long et2 = System.currentTimeMillis();
        System.out.println("[1]��ʱ:"+(et2 - bt)+ "ms");
        /*Thread thread = new Thread();
        long at = System.currentTimeMillis();
        TestThreadPool.m2();
        long et3 = System.currentTimeMillis();
        System.out.println("[2]��ʱ:"+(et3 - at)+ "ms");*/

    }

    public void m1() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int index = 0; index < loopNum; index++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        new Thread().sleep(1000);  //ģ���ʱ����
                        for(int j = 25;j < 50;j++){
                            firstHashMap.put(String.valueOf(j), String.valueOf(j));
                        }
                        System.out.println("[1]" + Thread.currentThread().getName());
                    } catch (Exception e) {
                    }
                }
            };
            pool.execute(run);
        }
        System.out.println("[1] done!");
        pool.shutdown();
    }

    /*public void m2() {
        AtomicInteger connectionIds = new AtomicInteger(0);
        for (int index = 0; index < loopNum; index++) {
            try {
                new Thread().sleep(1000);  //ģ���ʱ����
                System.out.println("[2]" + Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("[2] done!");
    }*/
}