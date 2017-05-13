package chapter3;


class Node {
	Node next = null;
	int data;
	
	public Node(Object o) {
		data = (int)o;
	}
}

public class Stack {
	Node top;
	private int size;
	
	// constuctor
	public Stack() {
		top = null;
		size = 0;
	}
	
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			size--;
			return item;
		}
		return null;
	}
	
	Object peek() {
		return top.data;
	}
	
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
		size++;
	}
	
	int getSize() {
		return size;
	}
}

