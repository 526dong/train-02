package dong.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Created by ${xzd} on 2018/1/16.
 * @Description 二叉树遍历
 * 如何生成二叉树
 * 如何遍历二叉树
 * 用什么思想/算法来实现
 */
public class LinkedBinaryTree {
    private Node root; // 根节点

    /**
     * 内部节点类
     */
    private class Node {
        private Node leftChild; // 左子节点
        private Node rightChild; // 右子节点
        private int data;

        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }
    }

    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * 递归创建二叉树
     *
     * @param node
     * @param data
     */
    public void buildTree(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < node.data) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(data);
                } else {
                    buildTree(node.leftChild, data); // 递归遍历左子树
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node(data);
                } else {
                    buildTree(node.rightChild, data); // 递归遍历右子树
                }
            }
        }
    }

    /**
     * 前序遍历（递归实现）
     *
     * @param node
     */
    public void preOrderTraverse(Node node) {
        if (node != null) {
            System.out.print(" " + node.data + " ");
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }
    }

    /**
     * 中序遍历（递归实现）
     *
     * @param node
     */
    public void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.leftChild);
            System.out.print(" " + node.data + " ");
            inOrderTraverse(node.rightChild);
        }
    }

    /**
     * 后序遍历（递归实现）
     *
     * @param node
     */
    public void postOrderTraverse(Node node) {
        if (node != null) {
            postOrderTraverse(node.leftChild);
            postOrderTraverse(node.rightChild);
            System.out.print(" " + node.data + " ");
        }
    }

    /**
     * 前序遍历（非递归实现）
     *
     * @param node
     */
    public void preOrderTraverseNoRecursion(Node node) {
        Stack<Node> stack = new Stack<Node>();
        if (node != null) {
            stack.push(node); // 元素进栈
            while (!stack.isEmpty()) {
                node = stack.pop(); // 栈顶元素出栈
                System.out.print(" " + node.data + " ");
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }
                if (node.leftChild != null) {
                    stack.push(node.leftChild);
                }
            }
        }
    }

    /**
     * 中序遍历（非递归实现）
     *
     * @param node
     */
    public void inOrderTraverseNoRecursion(Node node) {
        Stack<Node> stack = new Stack<Node>();
        while ((node != null) || (!stack.isEmpty())) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                node = stack.pop();
                System.out.print(" " + node.data + " ");
                node = node.rightChild;
            }
        }
    }


    public void after(Node node){
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.peek();
                if ((node.leftChild == null && node.rightChild == null) ||
                        (prev != null && (prev == node.leftChild || prev == node.rightChild))) {
                    System.out.println(node.data);
                    stack.pop();
                    prev = node;
                } else {
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    if (node.leftChild != null){
                        stack.push(node.leftChild);
                    }
                }
            }
        }
    }

    /**
     * 后序遍历（非递归实现）
     *
     * @param node
     */
    public void postOrderTraverseNoRecursion(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Node preNode = null;
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.peek();
                if ((node.leftChild == null && node.rightChild == null)
                        || (preNode != null && (preNode == node.leftChild || preNode == node.rightChild))) {
                    System.out.print(" " + node.data + " ");
                    stack.pop();
                    preNode = node;
                } else {
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    if (node.leftChild != null){
                        stack.push(node.leftChild);
                    }
                }
            }
        }
    }

    /**
     * 层序遍历（非递归实现）
     *
     * @param node
     */
    public void levelOrderTraverse(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        if (node != null) {
            queue.offer(node); // 将元素插入队列
            while (!queue.isEmpty()) {
                node = queue.poll(); // 队列头部出列
                System.out.print(" " + node.data + " ");
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
            }
        }
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = { 6, 4, 8, 1, 7, 3, 9, 2, 5 };
        LinkedBinaryTree bTree = new LinkedBinaryTree();

        // 构建一棵二叉树
        for (int i = 0; i < arr.length; i++) {
            bTree.buildTree(bTree.root, arr[i]);
        }
        System.out.println(bTree);
        /*bTree.preOrderTraverse(bTree.root); // 前序遍历（递归）
        bTree.inOrderTraverse(bTree.root); // 中序遍历（递归）
        bTree.postOrderTraverse(bTree.root); // 后序遍历（递归）*/
        //bTree.preOrderTraverseNoRecursion(bTree.root); // 前序遍历（非递归）
        //bTree.inOrderTraverseNoRecursion(bTree.root); // 中序遍历（非递归）
           bTree.postOrderTraverseNoRecursion(bTree.root); // 后序遍历（非递归）
        //bTree.levelOrderTraverse(bTree.root); // 层序遍历（非递归）
    }

}