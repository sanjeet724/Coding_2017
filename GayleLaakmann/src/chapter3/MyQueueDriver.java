package chapter3;

public class MyQueueDriver {

	public static void main(String[] args) {
		MyQueue someQ = new MyQueue();
		someQ.addToQueue(3);
		someQ.addToQueue(2);
		someQ.addToQueue(1);
		someQ.addToQueue(4);
		
		// check if Queue is right
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 3 
		someQ.addToQueue(7); // 7 should be added to the end
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 2
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 1
		someQ.addToQueue(8); // now 8 should be added to the last
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 4
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 7	
		System.out.println("De-queing: " + someQ.getFirstInQueue()); // 8	
	}

}
