package dong.collection.list.mycollection;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description
 */
public interface MyList<E> extends MyCollection<E>{
    /*共有方法 start*/
    /**
     * 集合大小
     * @return
     */
    @Override
    int size();

    /**
     * 集合是否为空
     * @return
     */
    @Override
    boolean isEmpty();

    /**
     * 集合中是否包含某个obj元素
     * @param o
     * @return
     */
    @Override
    boolean contains(Object o);

    /**
     * 遍历器
     * @return
     */
    @Override
    MyIterator<E> myIterator();

    /**
     * 将集合转化为obj数组
     * @return
     */
    @Override
    Object[] toArray();

    /**
     * 将集合转化为泛型数组
     * @param t
     * @param <T>
     * @return
     */
    @Override
    <T> T[] toArray(T[] t) ;

    /**
     * 集合添加元素
     * @param a
     * @return
     */
    @Override
    boolean add(E a);

    /**
     * 删除集合中某个元素
     * @param a
     * @return
     */
    @Override
    boolean remove(Object a);

    /**
     * 是否包含集合
     * @param c
     * @return
     */
    @Override
    boolean containsAll(MyCollection<?> c);

    /**
     * 添加集合
     * @param c
     * @return
     */
    @Override
    boolean addAll(MyCollection<? extends E> c);

    /**
     * 删除集合
     * @param c
     * @return
     */
    @Override
    boolean removeAll(MyCollection<?> c);

    /**
     *
     * @param c
     * @return
     */
    @Override
    boolean retainAll(MyCollection<?> c);

    /**
     * 清空集合，交付给gc处理
     */
    @Override
    void clear();

    /**
     * 判断值是否相同
     * @param o
     * @return
     */
    @Override
    boolean myEquals(Object o);

    /**
     * 计算哈希值
     * @return
     */
    @Override
    int myHashCode();
    /*共有方法 end*/
    /*私有方法 start*/

    /**
     * 通过索引获取集合中的某个元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 通过索引更新集合中的某个元素
     * @param index
     * @param e
     * @return
     */
    E set(int index, E e);

    /**
     * 通过索引添加集合元素
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 通过元素下标删除某个元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 元素下标
     * @param o
     * @return
     */
    int indexOf(Object o);

    /**
     * 最后一个符合的元素下标
     * @param o
     * @return
     */
    int lastIndexOf(Object o);

    /**
     * list迭代器
     * @return
     */
    MyListIterator<E> myListIterator();

    /**
     * list迭代器
     * @return
     * @param index
     */
    MyListIterator<E> myListIterator(int index);

    /**
     * 截取list
     * @param fromIndex
     * @param toIndex
     * @return
     */
    MyList<E> subList(int fromIndex, int toIndex);
    /*私有方法 end*/
}
