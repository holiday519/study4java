package com.ee.offer;

/**
 * 链表中倒数第 K 个结点
 * @author Administrator
 *
 */
public class Exercise12 {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;
	    ListNode(int val) {
	        this.val = val;
	    }
		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
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
		
		ListNode n = findKthToTail(n1, 0);
		System.out.println(n);
	}
	
	public static ListNode findKthToTail(ListNode head, int k) {
		if (k <= 0) {
			return null;
		}
		
		ListNode preNode = head;
		ListNode postNode = null;
		int c = 0;
		
		while (preNode != null) {
			c ++;
			preNode = preNode.next;
			if (c == k) {
				postNode = head;
			}
			if (c > k) {
				postNode = postNode.next;
			}
		}
		
		return postNode;
	}
}
