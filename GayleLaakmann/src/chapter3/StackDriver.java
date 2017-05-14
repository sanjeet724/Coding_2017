package chapter3;

public class StackDriver {

	public static void main(String[] args)  {
		//testMyStack();
		testMinStack();
	}
	
	public static void testMyStack()  {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		System.out.println("Size : " + myStack.getSize());
		myStack.push(-3);
		myStack.push(6);
		System.out.println("Size : " + myStack.getSize());
		System.out.println("Popped : " + myStack.pop());
		System.out.println("Popped : " + myStack.pop());
		System.out.println("Peek : " + myStack.peek());
		System.out.println("Size : " + myStack.getSize());
	}
	/*
	 * Pushing order - 7,2,3,4,1,6
	 * Popping order with min - (6,1), (1,2),(4,2),(3,2),(2,7),(7,INT_MAX)
	 */
	public static void testMinStack() {
		MinStack minStack = new MinStack();
		minStack.getMin(); // empty stack will be handled by inbuilt java class
		minStack.push(7);
		minStack.getMin(); 
		minStack.push(2);
		minStack.getMin(); 
		minStack.push(3);
		minStack.getMin();
		minStack.push(4);
		minStack.getMin();
		minStack.push(1);
		minStack.getMin();
		minStack.push(6);
		minStack.getMin();
		minStack.pop();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.getMin(); 
		minStack.pop();
		minStack.getMin(); 
		minStack.pop();
		minStack.getMin(); 
		minStack.pop();
		minStack.getMin(); 
	}
}
