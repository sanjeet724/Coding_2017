package trials;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
Practicing linked list
*/


public class LinkedListDriver {
	public static void main(String[] args) throws IOException {
		LinkedList myList = new LinkedList();
		//System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("numbers.txt"));
		while (scanner.hasNextInt()){
			int item = scanner.nextInt();
			//System.out.println("Adding to list: " + item);
			myList.addToTail(item);
		}
		scanner.close();
		System.out.println("List created with " + myList.size() + " items");
		myList.printList();
		myList.profileList(); 
		myList.getDuplicates();
		myList.removeDuplicates();
		System.out.println("List size after removing duplicates: " + myList.size());
		myList.printList();
	}

}
