package dong.async.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Created by xzd on 2017/11/30.
 * @Description ArrayBlockingQueue FIFO，先进先出
 */
public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        testBaseOpt();
    }

    public static void testBaseOpt() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        queue.put("3");
        queue.put("1");
        queue.put("2");
        //先进先出
        Object take = queue.take();
        System.out.println(take);
    }

    public static void test () throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
