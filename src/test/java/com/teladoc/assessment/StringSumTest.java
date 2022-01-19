/**
 * 
 */
package com.teladoc.assessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.teladoc.assessment.exception.InvalidInputException;

/**
 * @author ajayl
 *
 */

public class StringSumTest {

	/**
	 * Test method for {@link com.teladoc.assessment.StringSum#addStrings(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddValidStrings() {
		String str1 = "1234";
		String str2 = "678";
		Assertions.assertEquals(StringSum.addStrings(str1, str2), "1912");
	}
	
	@Test
	public void testAddValidStringsVeryLargeNumbers() {
		String str1 = "87890356485";
		String str2 = "6496870701423";
		Assertions.assertEquals(StringSum.addStrings(str1, str2), "6584761057908");
	}
	
	@Test
	public void testAddStringsWithInvalidInput1() {
		String str1 = "-1234";
		String str2 = "678";
		Throwable exception = Assertions.assertThrows(InvalidInputException.class, () -> {
	        throw new InvalidInputException("Input 1 is invalid");
		});
		try {
		   StringSum.addStrings(str1, str2);
		}
		catch(InvalidInputException ex) {
			Assertions.assertEquals(ex.getMessage(), exception.getMessage());
		}
	}
	
	@Test
	public void testAddStringsWithInvalidInput2() {
		String str1 = "1235";
		String str2 = "-abcd";
		Throwable exception = Assertions.assertThrows(InvalidInputException.class, () -> {
	        throw new InvalidInputException("Input 2 is invalid");
		});
		try {
		   StringSum.addStrings(str1, str2);
		}
		catch(InvalidInputException ex) {
			Assertions.assertEquals(ex.getMessage(), exception.getMessage());
		}
	}
	
	@Test
	public void testAddStringsWithInputsWithDecimals() {
		String str1 = "1235.69";
		String str2 = "1678";
		Throwable exception = Assertions.assertThrows(InvalidInputException.class, () -> {
	        throw new InvalidInputException("Input 1 is invalid");
		});
		try {
		   StringSum.addStrings(str1, str2);
		}
		catch(InvalidInputException ex) {
			Assertions.assertEquals(ex.getMessage(), exception.getMessage());
		}
	}
	

}
