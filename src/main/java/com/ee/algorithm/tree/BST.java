package com.ee.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST<Key extends Comparable<Key>, Value> {

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

    // 前序遍历(递归)
//    public void preOrder(Node n) {
//        if (n != null) {
//            System.out.println(n.val);
//            preOrder(n.left);
//            preOrder(n.right);
//        }
//    }
    // 前序遍历(非递归)
    public void preOrder(Node n) {
        if (n != null) {
            Deque<Node> stack = new ArrayDeque<Node>();
            stack.addFirst(n);
            while (!stack.isEmpty()) {
                Node root = stack.removeFirst();
                System.out.println(root.val);
                Node left = root.left;
                Node right = root.right;
                if (right != null) stack.addFirst(right);
                if (left != null) stack.addFirst(left);
            }
        }
    }

    // 中序遍历(递归)
//    public void inOrder(Node n) {
//        if (n != null) {
//            inOrder(n.left);
//            System.out.println(n.val);
//            inOrder(n.right);
//        }
//    }
    // 中序遍历(非递归)
    public void inOrder(Node n) {
        if (n != null) {
            Deque<Node> stack = new ArrayDeque<Node>();
            while (n != null || !stack.isEmpty()) {
                if (n != null) {
                    stack.addFirst(n);
                    n = n.left;
                } else {
                    n = stack.removeFirst();
                    System.out.println(n.val);
                    n = n.right;
                }
            }
        }
    }

    // 后序遍历(递归)
//    public void postOrder(Node n) {
//        if (n != null) {
//            postOrder(n.left);
//            postOrder(n.right);
//            System.out.println(n.val);
//        }
//    }
    // 后序遍历(非递归)
    public void postOrder(Node n) {
        if (n != null) {
            Deque<Node> stack = new ArrayDeque<Node>();
            stack.addFirst(n);
            while (!stack.isEmpty()) {
                Node t = stack.getFirst();
                Node left = t.left;
                Node right = t.right;
                if (left != null && n != t.left && n != t.right) {
                    stack.addFirst(left);
                } else if (right != null && n != t.right) {
                    stack.addFirst(right);
                } else {
                    n = stack.removeFirst();
                    System.out.println(n.val);
                }
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer, String> demo = new BST<>();
        demo.put(3,"a");
        demo.put(5,"b");
        demo.put(6,"c");
        demo.put(1,"d");
        demo.put(7,"e");
        demo.put(2,"f");

//        System.out.println(demo.height());
//        System.out.println(demo.size());
        demo.postOrder(demo.root);
    }

}
