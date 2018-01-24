package dong.async;

/**
 * @author Created by xzd on 2017/9/20.
 * @Description 区别于wait和sleep
 * wait wait是Object类中的方法，任何类都可以调用/当前线程释放锁对象，进入等待状态，只有被唤醒后才可以进行竞争锁。而不是立即获得锁对象。
 * sleep sleep是线程类Thread中方法/暂停当前线程一段时间，不释放锁对象，一段时间后，线程继续执行。
 */
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Wait(), "wait thread");
        System.out.println(A.getState());
        A.start();
        System.out.println(Thread.currentThread().getName());

        /*A.start();
        System.out.println(A.getState());
        Thread.currentThread().isInterrupted();
        TimeUnit.SECONDS.sleep(2);
        Thread B = new Thread(new Notify(), "notify thread");
        B.start();*/
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true");
                        lock.wait();
                        System.out.println(Thread.currentThread().isInterrupted());
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                lock.notifyAll();
                try {
                    System.out.println("notify wait thread");
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
