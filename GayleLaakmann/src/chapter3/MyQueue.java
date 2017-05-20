package chapter3;
/* Question 5
 * Implement a MyQueue class which implements a queue using 2 stacks */
import java.util.Stack;

public class MyQueue {
	Stack<Integer> enqueue;
	Stack<Integer> dequeue;
	
	public MyQueue() {
		enqueue = new Stack<Integer>();
		dequeue = new Stack<Integer>();
	}
	
	public void addToQueue(int n) {
		while(!dequeue.isEmpty()) {
			enqueue.push(dequeue.pop());
		}
		enqueue.push(n);
	}
	
	public int getFirstInQueue() {
		while (!enqueue.isEmpty()) {
			dequeue.push(enqueue.pop());
		}
		return dequeue.pop();
	}
}
