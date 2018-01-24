package dong.collection.list.mycollection;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description
 */
public interface MyListIterator<E> extends MyIterator <E> {
    /*共有方法-start*/
    /**
     * 判断下一个元素是否存在
     * @return
     */
    @Override
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    @Override
    E next();

    /**
     * 删除元素
     */
    @Override
    void remove();
    /*共有方法-start*/

    /*私有方法 start*/
    /**
     * 判断上一个元素是否存在
     * @return
     */
    boolean hasPrevious();

    /**
     * 获取上一个元素
     * @return
     */
    E previous();

    /**
     * 下一个索引值
     * @return
     */
    int nextIndex();

    /**
     * 上一个索引值
     * @return
     */
    int previousIndex();

    /**
     * 获取元素
     * @param e
     */
    void get(E e);

    /**
     * 更新元素
     * @param e
     */
    void set(E e);
    /*私有方法 end*/
}
