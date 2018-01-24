package dong.async.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ${xzd} on 2018/1/13.
 * @Description ThreadLocal是通过空间来换时间，相当于为每个线程都分配一个自己的临界区。变相的避免了多线程问题
 * 我们可以自己实现一个ThreadLocal，其内部实现就是内部map的增删改查
 * map key-当前线程，value-本地变量
 *
 * 同步机制，通过时间换空间，访问串行化，对象共享化
 * ThreadLocal，通过空间换时间，访问并行化，对象独享化
 *
 * ThreadLocal可以用来保存Hibernate的Session对象
 */
public class SimpleThreadLocal {
    private Map map = Collections.synchronizedMap(new HashMap());

    public void set(Object newValue) {
        // 键为线程对象，值为本线程的变量副本
        map.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();

        // 返回本线程对应的变量
        Object obj = map.get(currentThread);

        // 如果在Map中不存在，放到Map中保存起来
        if (obj == null && !map.containsKey(currentThread)) {
            obj = initialValue();
            map.put(currentThread, obj);
        }
        return obj;
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }
}
