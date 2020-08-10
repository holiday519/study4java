package com.ee.leetcode;

/**
 * 合并两个有序链表
 * 1->2->4, 1->3->4
 * 1->1->2->3->4->4
 * @author Administrator
 *
 */
public class Exercise17 {
	
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		ListNode c = mergeTwoLists(a1, b1);
		while (c != null) {
			System.out.println(c.val);
			c = c.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
//	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if (l1 == null) {
//			return l2;
//		}
//		if (l2 == null) {
//			return l1;
//		}
//		
//		// 判断2个链表第一个node的大小
//		int firstV1 = l1.val;
//		int firstV2 = l2.val;
//		
//		ListNode lessNode = null;
//		ListNode greaterNode = null;
//		ListNode resNode = null;
//		if (firstV1 < firstV2) {
//			resNode = lessNode = l1;
//			greaterNode = l2;
//		} else {
//			resNode = lessNode = l2;
//			greaterNode = l1;
//		}
//		
//		ListNode lastLessNode = null;
//		while (lessNode != null) {
//			if (lessNode.val > greaterNode.val) {
//				lastLessNode.next = greaterNode;
//				break;
//			} else {
//				lastLessNode = lessNode;
//				lessNode = lessNode.next;
//			}
//		}
//		
//		if (lessNode == null) {
//			lastLessNode.next = greaterNode;
//		} else {
//			greaterNode.next = mergeTwoLists(lessNode, greaterNode.next);
//		}
//		
//		return resNode;
//	}
	
}
