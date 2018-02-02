package dong.async.concurrent;

import java.util.StringTokenizer;

/**
 * @author Created by ${xzd} on 2018/1/13.
 * @Description ThreadLocal不是一个线程，而是线程的一个本地化对象。线程的本地变量
 */
public class ThreadLocalDemo {
    private static Index num = new Index();

    // 创建一个Index类型的本地变量
    private static ThreadLocal<Index> local = new ThreadLocal<Index>() {
        @Override
        protected Index initialValue() {
            //return num; // 注意这里，返回的是一个已经定义好的对象num，而不是new Index() --> 返回的不是副本
            //接口实现中，
            //返回已经定义好的对象的话会一直对当前的对象做处理，在多线程下会出现数据不一致的问题。
            //返回新创建的副本，各个线程将自己读取自己的副本，互不影响
            return new Index();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 取出当前线程的本地变量，并累加5次
                    Index index = local.get();
                    for (int i = 0; i < 5; i++) {
                        index.increase();
                    }

                    // 重新设置累加后的本地变量
                    local.set(index);
                    System.out.println(Thread.currentThread().getName() + " : " + index.num);
                }
            }, "Thread-" + i);
        }

        String str = "";

        StringTokenizer st = new StringTokenizer(str, ",");

        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class Index {
        int num;
        public void increase() {
            num++;
        }
    }
}
