package dong.thread;

/**
 * @author Created by xzd on 2017/12/11.
 * @Description 线程的基本操作（一）新建线程
 * start和run方法的区别
 * start方法 新建一个线程，并让这个线程执行run方法。
 * run方法 在当前线程中调用run方法，不能新建一个线程。只是作为一个普通方法来调用。
 */
public class CreateThread {
    public static void main(String[] args) {
        //1
        Thread a = new Thread(new ThreadA(), "my thread");
        //a.start();
        a.run();

        //2
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello kitty");
            }
        });
        b.start();

        //3
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("come on");
            }
        }).start();
    }
}

class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":hello thread");
    }
}
