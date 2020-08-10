package com.ee.offer;

/**
 * 重建二叉树
 * @author Administrator
 *
 */
public class Exercise1 {
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		Node root = rebuildTree(pre, in);
		preOrder(root);
		System.out.println("==========");
		inOrder(root);
	}
	
	public static void preOrder(Node n) {
		if (n != null) {
			System.out.println(n.value);
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public static void inOrder(Node n) {
		if (n != null) {
			inOrder(n.left);
			System.out.println(n.value);
			inOrder(n.right);
		}
	}

	public static Node rebuildTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		
		Node root = new Node(pre[0]);
		int rootIdx = getIndex(in, pre[0]);
		int[] leftIn = copyArray(in, 0, rootIdx);
		int[] rightIn = copyArray(in, rootIdx+1, in.length-1-rootIdx);
		int[] leftPre = copyArray(pre, 1, leftIn.length);
		int[] rightPre = copyArray(pre, 1+leftPre.length, rightIn.length);
		
		root.left = rebuildTree(leftPre, leftIn);
		root.right = rebuildTree(rightPre, rightIn);
		
		return root;
	}
	
	private static int getIndex(int[] elems, int elem) {
		for (int i=0; i<elems.length; i++) {
			if (elems[i] == elem) return i;
		}
		return -1;
	}
	
	private static int[] copyArray(int[] source, int start, int length) {
		int[] target = new int[length];
		System.arraycopy(source, start, target, 0, length);
		return target;
	}
	
	private static class Node {
		private int value;
		private Node left;
		private Node right;
		public Node(int value) {
			this.value = value;
		}
	}
}
