package com.ee.leetcode;

/**
 * 翻转链表
 * @author Administrator
 *
 */
public class Exercise15 {
    private static class Node {
        public int val;
        public Node nextNode;

        public Node(int val, Node nextNode) {
            this.val = val;
            this.nextNode = nextNode;
        }
    }

    public static Node reverse(Node node) {
        return reverse(null, node);
    }


    public static Node reverse(Node node, Node nextNode) {
        Node nextNextNode = nextNode.nextNode;
        nextNode.nextNode = node;
        if (nextNextNode == null) {
            return nextNode;
        } else {
            return reverse(nextNode, nextNextNode);
        }
    }

//    public static Node reverse(Node node) {
//        Node lastNode = null;
//        while (node != null) {
//            Node nextNode = node.nextNode;
//            node.nextNode = lastNode;
//            lastNode = node;
//            node = nextNode;
//        }
//
//        return lastNode;
//    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node newNode = reverse(node1);
        for (Node n = newNode; n != null; n = n.nextNode) {
            System.out.println(n.val);
        }
    }
}
