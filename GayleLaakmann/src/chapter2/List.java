package chapter2;

final class Node {
	int data;
	Node next;
	
	public Node(int n) {
		this.data = n;
		this.next = null;
	}
}

class List {
	Node head;
	int size;
	
	public List() {
		this.head = null;
		this.size = 0;
	}
	
	public void addtoList(int n) {
		if (this.head == null) {
			this.head = new Node(n);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(n);
		}
		size++;
	}
	
	public void printList() {
		if (this.head == null) {
			System.out.println("Empty List");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + ",");
			current = current.next;
		}
		System.out.print("null");
	}

}