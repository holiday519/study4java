package com.ee.algorithm.tree;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public static class Node<Key, Value> {
        public Key key;
        public Value value;
        public Node<Key, Value> left, right;
        public int N;
        public boolean color;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color = RED;
    }
}
