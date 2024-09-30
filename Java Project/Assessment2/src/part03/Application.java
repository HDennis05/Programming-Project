package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

/**
 * Application file <br>
 * Contains all functionality for System <br>
 * Including Creation, Retrieval, Updating and Deleting Functionality
 * 
 * @author Hannah Dennis - 40406567
 */
public class Application {
	static Scanner input = new Scanner(System.in);

	// Initialising ArrayLists to contain Ingredients and Recipes
	public static ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	public static ArrayList<Recipe> recipesList = new ArrayList<Recipe>();
	// Initialising empty weeklyMenu
	public static WeeklyMenu weeklyMenu = new WeeklyMenu();

	public static void DisplayTitle(String title) {
		QUBKitchen.con.clear();
		QUBKitchen.con.setFont(new Font("Monospaced", Font.BOLD, 24));
		QUBKitchen.con.setColour(Color.DARK_GRAY);
		String space = " ";
		int spaceAmount = 26-((title.length())/2);
		QUBKitchen.con.println(space.repeat(spaceAmount)+title);

		QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));

	}
	
	/***
	 * Initialises objects for use within application
	 * 
	 * @throws Exception
	 */
	public static void initialiseQUBKitchen() throws Exception {
		// Initialising ingredients

		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Ingredient bakedBeans = new Ingredient("Baked Beans", FoodType.COMP, 155);
		Ingredient bakingPowder = new Ingredient("Baking Powder", FoodType.COMP, 20);
		Ingredient bellPeppers = new Ingredient("Bell Peppers", FoodType.FRUITVEG, 20);
		Ingredient butter = new Ingredient("Butter", FoodType.DAIRY, 717);
		Ingredient celery = new Ingredient("Celery", FoodType.FRUITVEG, 8);
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient chicken = new Ingredient("Chicken", FoodType.PROTEIN, 165);
		Ingredient cinnamon = new Ingredient("Cinnamon", FoodType.SPICEHERB, 3);
		Ingredient eggs = new Ingredient("Eggs", FoodType.PROTEIN, 155);
		Ingredient flour = new Ingredient("Flour", FoodType.CEREAL, 364);
		Ingredient garlic = new Ingredient("Garlic", FoodType.SPICEHERB, 111);
		Ingredient groundBeef = new Ingredient("Ground Beef", FoodType.PROTEIN, 332);
		Ingredient honey = new Ingredient("Honey", FoodType.SUGAR, 20);
		Ingredient jam = new Ingredient("Jam", FoodType.COMP, 278);
		Ingredient leeks = new Ingredient("Leeks", FoodType.FRUITVEG, 61);
		Ingredient lettuce = new Ingredient("Lettuce", FoodType.FRUITVEG, 15);
		Ingredient milk = new Ingredient("Milk", FoodType.DAIRY, 42);
		Ingredient mushrooms = new Ingredient("Mushrooms", FoodType.FRUITVEG, 20);
		Ingredient oliveOil = new Ingredient("Olive Oil", FoodType.DAIRY, 884);
		Ingredient onion = new Ingredient("Onion", FoodType.FRUITVEG, 40);
		Ingredient pennePasta = new Ingredient("Penne Pasta", FoodType.CEREAL, 118);
		Ingredient pepper = new Ingredient("Pepper", FoodType.SPICEHERB, 20);
		Ingredient potatoes = new Ingredient("Potatoes", FoodType.FRUITVEG, 75);
		Ingredient puffPastry = new Ingredient("Puff Pastry", FoodType.CEREAL, 320);
		Ingredient salt = new Ingredient("Salt", FoodType.SPICEHERB, 0);
		Ingredient stockCubes = new Ingredient("Stock Cubes", FoodType.COMP, 438);
		Ingredient sugar = new Ingredient("Sugar", FoodType.SUGAR, 387);
		Ingredient tomatoes = new Ingredient("Tomatoes", FoodType.FRUITVEG, 19);
		Ingredient water = new Ingredient("Water", FoodType.NUTRIENT, 0);
		Ingredient whiteBread = new Ingredient("White Bread", FoodType.CEREAL, 265);
		Ingredient whiteRice = new Ingredient("White Rice", FoodType.CEREAL, 364);
		Ingredient[] tempIngredients = { apples, bakedBeans, bakingPowder, bellPeppers, butter, celery, cheese, chicken,
				cinnamon, eggs, flour, garlic, honey, jam, leeks, lettuce, milk, mushrooms, oliveOil, onion, pennePasta,
				pepper, potatoes, puffPastry, salt, stockCubes, sugar, tomatoes, water, whiteBread, whiteRice };
		for (int i = 0; i<tempIngredients.length; i++) {
			Application.InsertIntoIngredients(tempIngredients[i]);
		}

		//Initialising Recipes and adding to weeklyMenu
		Measurement[] measurementsArray1 = { new Measurement(whiteBread, 4 * 38, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(garlic, 2 * 6, Unit.GRAMS) };
		String[] methodArray1 = { "Preheat oven to 180°C (350°F).", "In a bowl, mix butter and minced garlic.",
				"Spread the garlic butter on one side of each bread slice.",
				"Sprinkle grated cheese on top and bake until the cheese is melted and bread is toasted." };
		Recipe garlicBread = new Recipe("Garlic Bread", MealType.STARTER, 4, measurementsArray1, methodArray1, "GarlicBread.jpg");
		Application.InsertIntoRecipes(garlicBread);
		Application.weeklyMenu.addRecipe(garlicBread, 1, 1);
		
		Measurement[] measurementsArray2 = { new Measurement(mushrooms, 200, Unit.GRAMS),
				new Measurement(garlic, 12, Unit.GRAMS), new Measurement(cheese, 50, Unit.GRAMS),
				new Measurement(oliveOil, 30, Unit.MILLILITRES), new Measurement(salt, 3, Unit.GRAMS),
				new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray2 = { "Preheat the oven to 180°C (350°F).",
				"In a bowl, mix minced garlic, grated cheese, salt, and pepper.",
				"Stuff each mushroom cap with the garlic and cheese mixture.",
				"Drizzle olive oil over the mushrooms and bake in the preheated oven until the tops are golden and bubbly." };
		Recipe stuffedGarlicButterMushrooms = new Recipe("Stuffed Garlic Butter Mushrooms", MealType.STARTER, 4,
				measurementsArray2, methodArray2, "StuffedGarlicButterMushrooms.jpg");
		Application.InsertIntoRecipes(stuffedGarlicButterMushrooms);
		Application.weeklyMenu.addRecipe(stuffedGarlicButterMushrooms,2,1);

		Measurement[] measurementsArray3 = { new Measurement(groundBeef, 250, Unit.GRAMS),
				new Measurement(onion, 200, Unit.GRAMS), new Measurement(garlic, 12, Unit.GRAMS),
				new Measurement(lettuce, 64, Unit.GRAMS), new Measurement(salt, 3, Unit.GRAMS) };
		String[] methodArray3 = { "In a pan, brown the ground beef with chopped onions and minced garlic.",
				"Season with salt and pepper to taste.",
				"Spoon the cooked beef mixture onto individual lettuce leaves.", "Serve as an appetizer or snack." };
		Recipe lettuceWrapsWithGroundBeef = new Recipe("Lettuce Wraps with Ground Beef", MealType.STARTER, 4,
				measurementsArray3, methodArray3, "LettuceWrapsWithGroundBeef.jpg");
		Application.InsertIntoRecipes(lettuceWrapsWithGroundBeef);
		Application.weeklyMenu.addRecipe(lettuceWrapsWithGroundBeef,3,1);

		Measurement[] measurementsArray4 = { new Measurement(tomatoes, 200, Unit.GRAMS),
				new Measurement(leeks, 300, Unit.GRAMS), new Measurement(oliveOil, 30, Unit.MILLILITRES),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS),
				new Measurement(whiteBread, 120, Unit.GRAMS) };
		String[] methodArray4 = { "In a bowl, combine diced tomatoes, sliced leeks, olive oil, salt, and pepper.",
				"Toast slices of white bread.", "Spoon the tomato and leek mixture onto the toasted bread slices.",
				"Serve as a refreshing bruschetta." };
		Recipe tomatoAndLeekBruschetta = new Recipe("Tomato and Leek Bruschetta", MealType.STARTER, 4,
				measurementsArray4, methodArray4, "TomatoAndLeekBruschetta.jpg");
		Application.InsertIntoRecipes(tomatoAndLeekBruschetta);
		Application.weeklyMenu.addRecipe(tomatoAndLeekBruschetta,4,1);

		Measurement[] measurementsArray5 = { new Measurement(potatoes, 700, Unit.GRAMS),
				new Measurement(celery, 80, Unit.GRAMS), new Measurement(cheese, 100, Unit.GRAMS),
				new Measurement(butter, 50, Unit.GRAMS), new Measurement(salt, 3, Unit.GRAMS),
				new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray5 = { "Preheat the oven to 200°C (400°F).", "Bake the potatoes until tender.",
				"Cut a slit in each potato and fluff the insides with a fork.",
				"Mix chopped celery, shredded cheese, and a pat of butter.",
				"Stuff each potato with the celery and cheese mixture.",
				"Bake until the cheese is melted and bubbly." };
		Recipe celeryAndCheeseStuffedPotatoes = new Recipe("Celery and Cheese Stuffed Baked Potatoes", MealType.STARTER,
				4, measurementsArray5, methodArray5, "CeleryAndCheeseStuffedPotatoes.jpg");
		Application.InsertIntoRecipes(celeryAndCheeseStuffedPotatoes);
		Application.weeklyMenu.addRecipe(celeryAndCheeseStuffedPotatoes,5,1);

		Measurement[] measurementsArray6 = { new Measurement(potatoes, 500, Unit.GRAMS),
				new Measurement(leeks, 200, Unit.GRAMS), new Measurement(onion, 200, Unit.GRAMS),
				new Measurement(garlic, 12, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(stockCubes, 12, Unit.GRAMS), new Measurement(water, 1000, Unit.MILLILITRES),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray6 = { "In a large pot, melt butter and sauté onions and garlic until translucent.",
				"Add leeks and potatoes, cook for 5 minutes.",
				"Dissolve stock cubes in water and add to the pot. Season with salt and pepper.",
				"Simmer until potatoes are tender. Use a blender to puree the soup until smooth." };
		Recipe potatoLeekSoup = new Recipe("Potato Leek Soup", MealType.MAIN, 4, measurementsArray6, methodArray6, "PotatoLeekSoup.jpg");
		Application.InsertIntoRecipes(potatoLeekSoup);
		Application.weeklyMenu.addRecipe(potatoLeekSoup,1,2);
		
		Measurement[] measurementsArray7 = { new Measurement(pennePasta, 250, Unit.GRAMS),
				new Measurement(cheese, 200, Unit.GRAMS), new Measurement(tomatoes, 400, Unit.GRAMS),
				new Measurement(onion, 200, Unit.GRAMS), new Measurement(garlic, 14, Unit.GRAMS),
				new Measurement(oliveOil, 15, Unit.MILLILITRES), new Measurement(salt, 3, Unit.GRAMS),
				new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray7 = { "Cook penne pasta according to package instructions. Drain and set aside.",
				"In a pan, sauté onions and garlic in olive oil until translucent.",
				"Add diced tomatoes and cook until softened. Season with salt and pepper.",
				"Combine cooked pasta with the tomato mixture. Transfer to a baking dish.",
				"Sprinkle shredded cheese over the top. Bake in a preheated oven at 180°C (350°F) until cheese is melted and bubbly." };
		Recipe cheesyBakedPennePasta = new Recipe("Cheesy Baked Penne Pasta", MealType.MAIN, 4, measurementsArray7,
				methodArray7, "CheesyBakedPennePasta.jpg");
		Application.InsertIntoRecipes(cheesyBakedPennePasta);
		Application.weeklyMenu.addRecipe(cheesyBakedPennePasta,2,2);

		Measurement[] measurementsArray8 = { new Measurement(pennePasta, 250, Unit.GRAMS),
				new Measurement(groundBeef, 250, Unit.GRAMS), new Measurement(leeks, 300, Unit.GRAMS),
				new Measurement(onion, 200, Unit.GRAMS), new Measurement(garlic, 12, Unit.GRAMS),
				new Measurement(tomatoes, 400, Unit.GRAMS), new Measurement(oliveOil, 30, Unit.MILLILITRES),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS) };
		String[] methodArray8 = { "Cook the penne pasta according to package instructions. Drain and set aside.",
				"In a pan, sauté chopped onions and minced garlic in olive oil.",
				"Add ground beef and cook until browned.",
				"Stir in sliced leeks and diced tomatoes, cooking until leeks are tender.",
				"Combine the cooked pasta with the beef and leek mixture, transfer to a baking dish, top with grated cheese, and bake until bubbly." };
		Recipe beefAndLeekPastaBake = new Recipe("Ground Beef and Leek Pasta Bake", MealType.MAIN, 4,
				measurementsArray8, methodArray8, "GroundBeefAndLeekPastaBake.jpg");
		Application.InsertIntoRecipes(beefAndLeekPastaBake);
		Application.weeklyMenu.addRecipe(beefAndLeekPastaBake,3,2);

		Measurement[] measurementsArray9 = { new Measurement(chicken, 750, Unit.GRAMS),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS),
				new Measurement(oliveOil, 30, Unit.MILLILITRES), new Measurement(apples, 300, Unit.GRAMS),
				new Measurement(jam, 60, Unit.GRAMS), new Measurement(butter, 30, Unit.GRAMS) };
		String[] methodArray9 = { "Season chicken breasts with salt and pepper.",
				"In a pan, heat olive oil and sear the chicken on both sides until golden brown.",
				"Add sliced apples, jam, and butter to the pan.",
				"Cook until the chicken is fully cooked and glazed with the apple and jam mixture.",
				"Serve the chicken with the glazed apples on top." };
		Recipe appleJamGlazedChicken = new Recipe("Apple and Jam Glazed Chicken", MealType.MAIN, 4, measurementsArray9,
				methodArray9,"AppleJamGlazedChicken.jpg");
		Application.InsertIntoRecipes(appleJamGlazedChicken);
		Application.weeklyMenu.addRecipe(appleJamGlazedChicken,4,2);

		Measurement[] measurementsArray10 = { new Measurement(whiteRice, 250, Unit.GRAMS),
				new Measurement(eggs, 120, Unit.GRAMS), new Measurement(onion, 200, Unit.GRAMS),
				new Measurement(oliveOil, 30, Unit.MILLILITRES), new Measurement(salt, 3, Unit.GRAMS),
				new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray10 = { "In a pan, heat olive oil and sauté chopped onions until translucent.",
				"Push the onions to one side of the pan and pour the beaten eggs into the other side.",
				"Scramble the eggs until cooked, then mix with the onions.",
				"Add the cooked and cooled rice, stir well, and season with salt and pepper.",
				"Cook until the rice is heated through." };
		Recipe eggOnionFriedRice = new Recipe("Egg and Onion Fried Rice", MealType.MAIN, 4, measurementsArray10,
				methodArray10,"EggOnionFriedRice.jpg");
		Application.InsertIntoRecipes(eggOnionFriedRice);
		Application.weeklyMenu.addRecipe(eggOnionFriedRice,5,2);

		Measurement[] measurementsArray11 = { new Measurement(flour, 200, Unit.GRAMS),
				new Measurement(butter, 100, Unit.GRAMS), new Measurement(sugar, 50, Unit.GRAMS),
				new Measurement(eggs, 60, Unit.GRAMS), new Measurement(jam, 100, Unit.GRAMS) };
		String[] methodArray11 = { "Preheat the oven to 180°C (350°F).",
				"In a bowl, cream together softened butter and sugar until smooth.", "Add the egg and mix well.",
				"Gradually incorporate the flour until a dough forms.",
				"Roll the dough into small balls and place them on a baking sheet.",
				"Make an indentation in each cookie with your thumb and fill with a small spoonful of apple jam.",
				"Bake in the preheated oven for 12-15 minutes or until the edges are golden brown." };
		Recipe appleJamThumbprintCookies = new Recipe("Apple Jam Thumbprint Cookies", MealType.DESSERT, 24,
				measurementsArray11, methodArray11,"AppleJamThumbprintCookies.jpg");
		Application.InsertIntoRecipes(appleJamThumbprintCookies);
		Application.weeklyMenu.addRecipe(appleJamThumbprintCookies,4,3);

		Measurement[] measurementsArray12 = { new Measurement(flour, 250, Unit.GRAMS),
				new Measurement(eggs, 120, Unit.GRAMS), new Measurement(milk, 250, Unit.MILLILITRES),
				new Measurement(cheese, 150, Unit.GRAMS), new Measurement(jam, 120, Unit.GRAMS),
				new Measurement(butter, 20, Unit.GRAMS) };
		String[] methodArray12 = { "In a bowl, whisk together flour, eggs, and milk to make crepe batter.",
				"Cook thin crepes in a hot, buttered pan.",
				"Place a slice of cheese and a spoonful of jam in the center of each crepe.",
				"Fold the crepes and serve." };
		Recipe cheeseJamStuffedCrepes = new Recipe("Cheese and Jam Stuffed Crepes", MealType.DESSERT, 4,
				measurementsArray12, methodArray12, "CheeseAndJamStuffedCrepes.jpg");
		Application.InsertIntoRecipes(cheeseJamStuffedCrepes);
		Application.weeklyMenu.addRecipe(cheeseJamStuffedCrepes,5,3);

		Measurement[] measurementsArray13 = { new Measurement(apples, 300, Unit.GRAMS),
				new Measurement(flour, 200, Unit.GRAMS), new Measurement(sugar, 100, Unit.GRAMS),
				new Measurement(eggs, 120, Unit.MILLILITRES), new Measurement(milk, 100, Unit.MILLILITRES),
				new Measurement(butter, 75, Unit.GRAMS), new Measurement(bakingPowder, 15, Unit.GRAMS),
				new Measurement(cinnamon, 7, Unit.GRAMS), new Measurement(salt, 3, Unit.GRAMS) };
		String[] methodArray13 = { "Preheat the oven to 180°C (350°F) and line a muffin tin with paper liners.",
				"In a bowl, mix the flour, sugar, baking powder, cinnamon, and salt.",
				"In another bowl, whisk together the eggs, melted butter, and milk.",
				"Combine the wet and dry ingredients, then fold in the diced apples.",
				"Spoon the batter into the muffin cups and bake for 18-20 minutes or until a toothpick comes out clean." };
		Recipe appleCinnamonMuffins = new Recipe("Apple and Cinnamon Muffins", MealType.DESSERT, 12,
				measurementsArray13, methodArray13, "AppleAndCinnamonMuffins.jpg");
		Application.InsertIntoRecipes(appleCinnamonMuffins);
		Application.weeklyMenu.addRecipe(appleCinnamonMuffins,1,3);

		Measurement[] measurementsArray14 = { new Measurement(puffPastry, 320, Unit.GRAMS),
				new Measurement(apples, 300, Unit.GRAMS), new Measurement(cheese, 100, Unit.GRAMS),
				new Measurement(jam, 100, Unit.GRAMS), new Measurement(honey, 20, Unit.MILLILITRES) };
		String[] methodArray14 = { "Preheat the oven to 200°C (400°F).",
				"Cut the puff pastry into squares and place them on a baking sheet.",
				"Layer sliced apples, grated cheese, and a small spoonful of jam on each square.",
				"Bake until the pastry is golden brown.", "Drizzle with honey before serving." };
		Recipe cheeseAndAppleTartlets = new Recipe("Cheese and Apple Tartlets", MealType.DESSERT, 12,
				measurementsArray14, methodArray14, "CheeseAndAppleTartlets.jpg");
		Application.InsertIntoRecipes(cheeseAndAppleTartlets);
		Application.weeklyMenu.addRecipe(cheeseAndAppleTartlets,2,3);

		Measurement[] measurementsArray15 = { new Measurement(puffPastry, 320, Unit.GRAMS),
				new Measurement(apples, 300, Unit.GRAMS), new Measurement(sugar, 30, Unit.GRAMS),
				new Measurement(cinnamon, 15, Unit.GRAMS), new Measurement(honey, 20, Unit.MILLILITRES) };
		String[] methodArray15 = { "Preheat the oven to 200°C (400°F).",
				"Roll out the puff pastry and sprinkle diced apples, sugar, and cinnamon evenly.",
				"Roll the pastry into a log and slice into rounds.",
				"Place the rounds on a baking sheet and bake until golden.", "Drizzle with honey before serving." };
		Recipe cinnamonApplePastryRolls = new Recipe("Cinnamon Apple Pastry Rolls", MealType.DESSERT, 12,
				measurementsArray15, methodArray15, "CinnamonApplePastryRolls.jpg");
		Application.InsertIntoRecipes(cinnamonApplePastryRolls);
		Application.weeklyMenu.addRecipe(cinnamonApplePastryRolls,3,3);
		
	

	}

	/**
	 * Display food group options to user and ask them to choose one
	 * @param goBack - whether or not user should have to option to go back
	 * @return - chosen Food Group
	 */
	public static FoodType ChooseFoodGroup(boolean goBack) {
		QUBKitchen.con.print("\nFood group options:\n" + "1. Cereal\n" + "2. Composite Food\n" + "3. Dairy\n"
				+ "4. Essential Nutrient\n" + "5. Fat\n" + "6. Fruit & Veg\n" + "7. Protein\n" + "8. Spice & Herb\n"
				+ "9. Sugar\n");
		FoodType foodGroup = FoodType.UNDEFINED; // FoodGroup to be chosen
		boolean finished = false; // Marker to end while loop
		do {
			finished = true;
			if (goBack) {
				QUBKitchen.con.print("Input number of choice (or X to go back): ");
			} else {
				QUBKitchen.con.print("Input number of choice: ");
			}
			String groupInput = QUBKitchen.con.readLn(); // Users choice of Food Group
			switch (groupInput) {
			case "1":
				foodGroup = FoodType.CEREAL;
				break;
			case "2":
				foodGroup = FoodType.COMP;
				break;
			case "3":
				foodGroup = FoodType.DAIRY;
				break;
			case "4":
				foodGroup = FoodType.NUTRIENT;
				break;
			case "5":
				foodGroup = FoodType.FAT;
				break;
			case "6":
				foodGroup = FoodType.FRUITVEG;
				break;
			case "7":
				foodGroup = FoodType.PROTEIN;
				break;
			case "8":
				foodGroup = FoodType.SPICEHERB;
				break;
			case "9":
				foodGroup = FoodType.SUGAR;
				break;
			case "x":
			case "X":
				if (goBack) {
					foodGroup = FoodType.UNDEFINED;
					break;}
			default:
				QUBKitchen.con.println("Invalid Data - Choice must be 1-9");
				finished = false; // if invalid loop and ask again
			}
		} while (finished == false);

		return foodGroup;
	}

	/**
	 * Display all Ingredients to User in a table <br>
	 * or display names in a list
	 * 
	 * @param fullInfo - all information should be displayed
	 */
	public static void DisplayAllIngredients(boolean fullInfo) {
		if (fullInfo == true) {
			QUBKitchen.con.print("\n         ID   Name            Food Group           Calories");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 14));
			QUBKitchen.con.println("(per 100g/ml)\n");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));
		}

		for (int i = 0; i < ingredientsList.size(); i++) {
			if (fullInfo == true) {
				String IDFormatted = String.format("%04d", (ingredientsList.get(i)).getID()); // Pad left side of ID
																								// with zeros to make it
																								// four digits
				String nameFormatted = String.format("%1$-15s", ingredientsList.get(i).getName()); // Pad right side of
																									// name with spaces
																									// to make 15 chars
				String groupFormatted = String.format("%1$-20s", ingredientsList.get(i).getFoodGroupStr()); // Pad right
																											// side of
																											// meal type
																											// to make
																			
				String userdir = System.getProperty("user.dir");
				String path = userdir + ingredientsList.get(i).getImgPath();
				ImageIcon img = new ImageIcon(path);	
				if (img.getIconHeight() < 0) {
					path = userdir + "/images/Ingredients/default.jpg";
					img = new ImageIcon(path);	
				}
				QUBKitchen.con.print(img);
				QUBKitchen.con.println(" "+IDFormatted + " " + nameFormatted + " " + groupFormatted + " "
						+ (ingredientsList.get(i)).getCalories());
			} else {
				QUBKitchen.con.println((i + 1) + ". " + ingredientsList.get(i).getName());
			}
		}
	}

	/**
	 * Display ingredients at specified indexes in a table
	 * 
	 * @param indexes - Indexes of ingredients to display
	 */
	public static void DisplaySpecificIngredients(ArrayList<Integer> indexes) {
		QUBKitchen.con.print("\n         ID   Name            Food Group           Calories");
		QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 14));
		QUBKitchen.con.println("(per 100g/ml)\n");
		QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));

		for (int i = 0; i < indexes.size(); i++) {
			String IDFormatted = String.format("%04d", ingredientsList.get(indexes.get(i)).getID()); // Pad left side of
																										// ID with zeros
																										// to make it
																										// four digits
			String nameFormatted = String.format("%1$-15s", ingredientsList.get(indexes.get(i)).getName()); // Pad right
																											// side of
																											// name with
																											// spaces to
																											// make 15
																											// chars
			String groupFormatted = String.format("%1$-20s", ingredientsList.get(indexes.get(i)).getFoodGroupStr()); // Pad
																														// right
																														// side
																														// of
																														// meal
																														// type
																														// to
																														// make
																														// 20
																														// chars
			String userdir = System.getProperty("user.dir");
			String path = userdir + ingredientsList.get(indexes.get(i)).getImgPath();
			ImageIcon img = new ImageIcon(path);	
			if (img.getIconHeight() < 0) {
				path = userdir + "/images/Ingredients/default.jpg";
				img = new ImageIcon(path);	
			}
			QUBKitchen.con.print(img);
			QUBKitchen.con.println(IDFormatted + " " + nameFormatted + " " + groupFormatted + " "
					+ (ingredientsList.get(i)).getCalories());
		}
	}

	/**
	 * Search Ingredients by ID
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchIngredients(int search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < ingredientsList.size(); i++) {
			if ((ingredientsList.get(i)).getID() == search) {
				results.add(i);
			}
		}
		return results;
	}

	/**
	 * Search Ingredients by Name/Part Name
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchIngredients(String search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < ingredientsList.size(); i++) {
			String currentName = ((ingredientsList.get(i)).getName()).toLowerCase();
			if (currentName.contains(search.toLowerCase())) {
				results.add(i);
			}
		}
		return results;
	}

	/**
	 * Search Ingredients by Food Type
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchIngredients(FoodType search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < ingredientsList.size(); i++) {
			FoodType currentType = (ingredientsList.get(i)).getFoodGroup();
			if (currentType == search) {
				results.add(i);
			}
		}
		return results;

	}

	/**
	 * Updates existing Ingredient <br>
	 * Prompts User for updated fields and uses them to set Ingredient attributes
	 * 
	 * @param updateIndex - Index of Ingredient to be updated
	 * @throws Exception
	 */
	public static void UpdateIngredient(int updateIndex) throws Exception {
		String currentName = ingredientsList.get(updateIndex - 1).getName(); // Name of ingredient
		QUBKitchen.con.println();
		for (int i = 0; i < (currentName.length() + 10); i++) {
			QUBKitchen.con.print("-");
		}
		QUBKitchen.con.println();
		QUBKitchen.con.println("Updating " + currentName + ":");
		QUBKitchen.con.println("\nCurrent Name: " + currentName);
		boolean valid = false; // Marker for validation loop
		while (valid == false) {
			QUBKitchen.con.print("Input new name (or press enter to skip): ");
			String newName = (QUBKitchen.con.readLn()).trim();
			if (newName.equals("")) { // If user pressed enter - update is skipped
				valid = true;
			} else {
				if (Utility.isName(newName) && newName != null) {
					ingredientsList.get(updateIndex - 1).setName(newName);
					valid = true;
				} else {
					QUBKitchen.con.println("Invalid Data");
				}
			}
		}

		String currentFoodGroup = ingredientsList.get(updateIndex - 1).getFoodGroupStr(); // Food Group of ingredient
		QUBKitchen.con.println("\nCurrent Food Group: " + currentFoodGroup);
		boolean done = false; // Marker for validation loop
		do {
			QUBKitchen.con.print("Do you want to update Food Group? (Y/N):");
			String update = QUBKitchen.con.readLn();
			switch (update) {
			case "y":
			case "Y":
				FoodType newFoodGroup = ChooseFoodGroup(false);
				ingredientsList.get(updateIndex - 1).setFoodGroup(newFoodGroup);
				done = true;
				break;
			case "n":
			case "N":
				done = true; // Update skipped
				break;
			default:
				QUBKitchen.con.println("Input Y or N");
			}
		} while (done = false);

		int currentCalories = ingredientsList.get(updateIndex - 1).getCalories(); // Calories of ingredient
		QUBKitchen.con.println("\nCurrent calories: " + currentCalories);
		valid = false; // Marker for validation loop reset to false
		while (valid == false) {
			QUBKitchen.con.print("Input new calories (or press enter to skip): ");
			String newCalories = (QUBKitchen.con.readLn()).trim();
			if (newCalories.equals("")) { // If user pressed enter - update skipped
				valid = true;
			} else {
				if (Utility.isNumeric(newCalories) && newCalories != null) {
					if (Integer.parseInt(newCalories) > -1 && Integer.parseInt(newCalories) < 1000) {
						ingredientsList.get(updateIndex - 1).setCalories(Integer.parseInt(newCalories));
						valid = true;
					} else {
						QUBKitchen.con.println("Calories must be 0-999");
					}
				} else {
					QUBKitchen.con.println("Invalid Data");
				}
			}
		}

		for (int i = 0; i < (currentName.length() + 10); i++) {
			QUBKitchen.con.print("-");
		}
		QUBKitchen.con.println();

	}

	/**
	 * Deletes existing Ingredient <br>
	 * Confirms users intent to delete and removes ingredient from system
	 * 
	 * @param deleteIndex - Index of Ingredient to be deleted
	 */
	public static void DeleteIngredient(int deleteIndex) {
		String name = ingredientsList.get(deleteIndex - 1).getName();

		boolean done = false; // Marker for validation while loop
		do {
			QUBKitchen.con.print("Delete " + name + "? (Y/N): ");
			String sure = QUBKitchen.con.readLn();
			switch (sure) {
			case "Y":
			case "y":
				ingredientsList.remove(deleteIndex - 1);
				QUBKitchen.con.println(name + " deleted");
				done = true;
				break;
			case "N":
			case "n":
				QUBKitchen.con.println("Not deleted");
				done = true;
				break;
			default:
				QUBKitchen.con.println("Enter Y or N");
			}
		} while (done == false);
	}

	/**
	 * Inserts new Ingredient into ingredients list in alphabetical order by name
	 * <br>
	 * Comparing new ingredient to existing list to find its place
	 * 
	 * @param newIngredient - Ingredient to be inserted
	 */
	public static void InsertIntoIngredients(Ingredient newIngredient) {
		for (int i = 0; i < ingredientsList.size(); i++) { // For every element in list
			if ((newIngredient.getName()).compareTo((ingredientsList.get(i)).getName()) < 0) { // Compare new Name to
																								// name in list
				ingredientsList.add(i, newIngredient); // insert into list
				return;
			}
		}
		ingredientsList.add(newIngredient);
	}

	/**
	 * Adds new Ingredient <br>
	 * Prompts User for Ingredient information and uses them to construct new
	 * ingredient
	 * 
	 * @throws Exception
	 */
	public static void AddIngredient() throws Exception {
		DisplayTitle("Adding Ingredient");

		boolean valid = false; // Marker for validation loop
		String name = "";
		while (valid == false) {
			QUBKitchen.con.print("\nInput name: ");
			name = (QUBKitchen.con.readLn()).trim();
			if (name.length() > 0 && name != null && Utility.isName(name)) {
				valid = true;
			} else {
				QUBKitchen.con.println("Invalid Data - Name must be letters or characters /&,.'- ");
			}
		}

		FoodType foodGroup = ChooseFoodGroup(false);

		valid = false; // Marker for validation reset to false
		int calories = 0;
		while (valid == false) {
			QUBKitchen.con.print("\nInput calories(per 100g/100ml): ");
			String caloriesStr = QUBKitchen.con.readLn();
			if (Utility.isNumeric(caloriesStr)) {
				calories = Integer.parseInt(caloriesStr);
				if (calories > -1 && calories < 1000) {
					valid = true;
				} else {
					QUBKitchen.con.println("Invalid Data - Calories must be 0-999");
				}
			} else {
				QUBKitchen.con.println("Invalid Data - Calories must be 0-999");
			}
		}
		
		valid = false; // Marker for validation loop
		String fileName = "";
		while (valid == false) {
			QUBKitchen.con.print("\nInput name of image file (e.g. 'FileName.png'): ");
			fileName = (QUBKitchen.con.readLn()).trim();
			if (fileName.length() > 0 && fileName != null) {
				if (Utility.isFileName(fileName)) {
					valid = true;
				} else {
					QUBKitchen.con.println("Invalid Data - File name cannot contain spaces or characters: \\ / : | < > *");
				}
			} else {
				QUBKitchen.con.println("Invalid Data - File name cannot be null");
			}
		}

		Ingredient newIngredient = new Ingredient(name, foodGroup, calories, fileName);
		InsertIntoIngredients(newIngredient);
	}

	/**
	 * Display Meal type options to user and ask them to choose one
	 * 
	 * @return - chosen Meal Type
	 */
	public static MealType ChooseMealType(boolean goBack) {
		QUBKitchen.con.print("\nMeal Type options:\n" + "1. Starter\n" + "2. Main\n" + "3. Dessert");
		MealType mealType = MealType.UNDEFINED;
		boolean finished = false; // Marker for validation loop
		do {
			finished = true;
			if (goBack) {
				QUBKitchen.con.print("\nInput number of choice (or X to go back): ");
			} else {
				QUBKitchen.con.print("\nInput number of choice: ");
			}
			String typeInput = QUBKitchen.con.readLn();
			switch (typeInput) {
			case "1":
				mealType = MealType.STARTER;
				break;
			case "2":
				mealType = MealType.MAIN;
				break;
			case "3":
				mealType = MealType.DESSERT;
				break;
			case "x":
			case "X":
				if (goBack) {
					mealType = MealType.UNDEFINED;
					break;
				}
			default:
				QUBKitchen.con.println("Invalid Data - Choice must be 1-3");
				finished = false; // if invalid loop and ask again
			}
		} while (finished == false);

		return mealType;
	}

	/**
	 * Displays all information about a single recipe to the User
	 * 
	 * @param index - index of recipe to be displayed
	 */
	public static void ViewRecipe(int index) {
		Recipe recipe = recipesList.get(index - 1);

		String IDFormatted = String.format("%04d", (recipesList.get(index - 1)).getID()); // Pad left side with zeros to
																							// make ID 4 digits
		DisplayTitle(recipe.getName());
		
		String userdir = System.getProperty("user.dir");
		String path = userdir + recipe.getImgPath();
		System.out.println(recipe.getFileName());
		ImageIcon img = new ImageIcon(path);
		System.out.println(img.getIconHeight());
		if (img.getIconHeight() < 0) {
			System.out.println(path);
			path = userdir + "/images/Recipes/default.jpg";
			img = new ImageIcon(path);	
		}
		
		QUBKitchen.con.println("\nID: " + IDFormatted+"\n"
				+ recipe.getMealTypeStr() + "\n" + recipe.getPortions() + " Portion(s)" + "\n"
				+ String.format("%.2f", (recipe.totalCalories())) + " Calories per portion\n");
		
		QUBKitchen.con.println(img);
		
		QUBKitchen.con.println("\nIngredients:");
		for (int i = 0; i < recipe.getMeasurements().size(); i++) { // Print recipe's ingredients
			Measurement measurement = recipe.getMeasurements().get(i);
			QUBKitchen.con.println("• " + measurement.getIngredient().getName() + " - " + measurement.getAmount()
					+ measurement.getUnitStr());
		}
		QUBKitchen.con.println("\nMethod:"); // Print method steps
		for (int i = 0; i < recipe.getMethod().size(); i++) {
			QUBKitchen.con.println((i + 1) + "." + recipe.getMethod().get(i));
		}

		
	}

	/**
	 * Display's information about all recipes in a table <br>
	 * or displays all Recipes names
	 * 
	 * @param fullInfo - all information should be displayed
	 */
	public static void DisplayAllRecipes(boolean fullInfo) {
		if (fullInfo == true) {
			QUBKitchen.con.println("\n    ID   Name");
		}

		for (int i = 0; i < recipesList.size(); i++) {
			String indexFormatted = String.format("%1$-4s", ((i+1)+". ")); //Pad right side with spaces to make 4 chars
			if (fullInfo == true) {
				String IDFormatted = String.format("%04d", (recipesList.get(i)).getID()); // Pad left side of ID with
																							// zeros to make it four
																							// digits
				QUBKitchen.con.println(indexFormatted + IDFormatted + " " + recipesList.get(i).getName());
			} else {
				QUBKitchen.con.println(indexFormatted + recipesList.get(i).getName());
			}
		}
	}

	/**
	 * Display information about Recipes at Specified Indexes in a table
	 * 
	 * @param indexes - Indexes of Recipes to display
	 */
	public static void DisplaySpecificRecipe(ArrayList<Integer> indexes) {
		QUBKitchen.con.println("\n   ID   Name                      ");

		for (int i = 0; i < indexes.size(); i++) {
			String IDFormatted = String.format("%04d", (recipesList.get(indexes.get(i))).getID()); // Pad left side of
																									// ID with zeros to
																									// make it four
																									// digits
			QUBKitchen.con.println((i + 1) + ". " + IDFormatted + " " + recipesList.get(indexes.get(i)).getName());

		}
	}

	/**
	 * Search Recipes by ID
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchRecipes(int search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < recipesList.size(); i++) {
			if ((recipesList.get(i)).getID() == search) {
				results.add(i);
			}
		}
		return results;
	}

	/**
	 * Search Recipes by name/part name
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchRecipes(String search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < recipesList.size(); i++) {
			String currentName = ((recipesList.get(i)).getName()).toLowerCase();
			if (currentName.contains(search.toLowerCase())) {
				results.add(i);
			}
		}
		return results;
	}

	/**
	 * Search Recipes by meal type
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchRecipes(MealType search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		for (int i = 0; i < recipesList.size(); i++) {
			MealType currentType = (recipesList.get(i)).getMealType();
			if (currentType == search) {
				results.add(i);
			}
		}
		return results;
	}

	/**
	 * Search Recipes by Ingredient
	 * 
	 * @param search - term to search by
	 * @return - indexes containing matches
	 */
	public static ArrayList<Integer> SearchRecipes(Ingredient search) {
		ArrayList<Integer> results = new ArrayList<Integer>(); // List of all matching indexes
		ArrayList<Measurement> measurements = new ArrayList<Measurement>();
		for (int i = 0; i < recipesList.size(); i++) {
			measurements = recipesList.get(i).getMeasurements();
			for (int j = 0; j < measurements.size(); j++) {
				if (measurements.get(j).getIngredient() == search) {
					results.add(i);
					break;
				}
			}
		}
		return results;
	}

	/**
	 * Deletes existing Recipe <br>
	 * Confirms users intent to delete and removes recipe from system
	 * 
	 * @param deleteIndex - Index of Recipe to be deleted
	 */
	public static void DeleteRecipe(int deleteIndex) {
		String name = recipesList.get(deleteIndex - 1).getName();

		boolean done = false; // Marker for validation while loop
		do {
			QUBKitchen.con.print("Delete " + name + "? (Y/N): ");
			String sure = QUBKitchen.con.readLn();
			switch (sure) {
			case "Y":
			case "y":
				recipesList.remove(deleteIndex - 1);
				QUBKitchen.con.println(name + " deleted");
				done = true;
				break;
			case "N":
			case "n":
				QUBKitchen.con.println("Not deleted");
				done = true;
				break;
			default:
				QUBKitchen.con.println("Enter Y or N");
			}
		} while (done == false);

	}

	/**
	 * Inserts new Recipe into recipe list in alphabetical order by name <br>
	 * Comparing new recipe to existing list to find its place
	 * 
	 * @param newRecipe - Recipe to be inserted
	 */
	public static void InsertIntoRecipes(Recipe newRecipe) {
		for (int i = 0; i < recipesList.size(); i++) { // For every element in list
			if ((newRecipe.getName()).compareTo((recipesList.get(i)).getName()) < 0) { // Compare new Name to name in
																						// list
				recipesList.add(i, newRecipe); // insert into list
				return;
			}
		}
		recipesList.add(newRecipe);
	}

	/**
	 * Adds new Recipe <br>
	 * Prompts User for Recipe information and uses them to construct new recipe
	 * 
	 * @throws Exception
	 */
	public static void AddRecipe() throws Exception {
		DisplayTitle("Adding Recipe");

		boolean valid = false; // Marker for validation loop
		String name = "";
		while (valid == false) {
			QUBKitchen.con.print("\nInput name: ");
			name = (QUBKitchen.con.readLn()).trim();
			if (name.length() > 0 && name != null) {
				if (Utility.isName(name)) {
					valid = true;
				} else {
					QUBKitchen.con.println("Name must be letters or characters: /&,.'- ");
				}
			} else {
				QUBKitchen.con.println("Name cannot be blank or null");
			}
		}

		MealType mealType = ChooseMealType(false);

		valid = false; // Marker for validation loop reset to false
		int portions = 0;
		while (valid == false) {
			QUBKitchen.con.print("\nInput number of portions: ");
			String portionsStr = QUBKitchen.con.readLn();
			if (Utility.isNumeric(portionsStr)) {
				portions = Integer.parseInt(portionsStr);
				if (portions > -1 && portions < 100) {
					valid = true;
				} else {
					QUBKitchen.con.println("Portion size must be between 0 and 99");
				}
			} else {
				QUBKitchen.con.println("Portion size must be a number");
			}
		}

		ArrayList<Measurement> measurements = new ArrayList<Measurement>();
		QUBKitchen.con.println("\n------------------------------");
		QUBKitchen.con.println("Adding ingredient measurements\n");
		boolean finished = false; // Marker to loop until user is done adding measurements
		while (finished == false) {

			QUBKitchen.con.println("Choose Ingredient:");
			DisplayAllIngredients(false);

			Ingredient ingredient = null;
			do {
				valid = false; // Marker for validation loop
				QUBKitchen.con.print("Choose an ingredient: ");
				String ingredientIndexStr = QUBKitchen.con.readLn();
				if (Utility.isNumeric(ingredientIndexStr)) {
					int ingredientIndex = Integer.parseInt(ingredientIndexStr);
					if (ingredientIndex > 0 && ingredientIndex < Application.ingredientsList.size()) {
						ingredient = Application.ingredientsList.get(ingredientIndex - 1);
						valid = true;
					} else {
						QUBKitchen.con.println("Invalid option");
					}
				} else {
					QUBKitchen.con.println("Invalid option");
				}
			} while (valid = false);

			int amount = 0;
			Unit unit = Unit.UNDEFINED;
			do {
				valid = false; // Marker for validation reset to false
				QUBKitchen.con.print("Input measurement in g or ml (eg. 400 g /350 ml): ");
				String measurement = QUBKitchen.con.readLn();
				if (Utility.isMeasurement(measurement)) {
					String[] measurementDetails = measurement.split(" ");
					amount = Integer.parseInt(measurementDetails[0]);
					String unitStr = measurementDetails[1];
					switch (unitStr) {
					case "g":
						unit = Unit.GRAMS;
						valid = true;
						break;
					case "ml":
						unit = Unit.MILLILITRES;
						valid = true;
						break;
					default:
						QUBKitchen.con.println("Unit must be 'g' or 'ml'");
					}
				} else {
					QUBKitchen.con.println("Incorrect format");
				}
			} while (valid == false);

			Measurement newMeasurement = new Measurement(ingredient, amount, unit);
			measurements.add(newMeasurement);

			boolean done = false; // marker for validation loop
			do {
				QUBKitchen.con.print("\nAdd another ingredient? (Y/N): ");
				String choice = QUBKitchen.con.readLn();
				switch (choice) {
				case "Y":
				case "y":
					done = true;
					break;
				case "N":
				case "n":
					finished = true; // Jump out of both loops and move onto method
					done = true;
					break;
				default:
					QUBKitchen.con.println("Enter Y or N");
				}
			} while (done == false);

			QUBKitchen.con.println("------------------------------");

			ArrayList<String> method = new ArrayList<String>();
			QUBKitchen.con.println("\n-------------");
			QUBKitchen.con.println("Adding Method\n");
			finished = false; // Marker to loop until user is done adding steps
			while (finished == false) {
				valid = false; // marker for validation loop
				String step = "";
				do {
					QUBKitchen.con.print("Write Step: ");
					step = QUBKitchen.con.readLn();
					if (step.length() < 0 || step.length() > 100) {
						QUBKitchen.con.println("Step must be between 0 and 100 characters");
					} else {
						method.add(step);
						valid = true;
					}
				} while (valid = false);

				done = false;
				do {
					QUBKitchen.con.print("\nAdd another step? (Y/N): ");
					String choice = QUBKitchen.con.readLn();
					switch (choice) {
					case "Y":
					case "y":
						done = true;
						break;
					case "N":
					case "n":
						finished = true; // Jump out of both loops
						done = true;
						break;
					default:
						QUBKitchen.con.println("Enter Y or N");
					}
				} while (done == false);
			}
			
			valid = false; // Marker for validation loop
			String fileName = "";
			while (valid == false) {
				QUBKitchen.con.print("\nInput name of image file (e.g. 'FileName.png'): ");
				fileName = (QUBKitchen.con.readLn()).trim();
				if (fileName.length() > 0 && fileName != null) {
					if (Utility.isFileName(fileName)) {
						valid = true;
					} else {
						QUBKitchen.con.println("Invalid Data - File name cannot contain spaces or characters: \\ / : | < > *");
					}
				} else {
					QUBKitchen.con.println("Invalid Data - File name cannot be null");
				}
			}
			QUBKitchen.con.println("-------------");

			Recipe newRecipe = new Recipe(name, mealType, portions, measurements, method, fileName);
			InsertIntoRecipes(newRecipe);
		}
	}

	/**
	 * Creates Weekly Menu <br>
	 * Prompts User for recipes on every day and course and add these to the weekly
	 * menu
	 * 
	 * @throws Exception
	 */
	public static void CreateMenu() throws Exception {
		QUBKitchen.con.println("\n--------------------------------------");
		QUBKitchen.con.println("Creating Weekly Menu:");

		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
		String[] courses = { "Starter", "Main", "Desert" };

		for (int i = 0; i < 5; i++) { // For every day
			QUBKitchen.con.println("\n\n-" + days[i] + "-");
			QUBKitchen.con.println("\nRecipes:");
			DisplayAllRecipes(false);
			QUBKitchen.con.println((recipesList.size() + 1) + ". Leave Empty\n");

			for (int j = 0; j < 3; j++) { // For every course
				boolean valid = false; // Marker for validation loop
				do {
					QUBKitchen.con.print("Choose " + courses[j] + ": ");
					String choiceStr = QUBKitchen.con.readLn();
					if (Utility.isNumeric(choiceStr)) {
						int choice = Integer.parseInt(choiceStr);
						if (choice > 0 && choice < (recipesList.size() + 2)) {
							valid = true;
							if (choice == (recipesList.size() + 1)) {
								weeklyMenu.removeRecipe((i + 1), (j + 1));
							} else {
								weeklyMenu.addRecipe(recipesList.get(choice - 1), (i + 1), (j + 1));
							}
						} else {
							QUBKitchen.con.println("Invalid option");
						}
					} else {
						QUBKitchen.con.println("Invalid option");
					}
				} while (valid == false);
			}
		}
		QUBKitchen.con.println("--------------------------------------");
		QUBKitchen.WeeklyMenu();
	}

	/**
	 * Lets User pick day and course in weekly menu <br>
	 * Displays days and courses and prompts user for input
	 * 
	 * @return - day and course as an integer array with two elements {day, course}
	 */
	public static int[] MenuChooseMeal() {
		QUBKitchen.con.println(
				"Choose day:" + "\n1. Monday" + "\n2. Tuesday" + "\n3. Wednesday" + "\n4. Thursday" + "\n5. Friday");
		boolean valid = false; // Marker for validation loop
		int day = 0;
		do {
			valid = false;
			QUBKitchen.con.print("Enter Choice: ");
			String dayStr = QUBKitchen.con.readLn();
			if (Utility.isNumeric(dayStr)) {
				day = Integer.parseInt(dayStr);
				if (day < 6 && day > 0) {
					valid = true;
				} else {
					QUBKitchen.con.println("Invalid option");
				}
			} else {
				QUBKitchen.con.println("Invalid option");
			}
			System.out.println(valid);
		} while (valid == false);

		QUBKitchen.con.println("\nChoose course:" + "\n1. Starter" + "\n2. Main" + "\n3. Dessert");
		valid = false; // Validation marker reset to false
		int course = 0;
		do {
			valid = false;
			QUBKitchen.con.print("Enter Choice: ");
			String courseStr = QUBKitchen.con.readLn();
			if (Utility.isNumeric(courseStr)) {
				course = Integer.parseInt(courseStr);
				if (course < 4 && course > 0) {
					valid = true;
				} else {
					QUBKitchen.con.println("Invalid option");
				}
			} else {
				QUBKitchen.con.println("Invalid option");
			}
		} while (valid == false);

		int[] array = { day, course };
		return array;

	}
}