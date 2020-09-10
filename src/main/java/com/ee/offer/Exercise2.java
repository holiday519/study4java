package com.ee.offer;

/**
 * 二叉树的下一个结点
 * @author Administrator
 *
 */
public class Exercise2 {
	
	private static class TreeLinkNode {
		private int val;
		private TreeLinkNode next;
		private TreeLinkNode left;
		private TreeLinkNode right;
		public TreeLinkNode(int x) {
			val = x;
		}
	}
	
	private static TreeLinkNode findNextNode(TreeLinkNode pNode) {
		TreeLinkNode targetNode = null;
		
		if (pNode.right != null) {
			targetNode = pNode.right;
			while (targetNode.left != null) {
				targetNode = targetNode.left;
			}
		} else {
			while (pNode.next != null) {
				TreeLinkNode parentNode = pNode.next;
				if (pNode == parentNode.left) {
					targetNode = parentNode;
					break;
				}
				pNode = parentNode;
			}
		}
		
		return targetNode;
	}
	
	public static void main(String[] args) {
		
	}
}
