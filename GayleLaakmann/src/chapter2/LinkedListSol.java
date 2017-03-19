package chapter2;

import java.util.Hashtable;


// implements the solution 
public class LinkedListSol {
	private Node head;
	private int size;
	
	private class Node {
		int data;
		Node next;
		
		public Node(int n) {
			this.data = n;
			this.next = null;
		}
	}
	
	public int getListLength() {
		return this.size;
	}
	
	public LinkedListSol() {
		head = null;
		size = 0;
	}
	
	// adds an item to the tail of the list
	public void addToList(int n) {
		if (head == null) {
			head = new Node(n);
		} else {
			Node currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = new Node(n);
		}
		size++;
	}
	
	// prints the current list
	public void  printList() {
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + ",");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	// question 1
	// remove duplicates method 1 
	public void removeDups() {
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		Node previous = null;
		Node current = head;
		while (current != null) {
			if (table.containsKey(current.data)) {
				previous.next = current.next;
			} else {
				table.put(current.data, true);
				previous = current;
			}
			current = current.next;
		}
	}
	
	// question 1 - runner method
	public void removeDupsRunner() {
		if (head == null) {
			return;
		}
		Node curNode = head;
		while (curNode != null) {
			Node runner = curNode;
			while (runner.next != null) {
				if (runner.next.data == curNode.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curNode = curNode.next;
		}
	}
	
	// question 2 - kth last element from end
	public int findKthNodefromLast(int k) {
		if (k <=0) { 
			return 	-99;
		}
		Node curNode = head;
		Node runner = curNode;
		for (int i = 0; i < k-1; i++) {
			runner = runner.next;
		}
		if (runner == null) {
			return -99;
		}
		while (runner.next != null) {
			curNode = curNode.next;
			runner = runner.next;
		}
		return curNode.data;
	}
	
	// helper function for question 3
	// get kth node from head
	private Node getRandomNode(int k) {
		if (k <=0 || k > this.size) {
			return null;
		}
		Node curNode = head;
		for (int i = 0; i < k-1; i++) {
			curNode = curNode.next;
		}
		if (curNode != null) {
			return curNode;
		}
		return null;
	}
	
	// question 3 - delete a node given access to that node only
	public void deleteSomeNode(int n) {
		Node nodetoDelete = this.getRandomNode(n);
		if (nodetoDelete == null || nodetoDelete.next == null) { 
			System.out.println("Cannot delete");
			return;
		}
		Node next = nodetoDelete.next;
		nodetoDelete.data = next.data;
		nodetoDelete.next = next.next;
		if (n==1) {
			this.head = next;
		}
		System.out.println(n +"th node deleted");
		return;
	}
	
}
