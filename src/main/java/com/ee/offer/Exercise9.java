package com.ee.offer;

/**
 * 在 O(1) 时间内删除链表节点
 * @author Administrator
 *
 */
public class Exercise9 {

	private static class Node {
        public int val;
        public Node nextNode;

        public Node(int val, Node nextNode) {
            this.val = val;
            this.nextNode = nextNode;
        }
    }
	
	public static void main(String[] args) {
		Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        
        Node newNode = deleteNode(node1, node5);
        for (Node n = newNode; n != null; n = n.nextNode) {
            System.out.println(n.val);
        }
	}
	
	public static Node deleteNode(Node head, Node delNode) {
		Node delNextNode = delNode.nextNode;
		if (delNextNode != null) {
			delNode.val = delNextNode.val;
			delNode.nextNode = delNextNode.nextNode;
		} else {
			Node thisNode = head;
			Node lastNode = null;
			while (thisNode.nextNode != null) {
				lastNode = thisNode;
				thisNode = thisNode.nextNode;
			}
			if (lastNode == null) {
				head = null;
			} else {
				lastNode.nextNode = null;
			}
		}
		
		return head;
	}
}
