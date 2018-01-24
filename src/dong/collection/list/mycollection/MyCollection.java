package dong.collection.list.mycollection;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description
 */
public interface MyCollection<E> extends MyIterable<E> {
    /**
     * 集合大小
     * @return
     */
    int size();

    /**
     * 集合是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 集合中是否包含某个obj元素
     * @param o
     * @return
     */
    boolean contains(Object o);

    /**
     * 迭代器
     * @return
     */
    MyIterator<E> iterator();

    /**
     * 将集合转化为obj数组
     * @return
     */
    Object[] toArray();

    /**
     * 将集合转化为泛型数组
     * @param t
     * @param <T>
     * @return
     */
    <T> T[] toArray(T[] t) ;

    /**
     * 集合添加元素
     * @param a
     * @return
     */
    boolean add(E a);

    /**
     * 删除集合中某个元素
     * @param a
     * @return
     */
    boolean remove(Object a);

    /**
     * 是否包含集合
     * @param c
     * @return
     */
    boolean containsAll(MyCollection<?> c);

    /**
     * 添加集合
     * @param c
     * @return
     */
    boolean addAll(MyCollection<? extends E> c);

    /**
     * 删除集合
     * @param c
     * @return
     */
    boolean removeAll(MyCollection<?> c);

    /**
     *
     * @param c
     * @return
     */
    boolean retainAll(MyCollection<?> c);

    /**
     * 清空集合，交付给gc处理
     */
    void clear();

    /**
     * 判断值是否相同
     * @param o
     * @return
     */
    boolean myEquals(Object o);

    /**
     * 计算哈希值
     * @return
     */
    int myHashCode();
}
