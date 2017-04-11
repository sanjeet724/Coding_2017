package LeetCode_Easy;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		int hamDist = hammingDistance(x, y);
		System.out.println("Hamming dist is: " + hamDist);
	}
	
	public static int hammingDistance(int x, int y) {
        if (x < 0 || y < 0 || x > Integer.MAX_VALUE || y > Integer.MAX_VALUE) {
            return -1;
        }
        char [] x_binary = getBinary(x);
        char [] y_binary = getBinary(y);
         int hamDist = 0;
         for (int i = 0 ; i < 32; i++) {
             if (x_binary[i] != y_binary[i]) {
                 hamDist++;
             }
         }
         return hamDist;
    }
    
    
    public static char [] getBinary(int n) {
        char [] binaryVersion = new char[32];
        for (int i = 0; i < 32; i++) {
        	binaryVersion[i] = '0';
        }
        int index = 31;
        while (n/2 != 0) {
        	binaryVersion[index] = Character.forDigit(n%2, 10);
            n = n/2;
            index--;
        }
        if (n == 2) {
        	binaryVersion[index] = '0';
        } else if ( n == 1) {
        	binaryVersion[index] = '1';
        }
        // printArray(binaryVersion);
        return binaryVersion;
    }
    
    public static void printArray(char [] charArray) {
    	for (int i = 0; i < charArray.length; i++) {
    		System.out.print(charArray[i]);
    	}
    	System.out.println();
    }

}
