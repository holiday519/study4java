package com.ee.exercises.tree;

public class BST<Key extends  Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        private int H;

        public Node(Key key, Value val, int N, int H) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.H = H;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public int height() {
        return height(root);
    }

    public int height(Node x) {
        if (x == null) return 0;
        else return x.H;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        x.H = height(x.left) > height(x.right) ? height(x.left)+1 : height(x.right)+1;
        return x;
    }

//    public int height() {
//        return height(root);
//    }
//
//    private int height(Node x) {
//        if (x == null) return 0;
//        int leftHeight = height(x.left);
//        int rightHeight = height(x.right);
//        if (leftHeight >= rightHeight) {
//            return leftHeight + 1;
//        } else {
//            return rightHeight + 1;
//        }
//    }

    public static void main(String[] args) {
        BST<Integer, String> demo = new BST<>();
        demo.put(3,"a");
        demo.put(5,"b");
        demo.put(6,"c");
        demo.put(1,"d");
        demo.put(7,"e");
        demo.put(2,"f");

        System.out.println(demo.height());
        System.out.println(demo.size());
    }

}
