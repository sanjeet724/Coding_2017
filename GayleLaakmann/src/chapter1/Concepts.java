package chapter1;

// Stub class to understand and try out new concepts

public class Concepts {

	public static void main(String[] args) {
		//NumericValueTest();
		//StringValueofTest();
		StringArrayTest();
	}
	
	// Numeric values returns same value for a/A through z/Z
	// So we don't need to worry about lowercase or uppercase
	public static void NumericValueTest() {
		System.out.println("Numeric Value of a: " + Character.getNumericValue('a'));
		System.out.println("Numeric Value of A: " + Character.getNumericValue('A'));
		System.out.println("Numeric Value of z: " + Character.getNumericValue('z'));
		System.out.println("Numeric Value of Z: " + Character.getNumericValue('Z'));
		System.out.println("Numeric Value of ' ': " + Character.getNumericValue(' '));
	}
	
	public static void StringValueofTest() {
		int count = 8;
		int count2 = 12;
		int count3 = 123;
		System.out.println("String Value of count: " + String.valueOf(count) + " and length: " + String.valueOf(count).length());
		System.out.println("String Value of count2: " + String.valueOf(count2) + " and length: " + String.valueOf(count2).length());
		System.out.println("String Value of count3: " + String.valueOf(count3) + " and length: " + String.valueOf(count3).length());
	}
	
	
	// array values get modified because they are passed by reference
	public static void StringArrayTest() {
		char [] myArray = new char[4];
		myArray[3] = 'D';
		changeCharacters(myArray);
		System.out.println(" String is: " + String.valueOf(myArray));
	}
	
	private static void changeCharacters(char [] myArray) {
		myArray[0] = 'a';
		myArray[1] = 'b';
		myArray[2] = 'c';
		myArray[3] = 'd';	
	}

}
