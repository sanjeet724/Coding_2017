/*
You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1 's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output:9 -> 1 -> 2.That is,912.
*/
package chapter2;

public class Question_5_try {

	public static void main(String[] args) {
		// create the 1st number
		List number_1 = new List();
		number_1.addtoList(7);
		number_1.addtoList(1);
		number_1.addtoList(6);
		//number_1.printList();
		//System.out.println();
		// create the 2nd number
		List number_2 = new List();
		number_2.addtoList(5);
		number_2.addtoList(9);
		number_2.addtoList(2);
		//number_2.printList();
		
		int num_1 = createNumberFromList(number_1);
		int num_2 = createNumberFromList(number_2);
		int sum = num_1 + num_2;
		System.out.println("Number 1 formed from list is: " + num_1);
		System.out.println("Number 2 formed from list is: " + num_2);
		System.out.println("Sum is : " + sum);
		List sum_list = createListFromNumber(sum);
		System.out.println("List created from sum : ");
		sum_list.printList();
		
	}
	
	public static Integer createNumberFromList(List list) {
		Node current = list.head;
		StringBuffer numStr = new StringBuffer();
		while (current != null) {
			numStr.append(current.data);
			current = current.next;
		}
		return Integer.parseInt(numStr.reverse().toString());
	}
	
	public static List createListFromNumber(int number) {
		List sumList = new List();
		String numStr = Integer.toString(number);
		int numericVal;
		for (int i = numStr.length()-1; i >=0; i--) {
			numericVal = Character.getNumericValue(numStr.charAt(i));
			sumList.addtoList(numericVal);
		}
		return sumList;
	}

}
