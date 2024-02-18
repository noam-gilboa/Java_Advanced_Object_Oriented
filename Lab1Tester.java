package Lab1;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab1Tester {

	
	// sum
	
	@Test
	public void testproduct1() {
		int start = 0;
		int end = 5; 
		int  prod= 1;
		for (int i = start ; i <= end ; i++) 
			prod  *= i;
		
		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));
			
	}
	@Test
	public void testproduct2() {
		int start = -10;
		int end = 10; 
		int  prod= 1;
		for (int i = start ; i <= end ; i++) 
			prod  *= i;
		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));
			
	}
	@Test
	public void testproduct3() {
		int start = 10;
		int end = 10; 
		int  prod= 1;
		for (int i = start ; i <= end ; i++) 
			prod  *= i;
		assertEquals("Failed at product (" + start + ", " + end + ")", prod, Lab1.product(start, end));
			
			
	}
	

	@Test
	public void testMakeString1() {
		char init = '*'; 
		int n = 5;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab1.makeString(init, n));	
	}

	@Test
	public void testMakeString2() {
		char init = '*'; 
		int n = 0;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab1.makeString(init, n));	
	}
	
	@Test
	public void testWriteChars1() {

		assertEquals("Failed: testWriteChars1", "*", Lab1.writeChars(1));
	}

	
	@Test
	public void testWriteChars2() {

		assertEquals("Failed: testWriteChars2", "**", Lab1.writeChars(2));
	}

	@Test
	public void testWriteChars3() {

		assertEquals("Failed: testWriteChars3", "<*>", Lab1.writeChars(3));
	}
	
	@Test
	public void testWriteChars4() {

		assertEquals("Failed: testWriteChars4", "<**>", Lab1.writeChars(4));
	}
	
	@Test
	public void testWriteChars5() {

		assertEquals("Failed: testWriteChars5", "<<<<**>>>>", Lab1.writeChars(10));
	}
	
	@Test
	public void testWriteChars6() {

		assertEquals("Failed: testWriteChars6", "<<<<<<<<<<<<*>>>>>>>>>>>>", Lab1.writeChars(25));
	}

	@Test
	public void testGetSubstring1() {

		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab1.getSubstring("x + y + z - ( y * z) / 3 * n ", '(', ')'));
	}

	@Test
	public void testGetSubstring2() {

		String str1 = "This is a \"good\" practice";
		String result = "good";
		char open = '"';
		char close = '"';
		assertEquals("Failed: getSubstring(\"This is a 'good' practice\", '\"', '\"')", result, Lab1.getSubstring("This is a \"good\" practice", '"', '"'));
	}
	
	@Test
	public void testGetSubstring3() {

		String str1 = "[x + y + (y - z)]";
		String result = "x + y + (y - z)";
		char open = '[';
		char close = ']';
		assertEquals("Failed: getSubstring(\"[x + y + (y - z)]\", '[', ']')", result, Lab1.getSubstring("[x + y + (y - z)]", '[', ']'));
	}
	@Test
	public void testGetSubstring4() {

		String str1 = "[]";
		String result = "";
		char open = '[';
		char close = ']';
		assertEquals("Failed: getSubstring(\"[]\", '[', ']')", result, Lab1.getSubstring("[]", '[', ']'));
	}
	@Test
	public void testGetSubstring5() {

		String str1 = "{a}";
		String result = "a";
		char open = '{';
		char close = '}';
		assertEquals("Failed: getSubstring(\"{a}\", '{', '}')", result, Lab1.getSubstring("{a}", '{', '}'));
	}
	@Test
	public void testGetSubstring6() {

		String str1 = " This is [quite} an example!";
		String result = "quite";
		char open = '[';
		char close = '}';
		assertEquals("Failed: getSubstring(\" This is [quite} an example!\", '[', '}')", result, Lab1.getSubstring("\" This is [quite} an example!\"", '[', '}'));
	}
	@Test
	public void testDecimalToBinary1() {
		int decimal = 0; 
		String binary = "0";
		assertEquals("Failed: decimalToBinary(0)", binary, Lab1.decimalToBinary(0));
	}

	@Test
	public void testDecimalToBinary2() {
		int decimal = 1; 
		String binary = "1";
		assertEquals("Failed: decimalToBinary(1)", binary, Lab1.decimalToBinary(1));
	}
	@Test
	public void testDecimalToBinary3() {
		int decimal = 2; 
		String binary = "10";
		assertEquals("Failed: decimalToBinary(2)", binary, Lab1.decimalToBinary(2));
	}
	@Test
	public void testDecimalToBinary4() {
		int decimal = 23; 
		String binary = "10111";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab1.decimalToBinary(23));
	}
	@Test
	public void testDecimalToBinary5() {
		int decimal = 1073741824; 
		String binary = "1000000000000000000000000000000";
		assertEquals("Failed: decimalToBinary(1073741824)", binary, Lab1.decimalToBinary(1073741824));
	}
}
