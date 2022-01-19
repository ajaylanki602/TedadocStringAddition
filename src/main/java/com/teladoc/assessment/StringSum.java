package com.teladoc.assessment;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.teladoc.assessment.exception.InvalidInputException;

/**
 * @author ajayl
 *
 */
public class StringSum {
	
	private static final String EMPTY_STRING = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String input = EMPTY_STRING;
		
		while(!input.equalsIgnoreCase("No")) {
			System.out.println("Please enter input strings");
			String input1 = s.next();
			String input2 = s.next();
			System.out.println("Sum of given inputs is "+addStrings(input1, input2));
			System.out.println("Enter Yes/No to continue/exit");
			input = s.next();
		}
		s.close();

	}
	
	/**
	 * @param str1
	 * @param str2
	 * @return 
	 */
	public static String addStrings(String str1, String str2) {
		
		
		
		if(str1.equals("0"))return str2;
		if(str2.equals("0"))return str1;
		
		Pattern pattern = Pattern.compile("[0-9]+");
		
		if(!pattern.matcher(str1).matches()) {
			throw new InvalidInputException("Input 1 is invalid");
		}
		if(!pattern.matcher(str2).matches()) {
			throw new InvalidInputException("Input 2 is invalid");
		}

		
		int str1Len = str1.length() - 1;
        int str2Len = str2.length() - 1;
        int maxLen = Math.max(str1Len, str2Len) + 2;
        char[] result = new char[maxLen];
        
		int sum = 0; // Holds sum of digits from both the Strings and carries extra digit if sum of
						// both the digits is greater than 10
        
        //Looping over both the inputs and adding digits from the end 
        while(str1Len >= 0 || str2Len >= 0) {
            
        	//Adding the int value of the digit in str1 to sum 
            if(str1Len >= 0) {
                sum += str1.charAt(str1Len--) - '0';
            }
            
          //Adding the int value of the digit in str2 to sum
            if(str2Len >= 0) {
                sum += str2.charAt(str2Len--) - '0';
            }
            
            
            result[--maxLen] = (char)((sum % 10) + '0');
            sum /= 10;//If sum of two digits exceeds 10, carry the quotient for next iteration 
        }
        
        
        if(sum != 0) {
        	result[0] = '1';
            return String.valueOf(result);
        }
        
        return String.valueOf(result, 1, result.length - 1);
	}

}
