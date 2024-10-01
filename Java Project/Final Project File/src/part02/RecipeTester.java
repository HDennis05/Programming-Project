package part02;

import java.util.ArrayList;

import part01.FoodType;
import part01.Ingredient;
import part01.MealType;
import part01.Measurement;
import part01.Recipe;
import part01.Unit;

public class RecipeTester {

	public static void main(String[] args) throws Exception {
		test24();
		test25();
		test26();
		test27();
		test28();
		test29();
		test30();
		test31();
		test32();
		test33();
		test34();
		test35();
		test36();
		test37();
		test38();
		test39();
		test40();
		test41();
		test42();
		test43();
		test44();
		test45();
		test46();
		test47();
	}

	public static void test24() throws Exception {
		System.out.println("--- Test 24: Recipe Constructor when valid -----------");

		// Preconditions
		Ingredient whiteBread = new Ingredient("White Bread", FoodType.NUTRIENT, 265);
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient garlic = new Ingredient("Garlic", FoodType.CEREAL, 111);
		Ingredient butter = new Ingredient("Butter", FoodType.DAIRY, 717);

		Measurement[] measurementsArray = { new Measurement(whiteBread, 4 * 38, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(garlic, 2 * 6, Unit.GRAMS) };
		String[] methodArray = { "Preheat oven to 180°C (350°F).", "In a bowl, mix butter and minced garlic.",
				"Spread the garlic butter on one side of each bread slice.",
				"Sprinkle grated cheese on top and bake until the cheese is melted and bread is toasted." };

		// Test
		System.out.println("Test data: 'Garlic Bread', MealType.STARTER, 4, measurements, method");
		System.out.println("\nRecipe constructed");

		Recipe garlicBread = new Recipe("Garlic Bread", MealType.STARTER, 4, measurementsArray, methodArray);

		System.out.println("\nAfter: ");
		System.out.println(garlicBread);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test25() throws Exception {
		System.out.println("--- Test 25: Recipe Constructor when invalid ----------");

		// Preconditions
		Measurement[] measurementsArray = {};
		String[] methodArray = {};

		// Test
		System.out.println("Test data: '', null, 0, {}, {}");
		System.out.println("\nRecipe constructor attempted");
		String error = "";
		try {
			Recipe recipe = new Recipe("", null, 0, measurementsArray, methodArray);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test26() throws Exception {
		System.out.println("--- Test 26: setName() when valid ---------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before:");
		System.out.println(recipe);

		System.out.println("\nTest data: 'Updated Name'");

		recipe.setName("Updated Name");

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test27() throws Exception {
		System.out.println("--- Test 27: setName() when invalid -------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before:");
		System.out.println(recipe);

		System.out.println("\nTest data: '123'");

		String error = "";
		try {
			recipe.setName("123");
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test28() throws Exception {
		System.out.println("--- Test 28: setName() when null ----------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before:");
		System.out.println(recipe);

		System.out.println("\nTest data: ''");

		String error = "";
		try {
			recipe.setName("");
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test29() throws Exception {
		System.out.println("--- Test 29: setMealType() when valid -----------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: MealType.MAIN");

		recipe.setMealType(MealType.MAIN);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test30() throws Exception {
		System.out.println("--- Test 30: setMealType() when invalid ---------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: null");
		String error = "";
		try {
			recipe.setMealType(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test31() throws Exception {
		System.out.println("--- Test 31: setPortion() when valid ------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: 5");

		recipe.setPortions(5);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test32() throws Exception {
		System.out.println("--- Test 32: setPortion() lowest possible -------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: 1");

		recipe.setPortions(1);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case --------------------------------------\n\n");
	}

	public static void test33() throws Exception {
		System.out.println("--- Test 33: setPortion() highest possible -------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: 99");

		recipe.setPortions(99);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test34() throws Exception {
		System.out.println("--- Test 34: setPortion() when invalid (low) ----------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: 0");

		String error = "";
		try {
			recipe.setPortions(0);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}

	public static void test35() throws Exception {
		System.out.println("--- Test 34: setPortion() when invalid (high) ---------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: 100");

		String error = "";
		try {
			recipe.setPortions(100);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test36() throws Exception {
		System.out.println("--- Test 36: setMeasurements() when valid -------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient milk = new Ingredient("Milk", FoodType.DAIRY, 42);
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		ArrayList<Measurement> newMeasurements = new ArrayList<Measurement>();
		newMeasurements.add( new Measurement(milk, 500, Unit.MILLILITRES));
		newMeasurements.add( new Measurement(cheese, 225, Unit.GRAMS));
		
		System.out.println("\nTest data: newMeasurements = {(milk,500, Unit.MILLILITRES), (cheese, 225, Unit.GRAMS)}");

		recipe.setMeasurements(newMeasurements);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test37() throws Exception {
		System.out.println("--- Test 37: setMeasurements() when invalid -----------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		
		System.out.println("\nTest data: null");

		String error = "";
		try {
			recipe.setMeasurements(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test38() throws Exception {
		System.out.println("--- Test 38: setMethod() when valid -------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		ArrayList<String> newMethod = new ArrayList<String>();
		newMethod.add("Step 1");
		newMethod.add("Step 2");
		newMethod.add("Step 3");

		System.out.println("\nTest data: newMethod= {'Step 1','Step 2','Step 3'}");

		recipe.setMethod(newMethod);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test39() throws Exception {
		System.out.println("--- Test 39: setMethod() when invalid -----------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: null");

		String error = "";
		try {
			recipe.setMethod(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test40() throws Exception {
		System.out.println("--- Test 40: addMeasurement() when valid -------------------");

		// Preconditions
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		Measurement newMeasurement = new Measurement(cheese, 350, Unit.GRAMS);
		
		System.out.println("\nTest data: newMeasurement = (cheese, 350, Unit.GRAMS)");

		recipe.addMeasurement(newMeasurement);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test41() throws Exception {
		System.out.println("--- Test 41: addMeasurement() when invalid -----------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nTest data: null");

		String error = "";
		try {
			recipe.addMeasurement(null);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test42() throws Exception {
		System.out.println("--- Test 42: addMethod() when valid -------------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		String testData = "Combine the egg whites and the flour";
		System.out.println("\nTest data: '"+testData+"'");
		
		recipe.addMethodStep(1, testData);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test43() throws Exception {
		System.out.println("--- Test 43: addMethod() shortest possible ------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		String testData = "a";
		System.out.println("\nTest data: '"+testData+"'");
		
		recipe.addMethodStep(1, testData);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test44() throws Exception {
		System.out.println("--- Test 44: addMethod() longest possible -------------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		String testData = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("\nTest data: '"+testData+"'");
		
		recipe.addMethodStep(1, testData);

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test45() throws Exception {
		System.out.println("--- Test 45: addMethod() when invalid (short) ---------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		String testData = "";
		System.out.println("\nTest data: '"+testData+"'");

		String error = "";
		try {
			recipe.addMethodStep(1,testData);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	
	public static void test46() throws Exception {
		System.out.println("--- Test 46: addMethod() when invalid (long) ----------");

		// Preconditions
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Measurement[] measurementsArray = { new Measurement(apples, 1, Unit.GRAMS) };
		String[] methodArray = { "test method step" };
		Recipe recipe = new Recipe("test", MealType.UNDEFINED, 2, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		String testData = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("\nTest data: '"+testData+"'");

		String error = "";
		try {
			recipe.addMethodStep(1,testData);
		} catch (Exception e) {
			error += e;
		}

		System.out.println("\nAfter:");
		System.out.println(recipe);

		System.out.println("\nError: " + error);

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	
	public static void test47() throws Exception {
		System.out.println("--- Test 47: totalCalories() --------------------------");

		// Preconditions
		Ingredient whiteBread = new Ingredient("White Bread", FoodType.NUTRIENT, 265);
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient garlic = new Ingredient("Garlic", FoodType.CEREAL, 111);
		Ingredient butter = new Ingredient("Butter", FoodType.DAIRY, 717);

		Measurement[] measurementsArray = { new Measurement(whiteBread, 155, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(garlic, 12, Unit.GRAMS) };
		String[] methodArray = { "Preheat oven to 180°C (350°F).", "In a bowl, mix butter and minced garlic.",
				"Spread the garlic butter on one side of each bread slice.",
				"Sprinkle grated cheese on top and bake until the cheese is melted and bread is toasted." };
		Recipe recipe = new Recipe("Garlic Bread", MealType.STARTER, 4, measurementsArray, methodArray);

		// Test
		System.out.println("Before: ");
		System.out.println(recipe);

		System.out.println("\nReturned: "+recipe.totalCalories());

		System.out.println("\n--- End Test Case -------------------------------------\n\n");
	}
	

}
