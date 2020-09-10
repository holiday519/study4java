package com.ee.offer;

/**
 * 二叉树的镜像
 * @author Administrator
 *
 */
public class Exercise15 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}

	public static void main(String[] args) {
		
	}
	
	public static void mirror(TreeNode root) {
		if (root != null) {
			TreeNode tmpNode = root.left;
			root.left = root.right;
			root.right = tmpNode;
			mirror(root.left);
			mirror(root.right);
		}
	}
}
