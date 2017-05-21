package com.marcojan.sediment.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 相对数组和链表，查询和插入的效率相对平衡。
 * <p>
 * 1. 数组易查询，插入和删除效率低
 * 2. 链表易插入和删除，查询效率低
 * <p>
 * Created by Marco on 07/05/2017.
 */
public class Tree {

    private Node root;

    public void insert(long value) {

        Node newNode = new Node(value);
        Node parent;
        Node current = root;

        if (root == null) {

            root = newNode;
            return;

        } else {

            while (true) {

                parent = current;

                if (value < parent.value) {
                    current = parent.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = parent.rightChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public Node find(long value) {

        Node current = root;

        if (current.value == value) {
            return current;
        }

        while (true) {

            if(current == null)
                return null;

            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            }
        }

    }

    public void delete(long value) {

        List list =new ArrayList();
    }
}
