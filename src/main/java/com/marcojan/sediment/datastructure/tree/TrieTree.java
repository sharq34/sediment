package com.marcojan.sediment.datastructure.tree;

import java.util.List;

public class TrieTree {

    class Node {

        String v;
        int count;
        List<Node> childNodes;

        Node(String v){
            this.v = v;
            count = 0;
            childNodes = null;
        }
    }

}