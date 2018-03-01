package com.marcojan.sediment.common;

/**
 * 反转单向链表
 *
 * 老虎证券@20180226
 */
public class InvertLinkedList {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node node = invert(node1, null);
//        Node node = invert_X_recursion(node1);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

    }

    static Node invert(Node current, Node previous) {

        if (current == null) return previous;

        Node interim = current.next;
        current.next = previous;
        return invert(interim, current);

    }

    static Node invert_X_recursion(Node current) {

        Node previous = null;

        while (current != null) {
            Node interim = current.next;
            current.next = previous;
            previous = current;
            current = interim;
        }
        return previous;
    }


    static class Node {
        Integer value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
