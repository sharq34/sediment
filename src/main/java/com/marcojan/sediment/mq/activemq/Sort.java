package com.marcojan.sediment.mq.activemq;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort {

    public static void main(String[] args) {
        //二叉树广度遍历




    }

    private void sort(Node node){
        Queue<Node> q = new LinkedBlockingQueue<Node>();

        AtomicInteger i = new AtomicInteger(0);
        i.getAndIncrement();
        String[] args ={};

        q.offer(node);
        while(!q.isEmpty()){
            Node current = q.poll();

            System.out.println(current.value);
            if(current.left!=null){
                q.offer(current.left);
            }
            if(current.right!=null){
                q.offer(current.right);
            }
        }

    }

    class Node{
        long value;
        Node left;
        Node right;
    }
}
