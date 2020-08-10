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
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(99);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		t5.right = t6;
		
		System.out.println(isBalanced(t1));
	}
	
	/**
	 * 左右是平衡二叉树并且高度相差<=1
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		if (root == null) return true; 
		int diff = maxDepth(root.left) - maxDepth(root.right);
		return isBalanced(root.left) && isBalanced(root.right) && diff >= -1 && diff <= 1;
    }
	
	public static int maxDepth(TreeNode root) {
		if (root == null) return 0; 
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
	}
}
