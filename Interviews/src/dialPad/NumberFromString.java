package dialPad;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberFromString {
	String numStr;
	Boolean isValid;
	private BigInteger parsedNum;
	
	public NumberFromString(String str) {
		this.numStr = str;
		if (str.length() < 7 || str.length() > 14) {
			this.parsedNum = null;
			this.isValid = false;
		} else {
			try {
				BigInteger numericValue = new BigInteger(str);
				this.parsedNum = numericValue;
				if (numericValue.compareTo(BigInteger.ZERO) > 0) {
					this.isValid = true;
				} else {
					this.isValid = false;;
				}
			} catch(NumberFormatException e) { 
			    this.parsedNum = null;
			    this.isValid = false;
			} catch(NullPointerException e) {
				this.parsedNum = null;
				this.isValid = false;
			}
		}
	}
	
	public String generateLotteryNumbers() {
		String result;
		if (this.isValid) {
			if (this.numStr.length() == 7) {
				result = this.getSingleDigitNumbers();
			} else if (this.numStr.length() == 14) {
				result = this.getDoubleDigitNumbers();
			} else {
				result = this.getMixDigitsNumbers();
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Creates one string from a list of strings
	 * @param uniqueList - a list of unique strings
	 * @return - one concatenated string from the list or null
	 */
	private String createLuckyNumString(List<String> uniqueList) {
		if (uniqueList.size() == 7) {
			StringBuilder result = new StringBuilder();
			for (String str : uniqueList) {
				result.append(str);
				result.append(" ");
			}
			return new String(result).trim();
		}
		return null;
	}
	
	/**
	 * Generates 7 unique numbers from a string of exactly 7 characters
	 * @return
	 */
	private String getSingleDigitNumbers() {
		String luckyNumString;
		HashSet<String> uniqueSet = new HashSet<String>(); // to check duplicates
		List<String> res = new ArrayList<String>(); // to maintain the order
		for (int i = 0; i < this.numStr.length(); i++) {
			int numericValue = Character.getNumericValue(this.numStr.charAt(i));
			if (numericValue != 0) { // cannot be a zero
				if (!uniqueSet.contains(Character.toString(this.numStr.charAt(i)))) {
					uniqueSet.add(Character.toString(this.numStr.charAt(i)));
					res.add(Character.toString(this.numStr.charAt(i)));
				}
			}
		}
		// check if there are 7 unique numbers
		luckyNumString = this.createLuckyNumString(res);
		return luckyNumString;
	}
	
	/**
	 * Generates 7 unique numbers(2 digits each) from a string of exactly 14 characters
	 * @return
	 */
	private String getDoubleDigitNumbers() {
		String luckyNumString;
		HashSet<String> uniqueSet = new HashSet<String>(); // to check duplicates
		List<String> res = new ArrayList<String>(); // to maintain the order
		for (int i = 0; i < this.numStr.length(); i+=2) {
			String temp = this.numStr.substring(i, i+2); // take 2 digits at a time
			      int numericValue = Integer.parseInt(temp);  // guranteed to be an int
			      if (!uniqueSet.contains(temp) && numericValue < 60) {
			    	  uniqueSet.add(temp);
			    	  res.add(temp);
			      }
		}
		// check if there are 7 unique numbers
		luckyNumString = createLuckyNumString(res);
		return luckyNumString;
	}
	
	/**
	 * To do - handle string between length 8-13 (can be single/double digits)
	 * @return
	 */
	private String getMixDigitsNumbers() {
		return "Work in progress";
	}
}
