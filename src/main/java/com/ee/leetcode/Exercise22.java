package com.ee.leetcode;

/**
 * 平衡二叉树
 * @author Administrator
 *
 */
public class Exercise22 {
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		
	}
	
	public static boolean isBalanced(TreeNode root) {
		return isBalanced(root.left) && isBalanced(root.right);
    }
}
