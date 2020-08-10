package com.ee.leetcode;

/**
 * 二叉树的最大深度
 * @author Administrator
 *
 */
public class Exercise21 {
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		
		System.out.println(maxDepth(t1));
	}
	
	
	public static int maxDepth(TreeNode root) {
		if (root == null) return 0; 
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
	}
	
}
