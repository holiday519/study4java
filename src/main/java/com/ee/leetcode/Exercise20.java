package com.ee.leetcode;

/**
 * 两两交换链表中的节点
 * @author Administrator
 *
 */
public class Exercise20 {
	
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode n = swapPairs(n1);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	/**
	 * 步长2，窗口4
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode firstNode = null;
		ListNode secondNode = null;
		ListNode thirdNode = head;
		ListNode forthNode = thirdNode.next;
		// 窗口外的第一个node，可以是null
		ListNode fifthNode = forthNode.next;
		// 结果节点
		ListNode resNode = forthNode;
		
		while (forthNode != null) {
			// 移动
			firstNode = thirdNode;
			secondNode = forthNode;
			thirdNode = fifthNode;
			forthNode = thirdNode == null ? null : thirdNode.next;
			fifthNode = forthNode == null ? null : forthNode.next;
			// 处理前两个node
			secondNode.next = firstNode;
			firstNode.next = forthNode == null ? thirdNode : forthNode;
		}
		
		return resNode;
    }
}
