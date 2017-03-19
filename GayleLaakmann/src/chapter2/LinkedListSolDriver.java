package chapter2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinkedListSolDriver {

	public static void main(String[] args) throws IOException {
		LinkedListSol myList = new LinkedListSol();
		// create a list
		Scanner scanner = new Scanner(new File("numbers.txt"));
		while (scanner.hasNextInt()){
			int item = scanner.nextInt();
			myList.addToList(item);
		}
		scanner.close();
		myList.printList();
		//myList.removeDups();
		myList.removeDupsRunner();
		myList.printList();
	}

}
