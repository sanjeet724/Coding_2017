package chapter2;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;


public class ReverseList {

	public static void main(String [] args) throws IOException {
		List myList = new List();
		// create a list
		Scanner scanner = new Scanner(new File("numbers.txt"));
		while (scanner.hasNextInt()){
			int item = scanner.nextInt();
			myList.addtoList(item);
		}
		scanner.close();
		System.out.println("Created linked list: ");
		myList.printList();
		System.out.println("\nReversing the list..");
		reverseList(myList);
		myList.printList();
	}
	
	
	public static void reverseList(List mylist) {
		if (mylist.size == 0) {
			System.out.println("Empty List");
			return;
		}
		Node reverse = null;
		Node current = mylist.head;
		while (current != null) {
			Node after = current.next;
			current.next = reverse;
			reverse = current;
			current = after;
		}
		mylist.head = reverse;
	}

}
