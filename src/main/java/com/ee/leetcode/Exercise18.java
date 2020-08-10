package com.ee.leetcode;

/**
 * 从有序链表中删除重复节点
 * 1->1->2->3->3
 * @author Administrator
 *
 */
public class Exercise18 {
	
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode n = deleteDuplicates(n1);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode thisNode = head;
		ListNode lastNode = null;
		while (thisNode != null) {
			ListNode nextNode = thisNode.next;
			if (lastNode != null && lastNode.val == thisNode.val) {
				lastNode.next = nextNode;
			} else {
				lastNode = thisNode;
			}
			thisNode = nextNode;
		}
		
		return head;
	}
}
