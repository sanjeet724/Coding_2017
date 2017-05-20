package chapter3;

import java.util.Stack;

/*
 * Question 6
Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use an additional 
temporary stack, but you may not copy the elements into any other data structure (such as an array). 
The stack supports the following operations: push, pop, peek, and isEmpty.
*/


public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> someStack = new Stack<Integer>();
		// push 3,2,1,7,8,6 into the stack
		someStack.push(3);
		someStack.push(2);
		someStack.push(1);
		someStack.push(7);
		someStack.push(8);
		someStack.push(6);
		// sort the stack
		Stack<Integer> sorted = sort(someStack);
		// check if stack got sorted 
		System.out.println("Popped: " + sorted.pop());
		System.out.println("Popped: " + sorted.pop());
		System.out.println("Popped: " + sorted.pop());
		System.out.println("Popped: " + sorted.pop());
		System.out.println("Popped: " + sorted.pop());
		System.out.println("Popped: " + sorted.pop());
	}
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}

}
