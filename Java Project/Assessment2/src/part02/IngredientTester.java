package part02;

import part01.FoodType;
import part01.Ingredient;
import part01.MealType;
import part01.Measurement;
import part01.Recipe;
import part01.Unit;

public class IngredientTester {

	public static void main(String[] args) throws Exception {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		test12();

	}

	public static void test1() throws Exception {
		System.out.println("--- Test 1: Ingredient Constructor when valid -----------");

		System.out.println("Test data: 'Carrots', FoodType.FRUITVEG, 20");
		System.out.println("\nIngredient constructed");

		Ingredient ingredient = new Ingredient("Carrots", FoodType.FRUITVEG, 20);

		System.out.println("\nAfter ");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test2() throws Exception {
		System.out.println("--- Test 2: Recipe Constructor when invalid ----------");

		System.out.println("Test data: '123', null, 3000");
		System.out.println("\nIngredient constructed");

		String error = "";
		try {
			Ingredient ingredient = new Ingredient("123", null, 3000);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test3() throws Exception {
		System.out.println("--- Test 3: setName() when valid ----------------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before");
		System.out.println(ingredient);

		System.out.println("\nTest data: 'Updated Name'");

		ingredient.setName("Updated Name");

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test4() throws Exception {
		System.out.println("--- Test 4: setName() when invalid -------------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before");
		System.out.println(ingredient);

		System.out.println("\nTest data: '123'");

		String error = "";
		try {
			ingredient.setName("123");
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test5() throws Exception {
		System.out.println("--- Test 5: setName() when null ----------------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before");
		System.out.println(ingredient);

		System.out.println("\nTest data: ''");

		String error = "";
		try {
			ingredient.setName("");
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test6() throws Exception {
		System.out.println("--- Test 6: setFoodType() when valid -----------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: FoodType.DAIRY");

		ingredient.setFoodGroup(FoodType.DAIRY);

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test7() throws Exception {
		System.out.println("--- Test 7: setFoodType() when invalid ---------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: null");

		String error = "";
		try {
			ingredient.setFoodGroup(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test8() throws Exception {
		System.out.println("--- Test 8: setCalories() when valid ------------------");

		// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: 55");

		ingredient.setCalories(55);

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test9() throws Exception {
		System.out.println("--- Test 9: setCalories() lowest possible -------------");

		/// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: 0");

		ingredient.setCalories(0);

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case --------------------------------------\n\n");
	}

	public static void test10() throws Exception {
		System.out.println("--- Test 10: setCalories() highest possible -------------");

		/// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: 999");

		ingredient.setCalories(999);

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\n--- End Test Case --------------------------------------\n\n");
	}

	public static void test11() throws Exception {
		System.out.println("--- Test 11: setCalories() when invalid (low) ----------");

		/// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: -1");

		String error = "";
		try {
			ingredient.setCalories(-1);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test12() throws Exception {
		System.out.println("--- Test 12: setPortion() when invalid (high) ---------");

		/// Preconditions
		Ingredient ingredient = new Ingredient("test", FoodType.UNDEFINED, 1);

		// Test
		System.out.println("Before ");
		System.out.println(ingredient);

		System.out.println("\nTest data: 1000");

		String error = "";
		try {
			ingredient.setCalories(1000);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println(ingredient);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

}
