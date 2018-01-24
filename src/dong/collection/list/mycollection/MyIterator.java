package dong.collection.list.mycollection;

/**
 * @author Created by ${xzd} on 2017/12/4.
 * @Description
 */
public interface MyIterator<E> {
    /**
     * 判断下一个元素是否存在
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    E next();

    /**
     * 删除元素
     */
    void remove();
}
