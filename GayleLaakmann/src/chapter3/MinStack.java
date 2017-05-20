package chapter3;

import java.util.Stack;
/* Question 2
Stack Min: How would you design a stack which, in addition to push and pop, 
has a function min which returns the minimum element? Push, 
pop and min should all operate in 0(1) time.
*/

class MinStack {
    int min;
    Stack<Integer> stack;
    
    // constructor
    public MinStack() {
    	min = Integer.MAX_VALUE;
    	stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min) {          
            stack.push(min);
            min=x;
        }
        System.out.println("Pushing into the stack: " + x);
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
    	System.out.println("Popping: " + stack.peek());
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
    	System.out.println("Peek is: " + stack.peek());
        return stack.peek();
    }

    public int getMin() {
    	System.out.println("Min is: " + min);
        return min;
    }
}