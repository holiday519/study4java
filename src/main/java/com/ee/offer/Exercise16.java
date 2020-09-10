package com.ee.offer;

/**
 * 对称的二叉树
 * @author Administrator
 *
 */
public class Exercise16 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}

	public static void main(String[] args) {
		TreeNode n = new TreeNode(8);
		TreeNode l = new TreeNode(6);
		TreeNode r = new TreeNode(6);
		TreeNode ll = new TreeNode(5);
		TreeNode lr = new TreeNode(5);
	}
	
	public static boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) return true;
		return isSymmetrical(pRoot.left, pRoot.right);
	}
	
	public static boolean isSymmetrical(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
		} else {
			return false;
		}
	}
}
