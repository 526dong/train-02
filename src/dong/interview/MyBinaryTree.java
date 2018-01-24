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
     * 根节点
     */
    private Node root;

    public MyBinaryTree(){
        //初始化根节点为null
        this.root = null;
    }

    public void createTree(Node node, int data){
        //判断当前节点位置
        if (root == null) {
            //当根节点为空时
            root = new Node(data);
        } else {
            if (data < node.data) {
                //左节点
                if (node.left == null) {
                    node.left = new Node(data);
                } else {
                    createTree(node.left, data);
                }
            } else {
                //右节点
                if (node.right == null) {
                    node.right = new Node(data);
                } else {
                    createTree(node.right, data);
                }
            }
        }
    }

    /**
     * 前序遍历-递归
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
     * 中序遍历-递归
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
     * 后序遍历-递归
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
     * 前序遍历-非递归
     */
    public void prevLoopTree(Node node){
        Stack<Node> stack = new Stack<Node>();
        if (node != null) {
            // 元素进栈
            stack.push(node);
            while (!stack.isEmpty()) {
                // 栈顶元素出栈
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
     * 中序遍历-非递归
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
     * 后序遍历-非递归
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
     * 利用队列实现层序遍历
     * @param node
     */
    public void levelTree(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        if (node != null) {
            queue.offer(node); // 将元素插入队列
            while (!queue.isEmpty()) {
                node = queue.poll(); // 队列头部出列
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
        //1、构建一个二叉树
        MyBinaryTree bTree = new MyBinaryTree();
        for (int i = 0; i < arr.length; i++) {
            bTree.createTree(bTree.root, arr[i]);
        }
        System.out.println(bTree);
        //2、二叉树遍历
        //递归
        /*System.out.println("二叉树前序遍历");
        bTree.prevTree(bTree.root);
        System.out.println("二叉树中序遍历");
        bTree.middleTree(bTree.root);
        System.out.println("二叉树后序遍历");
        bTree.nextTree(bTree.root);*/
        //非递归
//        bTree.prevLoopTree(bTree.root);
        bTree.middleLoopTree(bTree.root);
        bTree.nextLoopTree(bTree.root);
        bTree.levelTree(bTree.root);
    }

    /**
     * 搞一个节点内部类
     * 来存储二叉树的节点和左右指针
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
