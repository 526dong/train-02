//package dong.myutils;
//
//import java.util.concurrent.atomic.AtomicReferenceArray;
//
///**
// * @author Created by xzd on 2017/12/19.
// * @Description 通过原子类来实现一个无锁的Vector
// */
//public class MyVector {
//    private static final int N_BUCKET = 30;
//    private static final int FIRST_BUCKET_SIZE = 8;
//    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
//
//    static class Descriptor<E> {
//        public int size;
//        volatile WriteDescriptor<E> writeop;
//
//        public Descriptor(int size, WriteDescriptor<E> writeop){
//            this.size = size;
//            this.writeop = writeop;
//        }
//
//        public void completeWrite(){
//            WriteDescriptor<E> tmpOp = writeop;
//            if (tmpOp != null) {
//                tmpOp.doIt();
//                writeop = null;
//            }
//        }
//    }
//
//    static class WriteDescriptor<E> {
//        public E oldV;
//        public E newV;
//        public AtomicReferenceArray<E> addr;
//        public int addr_int;
//
//        public WriteDescriptor(E oldV, E newV, AtomicReferenceArray<E> addr, int addr_int){
//            this.oldV = oldV;
//            this.newV = newV;
//            this.addr = addr;
//            this.addr_int = addr_int;
//        }
//
//        public void doIt(){
//            addr.compareAndSet(addr_int, oldV, newV);
//        }
//    }
//
//    public MyVector(){
//        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>();
//        buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
//        descriptor = new AtomicReferenceArray<E>(new Descriptor<E>(0, nul));
//    }
//
//    public void push_back(E e){
//        Descriptor<E> desc;
//        Descriptor<E> newd;
//        do {
//            desc = descriptor.get();
//            desc.completeWrite();
//
//            int pos = desc.size + FIRST_BUCKET_SIZE;
//            int zeroNumPos = Integer.numberOfLeadingZeros(pos);
//            int bucketInd = zeroNumFirst - zeroNumPos;
//            if (buckets.get(bucketInd) == null) {
//                int newLen = 2 * buckets.get(bucketInd-1).length();
//                if (debug) {
//                    System.out.println("new length is:"+newLen);
//                }
//                buckets.compareAndSet(bucketInd, null, new AtomicReferenceArray<E>(newLen));
//            }
//            int idx = (0x80000000>>>zeroNumPos) ^ pos;
//            newd = new Descriptor<E>(desc.size+1, new WriteDescriptor<E>(buckets.get(bucketInd), idx, null, e));
//        } while (!descriptor.compareAndSet(desc, newd));
//        descriptor.get().completeWrite();
//    }
//
//    public E get(int index){
//        int pos = index + FIRST_BUCKET_SIZE;
//        int zeroNumPos = Integer.numberOfLeadingZeros(pos);
//        int bucketInd = zeroNumFirst - zeroNumPos;
//        int idx = (0x80000000 >>> zeroNumPos) ^ pos;
//        return buckets.get(bucketInd).get(idx);
//    }
//
//}
