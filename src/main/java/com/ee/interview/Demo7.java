package com.ee.interview;

import java.util.Arrays;

public class Demo7 {

    public static class TreeNode {
        public int value;
        public TreeNode liftNode;
        public TreeNode rightNode;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode node = getRootNode(preOrder, inOrder);

        System.out.println(node.rightNode.liftNode.value);
    }

    private static TreeNode getRootNode(int[] preOrder, int[] inOrder) {
        int preLen = preOrder.length;
        int inLen = inOrder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Error");
        }

        if (preLen == 0) {
            return null;
        }

        TreeNode node = new TreeNode();
        int root = preOrder[0];
        node.value = root;

        int idx = indexOfArray(inOrder, root);

        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, idx+1);
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, idx);
        node.liftNode = getRootNode(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preOrder, idx+1, preLen);
        int[] rightInOrder = Arrays.copyOfRange(inOrder, idx+1, preLen);
        node.rightNode = getRootNode(rightPreOrder, rightInOrder);

        return node;
    }

    private static int indexOfArray(int[] array, int e) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }
}
