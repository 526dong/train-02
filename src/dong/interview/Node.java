package dong.interview;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description
 */
public class Node {
    int val;
    Node next;
    Node left;
    Node right;

    public Node() {}

    public Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
