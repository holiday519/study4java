package com.ee.leetcode;

/**
 * 路径总和
 * @author Administrator
 *
 */
public class Exercise27 {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
	
	public static void main(String[] args) {
//		TreeNode t1 = new TreeNode(5);
//        TreeNode t2 = new TreeNode(4);
//        TreeNode t3 = new TreeNode(8);
//        TreeNode t4 = new TreeNode(11);
//        TreeNode t5 = new TreeNode(13);
//        TreeNode t6 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(2);
//        TreeNode t9 = new TreeNode(1);
//        
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t3.left = t5;
//        t3.right = t6;
//        t4.left = t7;
//        t4.right = t8;
//        t6.right = t9;
        
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		
        System.out.println(hasPathSum(t1, 1));
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		int val = root.val;
		if (val > sum) return false;
		else if (val == sum) return true;
		else return hasPathSum(root.left, sum - val) || hasPathSum(root.right, sum - val);
    }
}
