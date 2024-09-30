package part01;

/**
 * Provides Validation routines for System
 * @author Hannah Dennis - 40406567
 */
public class Utility {

	/**
	 * Checks if a name is valid
	 * <br>Using Regular Expressions to check for alphabetic and special characters
	 * @param word - String to check
	 * @return true if valid, false if not
	 */
	public static boolean isName(String word) {
		return word.matches("^[a-zA-Z /&-.,']*$");
	}

	/**
	 * Checks if a String is Numeric
	 * <br>Uses parseInt and parseDouble
	 * @param strNum - String to check
	 * @return true if numeric, false if not
	 */
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if a measurement has correct format
	 * <br>Using Regular Expressions to check for numbers, a space and then letters
	 * @param word - String to check
	 * @return true if valid, false if not
	 */
	public static boolean isMeasurement(String word) {
		return word.matches("[0-9]+\\s[A-Za-z]+");
	}
}
