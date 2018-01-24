package dong.interview;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description
 * 二叉排序树，也可以称为二叉查找树，它的性质如下：
 * 1.若它的左子树不为空，则左子树上所有的节点均小于其根节点
 * 2.若它的右子树不为空，则右子树上所有的节点的值均大于根节点
 * 3.它的左右子树也分别为二叉排序树
 * 简单起见，假设树中元素都实现了Comparable接口或者他们可以按自然顺序比较
 */
public class BinarySortTree<E> {

    // 根节点
    private Entry<E> root = null;

    // 树中元素个数
    private int size = 0;

    public BinarySortTree() {
    }

    public int size() {
        return size;
    }

    public E getRoot() {
        return root == null ? null : root.element;
    }

    /**
     * 递归实现: 查找指定元素element是否在树中存在，如果查找失败确认其添加的位置,查找成功直接返回
     * @param t 表示从此节点开始往下查找
     * @param f 保存t的父节点
     * @param p 若查找成功p指向此数据元素节点，否则返回查找路径上的最后一个节点
     */
    private boolean searchBST(Entry<E> t, Object element, Entry<E> f, Entry<E> p) {
        if (t == null) {
            p = f;
            return false;
        }
        Comparable<? super E> e = (Comparable<? super E>) element;
        int cmp = e.compareTo(t.element);
        if (cmp < 0) {
            return searchBST(t.left, element, t, p);
        } else if (cmp > 0) {
            return searchBST(t.right, element, t, p);
        } else {
            p = t;
            return true;
        }
    }

    /**
     * 非递归实现
     */
    private boolean searchBST(Object element, Entry[] p) {
        Comparable<? super E> e = (Comparable<? super E>) element;
        Entry<E> parent = root;
        Entry<E> pp = null;
        // 保存parent父节点
        while (parent != null) {
            int cmp = e.compareTo(parent.element);
            pp = parent;
            if (cmp < 0) {
                parent = parent.left;
            } else if (cmp > 0) {
                parent = parent.right;
            } else {
                p[0] = parent;
                return true;
            }
        }
        p[0] = pp;
        return false;
    }

    /**
     * 首先查找二叉排序树，如果找不到指定元素 则插入到二叉树中
     */
    public boolean add(E element) {
        Entry<E> t = root;
        if (t == null) {
            // 如果根节点为空
            root = new Entry<E>(element, null);
            size = 1;
            return false;
        }
        Comparable<? super E> e = (Comparable<? super E>) element;
        Entry[] p = new Entry[1];
        if (!searchBST(element, p)) {
            // 查找失败，插入元素
            Entry<E> s = new Entry<E>(element, p[0]);
            int cmp = e.compareTo((E) p[0].element);
            if (cmp < 0) {
                p[0].left = s;
            }
            if (cmp > 0) {
                p[0].right = s;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * 移除节点，同时调整二叉树使之为二叉排序树 实现原理：
     * 假设要删除的节点为p，其父节点为f，而p是f的左节点 分三种情况讨论:
     * 1.若p为叶子节点，直接删除
     * 2.若p有只有一个左孩子或者一个右孩子，则删除p，使PL或者PR为f的左子树
     * 3.若p的左右子树均不为空，由二叉排序树的特点可知在删除p前，中序遍历此二叉树
     * 可以得到一个有序序列，在删去p后为了保持其他元素的相对位置不变，可以这样做：
     * 令p的直接前驱(或直接后继)替代p，然后删除其直接前驱或直接后继。其直接前驱可由 中序遍历的特点获得
     */
    public boolean remove(Object o) {
        Entry[] p = new Entry[1];
        if (searchBST(o, p)) {
            deleteEntry(p[0]); // 查找成功，删除元素
            return true;
        }
        return false;
    }

    private void deleteEntry(Entry<E> p) {
        size--;
        if (p.left != null && p.right != null) { // 如果p左右子树都不为空，找到其直接后继，替换p
            Entry<E> s = successor(p);
            p.element = s.element;
            p = s;
        }
        Entry<E> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) { // 如果其左右子树有其一不为空
            replacement.parent = p.parent;
            if (p.parent == null) // 如果p为root节点
                root = replacement;
            else if (p == p.parent.left) // 如果p是左孩子
                p.parent.left = replacement;
            else
                p.parent.right = replacement; // 如果p是右孩子

            p.left = p.right = p.parent = null; // p的指针清空

        } else if (p.parent == null) { // 如果全树只有一个节点
            root = null;
        } else { // 左右子树都为空,p为叶子节点
            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }

    }

    /**
     * 返回以中序遍历方式遍历树时，t的直接后继
     */
    static <E> Entry<E> successor(Entry<E> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry<E> p = t.right; // 往右，然后向左直到尽头
            while (p.left != null)
                p = p.left;
            return p;
        } else { // right为空，如果t是p的左子树，则p为t的直接后继
            Entry<E> p = t.parent;
            Entry<E> ch = t;
            while (p != null && ch == p.right) {
                ch = p; // 如果t是p的右子树，则继续向上搜索其直接后继
                p = p.parent;
            }
            return p;
        }
    }

    public Iterator<E> itrator() {
        return new BinarySortIterator();
    }

    /**
     * 返回中序遍历此树的迭代器
     */
    private class BinarySortIterator implements Iterator<E> {
        Entry<E> next;
        Entry<E> lastReturned;

        public BinarySortIterator() {
            Entry<E> s = root;
            if (s != null) {
                while (s.left != null) {
                    s = s.left; // 找到中序遍历的第一个元素
                }
            }
            next = s; // 赋给next
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            Entry<E> e = next;
            if (e == null)
                throw new NoSuchElementException();
            next = successor(e);
            lastReturned = e;
            return e.element;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            // deleted entries are replaced by their successors
            if (lastReturned.left != null && lastReturned.right != null)
                next = lastReturned;
            deleteEntry(lastReturned);
            lastReturned = null;
        }
    }

    /**
     * 树节点，为方便起见不写get，set方法
     */
    static class Entry<E> {
        E element;
        Entry<E> parent;
        Entry<E> left;
        Entry<E> right;

        public Entry(E element, Entry<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public Entry() {
        }
    }

    // just for test
    public static void main(String[] args) {
        BinarySortTree<Integer> tree = new BinarySortTree<Integer>();
        tree.add(45);
        tree.add(24);
        tree.add(53);
        tree.add(45);
        tree.add(12);
        tree.add(90);

        System.out.println(tree.remove(400));
        System.out.println(tree.remove(45));
        System.out.println("root=" + tree.getRoot());
        Iterator<Integer> it = tree.itrator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(tree.size());
    }

}