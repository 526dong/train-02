package dong.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by xzd on 2017/12/20.
 * @Description
 */
public class SyncDemo implements Runnable{
    static int i = 0;
//    static ReentrantLock lock = new ReentrantLock();

    public synchronized static void increase(){
        i++;
    }

    /*public void increase(){
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }*/

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SyncDemo());
        Thread t2 = new Thread(new SyncDemo());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}
