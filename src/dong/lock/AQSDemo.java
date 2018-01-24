//package dong.lock;
//
///**
// * @author Created by ${xzd} on 2017/12/14.
// * @Description 队列同步器
// * 方法构造中都包含cas操作（原子操作，无锁状态）
// */
//public class AQSDemo {
//    //AQS中的属性
//    //FIFO队列中的头节点
//    private transient volatile Node head;
//    //FIFO队列中的尾节点
//    private transient volatile Node tail;
//    //锁的状态
//    private volatile int state;
//
//    //Node 类下的属性
//    //共享节点
//    public static Node SHARED = new Node();
//    //独占节点
//    public static Node EXCLUSIVE = null;
//
//    //线程被取消
//    static final int CANCELED = 1;
//    //继任者线程需要唤醒 unpark 唤醒
//    static final int SIGNAL = -1;
//    //线程等待在一个condition上
//    static final int CONDITION = -2;
//    //下一个acquireShared方法需要无条件的传播
//    static final int PROPAGATE = -3;
//
//    //队列中node的上一个节点
//    volatile Node prev;
//    //队列中node的下一个节点
//    volatile Node next;
//    //持有node的线程引用
//    volatile Thread thread;
//
//    //AQS中的方法
//    //独占锁
//    public final void acquire(int arg){};//获取独占锁方法
//    public final void acquireInterruptibly(int arg){};//获取独占锁的可中断版本
//    public final boolean tryAcquireNanos(int arg, long nanosTimeout){};//获取独占锁的带超时版本
//
//    //尝试获取独占锁的方法，交由子类实现，形成各种不同的获取锁策略
//    protected boolean tryAcquire(int arg) {
//        throw new UnsupportedOperationException();
//    }
//    //独占锁释放方法
//    public final boolean release(int arg){};
//    //尝试释放独占锁的方法，交由子类实现，形成各种不同的释放锁策略
//    protected boolean tryRelease(int arg) {
//        throw new UnsupportedOperationException();
//    }
//
//    //共享锁
//    public final void acquireShared(int arg){}//获取共享锁方法
//    public final void acquireSharedInterruptibly(int arg){}//获取共享锁的可中断版本
//    private boolean doAcquireSharedNanos(int arg, long nanosTimeout){}//获取共享锁的带超时版本
//    //尝试获取共享锁的方法，交由子类实现，形成各种不同的获取锁策略
//    protected int tryAcquireShared(int arg) {
//        throw new UnsupportedOperationException();
//    }
//    //尝试释放独占锁的方法，交由子类实现，形成各种不同的释放锁策略
//    public final boolean releaseShared(int arg){}
//    protected boolean tryReleaseShared(int arg) {
//        throw new UnsupportedOperationException();
//    }
//
//
//    /**
//     * 获取独占锁方法解析
//     * @param arg
//     */
//    public final void acquire(int arg) {
//        /**
//         * 1、tryAcquire尝试获取独占锁，成功则获取成功，方法完成，不成功则进入步骤2
//         * 2、addWaiter创建一个独占模式node，添加到锁竞争线程队列并进入到步骤3
//         * 3、acquireQueued竞争线程队列中节点尝试获取锁
//         */
//        if (!tryAcquire(arg) && acquireQueued(addWaiter(Node.EXCLUSIVE), arg)) {
//            selfInterrupt();
//        }
//    }
//
//    private Node addWaiter(Node mode) {
//        //1.新建一个代表当前线程的node
//        Node node = new Node(Thread.currentThread(), mode);
//        // Try the fast path of enq; backup to full enq on failure
//        Node pred = tail;
//        //2.如果等待队列尾节点不为空，则将node加入到队列尾部
//        if (pred != null) {
//            node.prev = pred;
//            if (compareAndSetTail(pred, node)) {
//                pred.next = node;
//                return node;
//            }
//        }
//        //如果队列尾为空，则将node加入到队列头
//        enq(node);
//        return node;
//    }
//
//    final boolean acquireQueued(final Node node, int arg) {
//        boolean failed = true;
//        try {
//            boolean interrupted = false;
//            for (;;) {
//                //1.获取当前节点的前一节点
//                final Node p = node.predecessor();
//                //2.如果前一节点是头节点，则尝试获取锁（公平锁的获取方式，只有队列的第二个节点才会尝试获取锁）
//                if (p == head && tryAcquire(arg)) {
//                    //获取锁则将当前节点设置为头结点
//                    setHead(node);
//                    p.next = null; // help GC
//                    failed = false;
//                    return interrupted;
//                }
//                //3. 获取锁失败后判断是否需要阻塞，如果是进入4
//                //4 阻塞当前线程，如果阻塞后被唤醒状态是已中断，设置为已中断
//                if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt()) {
//                    interrupted = true;
//                }
//            }
//        } finally {
//            if (failed) {
//                cancelAcquire(node);
//            }
//        }
//    }
//
//
//
//}
