package dong.design.my;

import dong.design.PCData;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created by ${xzd} on 2017/12/23.
 * @Description 模拟生产者，提交任务到共享数据区
 */
public class MyProducer implements Runnable {
    private volatile boolean isRunning;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public MyProducer (BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData pcData = null;
        Random random = new Random();

        System.out.println(Thread.currentThread().getId());

        try {
            while (true) {
                Thread.sleep(random.nextInt(SLEEPTIME));
                pcData = new PCData(count.incrementAndGet());
                if (!queue.offer(pcData, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed to put data");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
