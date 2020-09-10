package com.ee.leetcode;

/**
 * 翻转二叉树
 * @author Administrator
 *
 */
public class Exercise25 {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    
    private static void preOrder(TreeNode n) {
	    if (n != null) {
	        System.out.println(n.val);
	        preOrder(n.left);
	        preOrder(n.right);
	    }
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        
        preOrder(t1);
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root != null) {
			root.left = invertTree(root.right);
			root.right = invertTree(root.left);
		}
		return root;
	}
}
