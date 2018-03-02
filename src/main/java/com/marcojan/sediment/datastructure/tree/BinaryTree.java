package com.marcojan.sediment.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相对数组和链表，查询和插入的效率相对平衡。
 * <p>
 * 1. 数组易查询，插入和删除效率低
 * 2. 链表易插入和删除，查询效率低
 * <p>
 * <p>
 * 二叉树的深度优先遍历的非递归的通用做法是采用栈，广度优先遍历的非递归的通用做法是采用队列。
 * <p>
 * 深度优先遍历：对每一个可能的分支路径深入到不能再深入为止，而且每个结点只能访问一次。要特别注意的是，二叉树的深度优先遍历比较特殊，可以细分为先序遍历、中序遍历、后序遍历。
 * <p>
 * 先序遍历：对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树。
 * 中序遍历：对任一子树，先遍历其左子树，然后访问根，最后遍历其右子树。(从小到大排序)
 * 后序遍历：对任一子树，先遍历其左子树，然后遍历其右子树，最后访问根。
 * <p>
 * 广度优先遍历：又叫层次遍历，从上往下对每一层依次访问，在每一层中，从左往右（也可以从右往左）访问结点，访问完一层就进入下一层，直到没有结点可以访问为止。
 * <p>
 * Created by Marco on 07/05/2017.
 */
public class BinaryTree {

    class Node {
        public long value;
        public Node leftChild;
        public Node rightChild;

        public Node(long value) {
            this.value = value;
        }
    }

    Node root;

    void insert(long value) {

        Node current;
        Node newNode = new Node(value);
        current = root;
        Node parent;

        if (root == null) {

            root = newNode;
            return;

        } else {

            while (true) {

                if (value < current.value) {

                    parent = current;
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    parent = current;
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    Node find(long value) {

        Node current = root;

        while (current != null) {
            if (value == current.value)
                return current;

            if (value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return null;
    }

    void delete(long value) {

    }

    /**
     * 广度遍历，利用到队列 FIFO 的特性
     * @param node
     */
    void breadth_print(Node node) {

        Queue<Node> queue = new LinkedList();

        queue.offer(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            System.out.println(current.value);

            if (current.leftChild != null)
                queue.offer(current.leftChild);
            if (current.rightChild != null)
                queue.offer(current.rightChild);
        }
    }

    void pre_print(Node node) {

        if (node != null) {
            System.out.print(node.value + ", ");
            pre_print(node.leftChild);
            pre_print(node.rightChild);
        }
    }

    // 中序遍历 = 从大到小排序
    void mid_print(Node node) {
        if (node != null) {
            mid_print(node.leftChild);
            System.out.print(node.value + ", ");
            mid_print(node.rightChild);
        }
    }

    void post_print(Node node) {
        if (node != null) {
            System.out.print(node.value + ", ");
            post_print(node.rightChild);
            post_print(node.leftChild);
        }
    }

    //非递归
    void post_print_X_recursion(Node node) {

    }

    //非递归
    void pre_print_X_recursion(Node node) {

    }

    //非递归
    void mid_print_X_recursion(Node node) {

    }

    int height(Node node) {

        if (node != null) {

            int left, right;

            left = height(node.leftChild);
            right = height(node.rightChild);

            return (left > right ? left : right) + 1;
        }

        return 0;
    }

    //节点个数
    int count_nodes(Node node) {

        if (node != null) {
            return (count_nodes(node.leftChild) + count_nodes(node.rightChild) + 1);
        }
        return 0;
    }

    //叶子节点个数
    int count_child_nodes(Node node) {
        if (node == null)
            return 0;

        if (node.leftChild == null && node.rightChild == null)
            return 1;

        return count_child_nodes(node.leftChild) + count_child_nodes(node.rightChild);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // /root
        binaryTree.insert(10);

        binaryTree.insert(7);

        binaryTree.insert(11);


        binaryTree.insert(8);
        binaryTree.insert(12);

        binaryTree.insert(9);
        binaryTree.insert(13);

        binaryTree.insert(6);
        binaryTree.insert(5);

        binaryTree.insert(14);
        binaryTree.insert(15);


        System.out.println("\n-----前序-----");
        binaryTree.pre_print(binaryTree.root);

        System.out.println("\n-----后序-----");
        binaryTree.post_print(binaryTree.root);

        System.out.println("\n-----中序-----");
        binaryTree.mid_print(binaryTree.root);

        System.out.println("\n-----水平-----");
        binaryTree.breadth_print(binaryTree.root);

        System.out.println("\n-----节点数-----");
        System.out.println(binaryTree.count_nodes(binaryTree.root));

        System.out.println("\n-----叶子节点数-----");
        System.out.println(binaryTree.count_child_nodes(binaryTree.root));

        System.out.println("\n-----高度-----");
        System.out.println(binaryTree.height(binaryTree.root));
    }
}
