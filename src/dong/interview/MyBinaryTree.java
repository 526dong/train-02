package dong.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description
 */
public class MyBinaryTree {
    /**
     * ���ڵ�
     */
    private Node root;

    public MyBinaryTree(){
        //��ʼ�����ڵ�Ϊnull
        this.root = null;
    }

    public void createTree(Node node, int data){
        //�жϵ�ǰ�ڵ�λ��
        if (root == null) {
            //�����ڵ�Ϊ��ʱ
            root = new Node(data);
        } else {
            if (data < node.data) {
                //��ڵ�
                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    createTree(node.left, data);
                }
            } else {
                //�ҽڵ�
                if (node.right == null) {
                    node.right = new Node(data);
                } else {
                    createTree(node.right, data);
                }
            }
        }
    }

    /**
     * ǰ�����-�ݹ�
     * @param node
     */
    public void prevTree(Node node){
        if (node != null) {
            System.out.print("["+node.data+"]");
            prevTree(node.left);
            prevTree(node.right);
        }
    }

    /**
     * �������-�ݹ�
     * @param node
     */
    public void middleTree(Node node){
        if (node != null) {
            middleTree(node.left);
            System.out.print("["+node.data+"]");
            middleTree(node.right);
        }
    }

    /**
     * �������-�ݹ�
     * @param node
     */
    public void nextTree(Node node){
        if (node != null) {
            nextTree(node.left);
            nextTree(node.right);
            System.out.print("["+node.data+"]");
        }
    }

    /**
     * ǰ�����-�ǵݹ�
     */
    public void prevLoopTree(Node node){
        Stack<Node> stack = new Stack<Node>();
        if (node != null) {
            // Ԫ�ؽ�ջ
            stack.push(node);
            while (!stack.isEmpty()) {
                // ջ��Ԫ�س�ջ
                node = stack.pop();
                System.out.print(" " + node.data + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * �������-�ǵݹ�
     * @param node
     */
    public void middleLoopTree(Node node){
        Stack<Node> stack = new Stack<Node>();
        while ((node != null) || (!stack.isEmpty())) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(" " + node.data + " ");
                node = node.right;
            }
        }
    }

    /**
     * �������-�ǵݹ�
     * @param node
     */
    public void nextLoopTree(Node node){
        Stack<Node> stack = new Stack<Node>();
        Node preNode = null;
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.peek();
                if ((node.left == null && preNode.right == null)
                        || (preNode != null && (preNode == node.left || preNode == node.right))) {
                    System.out.print(" " + node.data + " ");
                    stack.pop();
                    preNode = node;
                } else {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null){
                        stack.push(node.left);
                    }
                }
            }
        }
    }

    /**
     * ���ö���ʵ�ֲ������
     * @param node
     */
    public void levelTree(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        if (node != null) {
            queue.offer(node); // ��Ԫ�ز������
            while (!queue.isEmpty()) {
                node = queue.poll(); // ����ͷ������
                System.out.print(" " + node.data + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 4, 8, 1, 7, 3, 9, 2, 5 };
        //1������һ��������
        MyBinaryTree bTree = new MyBinaryTree();
        for (int i = 0; i < arr.length; i++) {
            bTree.createTree(bTree.root, arr[i]);
        }
        System.out.println(bTree);
        //2������������
        //�ݹ�
        /*System.out.println("������ǰ�����");
        bTree.prevTree(bTree.root);
        System.out.println("�������������");
        bTree.middleTree(bTree.root);
        System.out.println("�������������");
        bTree.nextTree(bTree.root);*/
        //�ǵݹ�
//        bTree.prevLoopTree(bTree.root);
        bTree.middleLoopTree(bTree.root);
        bTree.nextLoopTree(bTree.root);
        bTree.levelTree(bTree.root);
    }

    /**
     * ��һ���ڵ��ڲ���
     * ���洢�������Ľڵ������ָ��
     */
    static class Node {
        Node left;
        Node right;
        int data;
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
