package com.ee.leetcode;

/**
 * 相交链表
 * @author Administrator
 *
 */
public class Exercise16 {
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode node0 = new ListNode(0);
		ListNode node9 = new ListNode(9);
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		
		node0.next = node9;
		node9.next = node1;
		node1.next = node2;
		
		node3.next = node2;
		
		node2.next = node4;
		
		ListNode n = getIntersectionNode(node0, node3);
		System.out.println(n.val);
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ta = headA, tb = headB;
		while (ta != tb) {
			ta = (ta == null) ? headB : ta.next;
			tb = (tb == null) ? headA : tb.next;
		}
		
		return ta;
	}
	
//	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		if (headA == null || headB == null) {
//			return null;
//		}
//		
//		ListNode nodeA = headA;
//		ListNode nodeB = headB;
//		ListNode result = null;
//		ListNode tailA = null;
//		ListNode tailB = null;
//		
//		while (true) {
//			if (nodeA == nodeB) {
//				result = nodeA;
//				break;
//			}
//			// node1走一步
//			ListNode nextA = nodeA.next;
//			if (nextA == null) {
//				tailA = nodeA;
//				nodeA = headA;
//			} else {
//				nodeA = nextA;
//			}
//			
//			// node2走一步
//			ListNode nextB = nodeB.next;
//			if (nextB == null) {
//				tailB = nodeB;
//				nodeB = headB;
//			} else {
//				nodeB = nextB;
//			}
//			
//			if (tailA != null && tailB != null && tailA != tailB) {
//				break;
//			}
//		}
//		
//		return result;
//	}
	
}
