package dialPad;

public class Driver {

	public static void main(String[] args) {
		String [] numbers = {
				"569815571556", 
				"4938532894754", 
				"1234567",
				"472844278465445",
				"1234560",
				"3457192",
				"3378012",
				"8927138",
				"a678213",
				"as78231",
				"3423189",
				"49385328947546",
				"49385322143547",
				"47385322143547",
				"493853221435a7",
				"49385322143527",
				"49382722143527",
				"49382722143559",
				"49382722143560",
				"-4938272214355",
				"-12345678"
		} ;
		for (String num : numbers) {
			NumberFromString myNum = new NumberFromString(num);
			String myLuckyNums = myNum.generateLotteryNumbers();
			System.out.println(num + " -> " + myLuckyNums);
		}
	}

}
