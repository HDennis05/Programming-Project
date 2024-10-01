package part02;

import part01.FoodType;
import part01.Ingredient;
import part01.Measurement;
import part01.Unit;
import part01.Utility;

public class MeasurementTester {

	public static void main(String[] args) throws Exception {
		test13();
		test14();
		test15();
		test16();
		test17();
		test18();
		test19();
		test20();
		test21();
		test22();
		test23();
	}

	public static void test13() throws Exception {
		System.out.println("--- Test 13: Measurement Constructor when valid -----");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);

		// Test
		System.out.println("Test data: cheese, 550, Unit.GRAMS");
		System.out.println("\nMeasurement constructed");
		Measurement measurement = new Measurement(cheese, 550, Unit.GRAMS);

		System.out.println("\nAfter ");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test14() throws Exception {
		System.out.println("--- Test 14: Measurement Constructor when invalid ---");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);

		// Test
		System.out.println("Test data: null, 0, null");
		System.out.println("\nMeasurement constructor attempted");
		String error = "";
		try {
			Measurement measurement = new Measurement(null, 0, null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test15() throws Exception {
		System.out.println("--- Test 15: setIngredient() when valid -------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient milk = new Ingredient("Milk", FoodType.DAIRY, 42);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nTest data: milk");

		measurement.setIngredient(milk);

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test16() throws Exception {
		System.out.println("--- Test 16: setIngredient() when invalid -----------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nTest data: null");

		String error = "";
		try {
			measurement.setIngredient(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test17() throws Exception {
		System.out.println("--- Test 17: setAmount() when valid -------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		int testdata = 550;
		System.out.println("\nTest data: " + testdata);
		measurement.setAmount(testdata);

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test18() throws Exception {
		System.out.println("--- Test 18: setAmount() lowest possible --------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		int testdata = 1;
		System.out.println("\nTest data: " + testdata);
		measurement.setAmount(testdata);

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test19() throws Exception {
		System.out.println("--- Test 19: setAmount() highest possible -------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		int testdata = 9999;
		System.out.println("\nTest data: " + testdata);
		measurement.setAmount(testdata);

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test20() throws Exception {
		System.out.println("--- Test 20: setAmount() when invalid (low) -------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		int testdata = 0;
		System.out.println("\nTest data: " + testdata);
		String error = "";
		try {
			measurement.setAmount(testdata);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}
	
	public static void test21() throws Exception {
		System.out.println("--- Test 21: setAmount() when invalid (high) -------");

		//Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		//Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		int testdata = 10000;
		System.out.println("\nTest data: " + testdata);
		String error = "";
		try {
			measurement.setAmount(testdata);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}
	

	public static void test22() throws Exception {
		System.out.println("--- Test 22: setUnit() when valid --------------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		
		System.out.println("\nTest data: Unit.GRAMS");
		measurement.setUnit(Unit.GRAMS);

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

	public static void test23() throws Exception {
		System.out.println("--- Test 23: setUnit() when invalid -------------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Measurement measurement = new Measurement(cheese, 100, Unit.UNDEFINED);

		// Test
		System.out.println("Before");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nTest data: null");
		String error = "";
		try {
			measurement.setUnit(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter");
		System.out.println("Ingredient: " + measurement.getIngredient().getName());
		System.out.println("Amount: " + measurement.getAmount());
		System.out.println("Units: " + measurement.getUnitStr());

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -----------------------------------\n");
	}

}
