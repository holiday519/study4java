package com.ee.offer;

/**
 * 链表中环的入口结点
 * @author Administrator
 *
 */
public class Exercise13 {
	
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
		n5.next = n2;
		
		System.out.println(entryNodeOfLoop(n1));
	}
	
	public static ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		
		ListNode oneNode = pHead.next;
		ListNode twoNode = pHead.next.next;
		while (oneNode != twoNode) {
			if (twoNode == null) break;
			twoNode = twoNode.next;
			if (twoNode == null) break;
			twoNode = twoNode.next;
			oneNode = oneNode.next;
		}
		
		if (twoNode == null) {
			return null;
		}
		
		ListNode testNode = twoNode;
		ListNode fastNode = pHead;
		ListNode slowNode = pHead;
		do {
			testNode = testNode.next;
			fastNode = fastNode.next;
		} while (testNode != twoNode);
		
		while (fastNode != slowNode) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		
		return fastNode;
    }
}
