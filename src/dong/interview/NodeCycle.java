package dong.interview;

import dong.interview.Node;

import java.util.HashMap;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description 单链表判断是否存在环
 */
public class NodeCycle {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;

        System.out.println(hasLoop(n1));
        System.out.println(judgeLinkedList(n1));
    }

    /**
     * 两个指针同时遍历，如果有环，他们会相遇
     * @param node
     * @return
     */
    public static boolean hasLoop(Node node){
        //定义两个指针tmp1,tmp2
        Node tmp1 = node;
        Node tmp2 = node.next;

        //头节点为空
        if (tmp1 == null) {
            return false;
        }

        while(tmp2 != null){
            int d1 = tmp1.val;
            int d2 = tmp2.val;

            //当两个指针重逢时，说明存在环，否则不存在。
            if(d1 == d2) {
                return true;
            }

            //每次迭代时，指针1走一步，指针2走两步
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;

            //不存在环时，退出
            if(tmp2 == null) {
                return false;
            }
        }

        //如果tmp2为null，说明元素只有一个，也可以说明是存在环
        return true;
    }

    /**
     * 判断单链表是否有环，传入参数头节点 //方法2：将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环
     * @param node head node
     * @return true 有环 false 无环
     */
    public static boolean judgeLinkedList(Node node){
        if (node == null) {
            return false;
        } else {
            Node temp = node;

            HashMap<Node, Integer> hashMap = new HashMap<>();

            while (temp != null) {
                if (hashMap.get(temp) != null) {
                    return true;
                } else {
                    hashMap.put(temp, 1);
                }

                temp = temp.next;

                if (temp == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
