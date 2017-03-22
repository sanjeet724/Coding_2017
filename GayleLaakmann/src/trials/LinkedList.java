package trials;

// My implementation (to understand the concepts)

import java.util.HashMap;

public class LinkedList {
	private Node head;
	private int numOfItems;
	private HashMap<Integer, Integer> countMap;
	private HashMap<Integer, Integer> duplicateMap;
	
	private class Node {
		int data;
		Node next;
		
		private Node (int n) {
			this.data = n;
			this.next = null;
		}
	}
	
	public HashMap<Integer, Integer> getCounMap() {
		return this.countMap;
	}
	
	public void getDuplicates() {
		if (this.duplicateMap.size() == 0) {
			System.out.println("No duplicates found");
			return;
		}
		System.out.println("# of Duplicates: " + this.duplicateMap.size());
		for (int key : this.duplicateMap.keySet()){
			System.out.println( key + ",frequency: " + this.duplicateMap.get(key));
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return numOfItems;
	}
	
	public LinkedList() {
		head = null;
		numOfItems = 0;
	}
	
	public void addToTail(int num) {
		if (head == null) {
			head = new Node(num);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(num);
		}
		numOfItems++;
	}
	
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
	
	// iterates over the list to find the item and then deletes it
	public void deleteFromList(int n) {
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		int deleteCount = 0;
		Node current = head;
		while (current.next != null) {
			// if its the head
			if (current.data == n) {
				head = current.next;
				current = head;
				numOfItems--;
				deleteCount++;
			} else if (current.next.data == n) {
				current.next = current.next.next;
				numOfItems--;
				deleteCount++;
			}
			current = current.next;
		}
		System.out.println(n + " was deleted " + deleteCount + " times");
	}
	
	// finds an item's position in the list
	// the item can be found at multiple positions
	public int [] foundAt(int n) {
		if (head == null) {
			System.out.println("Empty List");
			return null;
		}
		int [] foundPositions = new int[numOfItems];
		Node current = head;
		int position = 0,i = 0;
		while (current != null) {
			if (current.data == n) {
				foundPositions[i] = position;
				i++;
			}
			position++;
			current = current.next;
		}
		return foundPositions;
	}
	
	// profiles the data in the linked list
	// first create a count map and then  count number of duplicates
	public void profileList() {
		this.countMap = new HashMap<Integer, Integer>();
		this.duplicateMap = new HashMap<Integer, Integer>();
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		Node current = head;
		// create the count map
		while (current != null) {
			if (this.countMap.get(current.data) == null) {
				this.countMap.put(current.data, 1);
			} else {
				this.countMap.put(current.data,this.countMap.get(current.data)+1);
			}
			current = current.next;
		}
		// find the duplicates
		for (int key:this.countMap.keySet()) {
			if (this.countMap.get(key) > 1) {
				this.duplicateMap.put(key, this.countMap.get(key));
			}
		}
	}
	
	// my method
	public void removeDuplicates() {
		if (this.duplicateMap.size() == 0) {
			System.out.println("No duplicates found");
			return;
		}
		System.out.println("Removing duplicates");
		for (int key : this.duplicateMap.keySet()) {
			this.deleteFromList(key);
		}
	}
	
	// remove 
	
}
