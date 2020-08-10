package com.ee.leetcode;

/**
 * 删除链表的倒数第 n 个节点
 * @author Administrator
 *
 */
public class Exercise19 {
	
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
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode n = removeNthFromEnd(n1, 2);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	/**
	 * 缓存当前节点前的第n+1个节点
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preNode = head, postNode = head;
		int count = 0;
		while (preNode != null) {
			count ++;
			preNode = preNode.next;
			if (count > n + 1) {
				postNode = postNode.next;
			}
		}
		
		if (postNode == null || postNode.next == null) {
			return head;
		} else {
			postNode.next = postNode.next.next;
			return head;
		}
	}
}
