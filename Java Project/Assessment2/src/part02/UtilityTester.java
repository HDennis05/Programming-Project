package part02;

import part01.Utility;

public class UtilityTester {

	public static void main(String[] args) {
		test55();
		test56();
		test57();
		test58();
		test59();
		test60();
	}
	
	public static void test55() {
		System.out.println("--- Test 55: isName() when valid --------");
		String testData = "Hannah's Potato & Leek Soup";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isName(testData));
		System.out.println("--- End Test Case -----------------------\n");
	}
	
	public static void test56() {
		System.out.println("--- Test 56: isName() when invalid ------");
		String testData = "123!*%abc";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isName(testData));
		System.out.println("--- End Test Case -----------------------\n");
	}
	
	public static void test57() {
		System.out.println("--- Test 57: isNumeric() when valid -----");
		String testData = "1536";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isNumeric(testData));
		System.out.println("--- End Test Case -----------------------\n");
	}
	
	public static void test58() {
		System.out.println("--- Test 58: isNumeric() when invalid ---");
		String testData = "123!*%abc";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isNumeric(testData));
		System.out.println("--- End Test Case -----------------------\n");
	}
	
	public static void test59() {
		System.out.println("--- Test 59: isMeasurement() when valid -");
		String testData = "400 g";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isMeasurement(testData));
		System.out.println("--- End Test Case -----------------------\n");
	}
	
	public static void test60() {
		System.out.println("--- Test 60: isMeasurement() when invalid ---");
		String testData = "123!*%abc";
		System.out.println("Test data: '"+testData+"'");
		System.out.print("Returned: ");
		System.out.println(Utility.isMeasurement(testData));
		System.out.println("--- End Test Case ------------------\n");
	}

}
