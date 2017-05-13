package chapter3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Stack myStack  = new Stack();
		myStack.push(1);
		myStack.push(2);
		System.out.println("Size : " + myStack.getSize());
		// add some items from the file
		Scanner scanner = new Scanner(new File("numbers.txt"));
		while (scanner.hasNextInt()){
			int item = scanner.nextInt();
			myStack.push(item);
		}
		scanner.close();
		System.out.println("Size : " + myStack.getSize());
		System.out.println("Popped : " + myStack.pop());
		System.out.println("Popped : " + myStack.pop());
		System.out.println("Peek : " + myStack.peek());
		System.out.println("Size : " + myStack.getSize());
	}

}
