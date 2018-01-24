package dong.thread;

/**
 * @author Created by xzd on 2017/12/11.
 * @Description 线程中断
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){

            @Override
            public void run() {
                System.out.println("I'm coming!");
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupt");
                        System.out.println(Thread.currentThread().getName()+":state is "+Thread.currentThread().getState());
                        break;
                    }

                    /*try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted when sleep");
                        //Thread.currentThread().interrupt();
                    }*/

                    /*Thread.yield();*/
                }
            }
        };

        t.start();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+":state is "+Thread.currentThread().getState());
        t.interrupt();
        System.out.println(t.getName()+":state is "+t.getState());
    }
}
