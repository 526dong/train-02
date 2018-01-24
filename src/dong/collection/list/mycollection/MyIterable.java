package dong.collection.list.mycollection;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description
 */
public interface MyIterable<T> {
    /**
     * 调用迭代器
     * @return
     */
    MyIterator<T> myIterator();

}
