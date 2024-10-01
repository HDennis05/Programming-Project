package part02;

import part01.Recipe;
import part01.WeeklyMenu;

public class WeeklyMenuTester {
 
	public static void main(String[] args) throws Exception {
		test48();
		test49();
		test50();
		test51();
		test52();
		test53();
		test54();
	}
	
	public static void test48() throws Exception {
		System.out.println("--- Test 48: addRecipe() when valid -------");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		Recipe testData = Initialise.getRecipe();
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Test data: "+testData.getName()+", 3, 3");
		weeklyMenu.addRecipe(testData, 3, 3);
		
		System.out.println("\nAfter: ");
		System.out.println(weeklyMenu);
		
		System.out.println("--- End Test Case -------------------------\n");
	}
	
	public static void test49() throws Exception {
		System.out.println("--- Test 49: addRecipe() when invalid -----");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		String error = "";
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Test data: null, 6, 0"); 
		
		try {
			weeklyMenu.addRecipe(null, 6, 0);
		} catch (Exception e) {
			error += e;
		}
		
		System.out.println("\nAfter: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Error Message: ");
		System.out.println("'"+error+"'\n");
		
		System.out.println("--- End Test Case --------------------------\n");
	}
	
	public static void test50() throws Exception {
		System.out.println("--- Test 50: removeRecipe() when valid -----");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		weeklyMenu = Initialise.fillMenu(weeklyMenu);
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Test data: 3, 3");
		weeklyMenu.removeRecipe(3, 3);
		
		System.out.println("\nAfter: ");
		System.out.println(weeklyMenu);
		
		System.out.println("--- End Test Case --------------------------\n");
	}
	
	public static void test51() throws Exception {
		System.out.println("--- Test 51: removeRecipe() when invalid ---");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		weeklyMenu = Initialise.fillMenu(weeklyMenu);
		String error = "";
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Test data: 6, 0"); 
		
		try {
			weeklyMenu.removeRecipe(6, 0);
		} catch (Exception e) {
			error += e;
		}
		
		System.out.println("\nAfter: ");
		System.out.println(weeklyMenu);
		
		System.out.println("Error Message: ");
		System.out.println("'"+error+"'\n");
		
		System.out.println("--- End Test Case --------------------------\n");
	}
	
	public static void test52() throws Exception {
		System.out.println("--- Test 52: clearMenu() -------------------");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		weeklyMenu = Initialise.fillMenu(weeklyMenu);
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu); 
		
		weeklyMenu.clearMenu();
		
		System.out.println("\nAfter: ");
		System.out.println(weeklyMenu);
		
		System.out.println("--- End Test Case --------------------------\n");
	}
	
	public static void test53() throws Exception {
		System.out.println("--- Test 53: isEmpty() when empty -----------");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu); 
		
		System.out.println("Returned: ");
		System.out.println(weeklyMenu.isEmpty());
		
		System.out.println("--- End Test Case --------------------------\n");
	}
	
	public static void test54() throws Exception {
		System.out.println("--- Test 54: isEmpty() when not empty--------");
		
		//Preconditions
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		Recipe recipe = Initialise.getRecipe();
		weeklyMenu.addRecipe(recipe, 3, 3);
		
		//Test
		System.out.println("Before: ");
		System.out.println(weeklyMenu); 
		
		System.out.println("Returned: ");
		System.out.println(weeklyMenu.isEmpty());
		
		System.out.println("--- End Test Case --------------------------\n");
	}

}
