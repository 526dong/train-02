package dong.lock;

import java.text.ParseException;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by xzd on 2017/12/5.
 * @Description ReenTrantLock深入
 */
public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {}

    /**
     * 通过ThreadPoolExecutor获取线程池的方法
     */
    public void getThreadPool_01(){
        //设置核心池大小
        int corePoolSize = 5;
        //设置线程池最大能接受多少线程
        int maximumPoolSize = Integer.MAX_VALUE -8;
        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 200;
        //设置时间单位，秒
        TimeUnit timeUnit = TimeUnit.SECONDS;
        //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
        //创建ThreadPoolExecutor线程池对象，并初始化该对象的各种参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, timeUnit, workQueue);
        //往线程池中循环提交线程
        for (int i = 0; i < 15; i++) {
            //创建线程类对象
            MyTask myTask = new MyTask(i);
            //开启线程
            executor.execute(myTask);
            //获取线程池中线程的相应参数
            //System.out.println("线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
        }

        //待线程池以及缓存队列中所有的线程任务完成后关闭线程池。
        executor.shutdown();
    }

    /**
     * 通过ThreadPoolExecutor获取线程池的方法
     */
    public void getThreadPool_02() {
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executor.execute(new MyTask(i));
        }

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 100, 200L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
    }
}

/**
 *线程类
 */
class MyTask implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();
    private int num;

    public MyTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        //System.out.println("正在执行task " + num );
        try {
            //updateName(Thread.currentThread().getName());
            updateName(Thread.currentThread().getName());

            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("task " + num + "执行完毕");
    }

    /**
     *
     */
    public void updateName(String name) {
        // block until condition holds
        String myName = "user";

        lock.lock();

        try {
            // method body
            myName = name;
            System.out.println(myName);
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
        }*/
    }

    /**
     * 获取（未来时间戳-当前时间戳）的差值，
     * 也即是：（每个线程的睡醒时间戳-每个线程的入睡时间戳）
     * 作用：用于实现多线程高并发
     * @return
     * @throws ParseException
     *//*
    public long getDelta() throws ParseException {
        //获取当前时间戳
        long t1 = new Date().getTime();
        //获取未来某个时间戳（自定义，可写入配置文件）
        String str = "2016-11-11 15:15:15";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long t2 = simpleDateFormat.parse(str).getTime();
        return t2 - t1;
    }*/
}
