package dong.collection.list.mycollection;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Created by ${xzd} on 2017/12/4.
 * @Description
 */
public class MyArrayList<E> implements MyList<E>, Serializable{
    //常量和变量

    /**
     * 默认容量
     */
    private final static int INIT_CAPACITY = 10;

    /**
     * 空集合
     */
    private final static Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 数组最大size
     */
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 存放值的集合，反序列化时不可见
     */
    private transient Object[] elementData;

    /**
     * 修改次数
     */
    private transient int modCount;

    /**
     * 集合大小
     */
    private int size;

    //构造函数

    /**
     * 无参构造函数，默认值初始化
     * @return
     */
    public MyArrayList(){
        super();
        this.elementData = EMPTY_ELEMENTDATA;
    }

    /**
     * 无参构造函数，默认值初始化
     * @param capacity 明确初始化容量
     * @return
     */
    public MyArrayList(int capacity){
        super();

        if (capacity < 0) {
            //不合法的语句
            throw new IllegalArgumentException("Illegal Capacity:" + capacity);
        }
        this.elementData = new Object[capacity];
    }

    /**
     * 传入集合构造函数
     * @param c
     */
    public MyArrayList(MyCollection<? extends E> c){
        elementData = c.toArray();
        size = elementData.length;

        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }

    /**
     * 具体初始化方法和扩容方法
     * @return
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(INIT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    /**
     * 判断是否需要扩容
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 扩容的具体方法，调用底层的数组复制
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        //1.5倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 超出最大容量处理
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     *
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     *
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public MyIterator<E> myIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] t) {
        return null;
    }

    @Override
    public boolean add(E a) {
        ensureCapacityInternal(size+1);
        elementData[size++] = a;
        return true;
    }

    @Override
    public boolean remove(Object a) {
        return false;
    }

    @Override
    public boolean containsAll(MyCollection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(MyCollection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(MyCollection<?> c) {
        return false;
    }

    /**
     * let gc
     */
    @Override
    public void clear() {

    }

    @Override
    public boolean myEquals(Object o) {
        return false;
    }

    @Override
    public int myHashCode() {
        return 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size-1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public MyListIterator<E> myListIterator() {
        return null;
    }

    @Override
    public MyListIterator<E> myListIterator(int index) {
        return null;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public MyIterator<E> iterator() {
        return null;
    }
}
