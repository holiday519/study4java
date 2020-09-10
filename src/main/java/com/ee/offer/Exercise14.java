package com.ee.offer;

/**
 * 树的子结构
 * @author Administrator
 *
 */
public class Exercise14 {
	
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
	
	public static boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
	}
	
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		return isSubtreeWithRoot(root1, root2) || isSubtreeWithRoot(root1.left, root2) || isSubtreeWithRoot(root1.right, root2);
	}
}
