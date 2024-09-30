package part02;

import part01.FoodType;
import part01.Ingredient;
import part01.MealType;
import part01.Measurement;
import part01.Recipe;
import part01.Unit;
import part01.WeeklyMenu;

public class Initialise {
	
	public static Recipe getRecipe() throws Exception {

		Ingredient whiteBread = new Ingredient("White Bread", FoodType.NUTRIENT, 265);
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient garlic = new Ingredient("Garlic", FoodType.CEREAL, 111);
		Ingredient butter = new Ingredient("Butter", FoodType.DAIRY, 717);

		Measurement[] measurementsArray1 = { new Measurement(whiteBread, 4 * 38, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(garlic, 2 * 6, Unit.GRAMS) };
		String[] methodArray1 = { "Preheat oven to 180°C (350°F).", "In a bowl, mix butter and minced garlic.",
				"Spread the garlic butter on one side of each bread slice.",
				"Sprinkle grated cheese on top and bake until the cheese is melted and bread is toasted." };
		Recipe garlicBread = new Recipe("Garlic Bread", MealType.STARTER, 4, measurementsArray1, methodArray1);
		return garlicBread;
	}
	

	public static WeeklyMenu fillMenu(WeeklyMenu weeklyMenu) throws Exception {
		Ingredient apples = new Ingredient("Apples", FoodType.FRUITVEG, 52);
		Ingredient bakedBeans = new Ingredient("Baked Beans", FoodType.COMP, 155);
		Ingredient bakingPowder = new Ingredient("Baking Powder", FoodType.COMP, 20);
		Ingredient bellPeppers = new Ingredient("Bell Peppers", FoodType.FRUITVEG, 20);
		Ingredient butter = new Ingredient("Butter", FoodType.DAIRY, 717);
		Ingredient celery = new Ingredient("Celery", FoodType.FRUITVEG, 8);
		Ingredient cheese = new Ingredient("Cheese", FoodType.DAIRY, 402);
		Ingredient chicken = new Ingredient("Chicken", FoodType.PROTEIN, 165);
		Ingredient cinnamon = new Ingredient("Cinnamon", FoodType.SPICEHERB, 3);
		Ingredient eggs = new Ingredient("Eggs", FoodType.DAIRY, 155);
		Ingredient flour = new Ingredient("Flour", FoodType.CEREAL, 364);
		Ingredient garlic = new Ingredient("Garlic", FoodType.CEREAL, 111);
		Ingredient groundBeef = new Ingredient("Ground Beef", FoodType.FRUITVEG, 332);
		Ingredient honey = new Ingredient("Honey", FoodType.SUGAR, 20);
		Ingredient jam = new Ingredient("Jam", FoodType.PROTEIN, 278);
		Ingredient leeks = new Ingredient("Leeks", FoodType.SUGAR, 61);
		Ingredient lettuce = new Ingredient("Lettuce", FoodType.FRUITVEG, 15);
		Ingredient milk = new Ingredient("Milk", FoodType.DAIRY, 42);
		Ingredient mushrooms = new Ingredient("Mushrooms", FoodType.FRUITVEG, 20);
		Ingredient oliveOil = new Ingredient("Olive Oil", FoodType.DAIRY, 884);
		Ingredient onion = new Ingredient("Onion", FoodType.FAT, 40);
		Ingredient pennePasta = new Ingredient("Penne Pasta", FoodType.FRUITVEG, 118);
		Ingredient pepper = new Ingredient("Pepper", FoodType.COMP, 20);
		Ingredient potatoes = new Ingredient("Potatoes", FoodType.SPICEHERB, 75);
		Ingredient puffPastry = new Ingredient("Puff Pastry", FoodType.NUTRIENT, 320);
		Ingredient salt = new Ingredient("Salt", FoodType.FRUITVEG, 0);
		Ingredient stockCubes = new Ingredient("Stock Cubes", FoodType.NUTRIENT, 438);
		Ingredient sugar = new Ingredient("Sugar", FoodType.COMP, 387);
		Ingredient tomatoes = new Ingredient("Tomatoes", FoodType.SUGAR, 19);
		Ingredient water = new Ingredient("Water", FoodType.FRUITVEG, 0);
		Ingredient whiteBread = new Ingredient("White Bread", FoodType.NUTRIENT, 265);
		Ingredient whiteRice = new Ingredient("White Rice", FoodType.CEREAL, 364);

		// Initialising Recipes and adding to weeklyMenu
		Measurement[] measurementsArray1 = { new Measurement(whiteBread, 4 * 38, Unit.GRAMS),
				new Measurement(cheese, 100, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(garlic, 2 * 6, Unit.GRAMS) };
		String[] methodArray1 = { "Preheat oven to 180°C (350°F).", "In a bowl, mix butter and minced garlic.",
				"Spread the garlic butter on one side of each bread slice.",
				"Sprinkle grated cheese on top and bake until the cheese is melted and bread is toasted." };
		Recipe garlicBread = new Recipe("Garlic Bread", MealType.STARTER, 4, measurementsArray1, methodArray1);
		weeklyMenu.addRecipe(garlicBread, 1, 1);

		Measurement[] measurementsArray2 = { new Measurement(mushrooms, 200, Unit.GRAMS),
				new Measurement(garlic, 12, Unit.GRAMS), new Measurement(cheese, 50, Unit.GRAMS),
				new Measurement(oliveOil, 30, Unit.MILLILITRES), new Measurement(salt, 3, Unit.GRAMS),
				new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray2 = { "Preheat the oven to 180°C (350°F).",
				"In a bowl, mix minced garlic, grated cheese, salt, and pepper.",
				"Stuff each mushroom cap with the garlic and cheese mixture.",
				"Drizzle olive oil over the mushrooms and bake in the preheated oven until the tops are golden and bubbly." };
		Recipe stuffedGarlicButterMushrooms = new Recipe("Stuffed Garlic Butter Mushrooms", MealType.STARTER, 4,
				measurementsArray2, methodArray2);
		weeklyMenu.addRecipe(stuffedGarlicButterMushrooms, 2, 1);

		Measurement[] measurementsArray3 = { new Measurement(groundBeef, 250, Unit.GRAMS),
				new Measurement(onion, 200, Unit.GRAMS), new Measurement(garlic, 12, Unit.GRAMS),
				new Measurement(lettuce, 64, Unit.GRAMS), new Measurement(salt, 3, Unit.GRAMS) };
		String[] methodArray3 = { "In a pan, brown the ground beef with chopped onions and minced garlic.",
				"Season with salt and pepper to taste.",
				"Spoon the cooked beef mixture onto individual lettuce leaves.", "Serve as an appetizer or snack." };
		Recipe lettuceWrapsWithGroundBeef = new Recipe("Lettuce Wraps with Ground Beef", MealType.STARTER, 4,
				measurementsArray3, methodArray3);
		weeklyMenu.addRecipe(lettuceWrapsWithGroundBeef, 3, 1);

		Measurement[] measurementsArray4 = { new Measurement(tomatoes, 200, Unit.GRAMS),
				new Measurement(leeks, 300, Unit.GRAMS), new Measurement(oliveOil, 30, Unit.MILLILITRES),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS),
				new Measurement(whiteBread, 120, Unit.GRAMS) };
		String[] methodArray4 = { "In a bowl, combine diced tomatoes, sliced leeks, olive oil, salt, and pepper.",
				"Toast slices of white bread.", "Spoon the tomato and leek mixture onto the toasted bread slices.",
				"Serve as a refreshing bruschetta." };
		Recipe tomatoAndLeekBruschetta = new Recipe("Tomato and Leek Bruschetta", MealType.STARTER, 4,
				measurementsArray4, methodArray4);
		weeklyMenu.addRecipe(tomatoAndLeekBruschetta, 4, 1);

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
				4, measurementsArray5, methodArray5);
		weeklyMenu.addRecipe(celeryAndCheeseStuffedPotatoes, 5, 1);

		Measurement[] measurementsArray6 = { new Measurement(potatoes, 500, Unit.GRAMS),
				new Measurement(leeks, 200, Unit.GRAMS), new Measurement(onion, 200, Unit.GRAMS),
				new Measurement(garlic, 12, Unit.GRAMS), new Measurement(butter, 50, Unit.GRAMS),
				new Measurement(stockCubes, 12, Unit.GRAMS), new Measurement(water, 1000, Unit.MILLILITRES),
				new Measurement(salt, 3, Unit.GRAMS), new Measurement(pepper, 3, Unit.GRAMS) };
		String[] methodArray6 = { "In a large pot, melt butter and sauté onions and garlic until translucent.",
				"Add leeks and potatoes, cook for 5 minutes.",
				"Dissolve stock cubes in water and add to the pot. Season with salt and pepper.",
				"Simmer until potatoes are tender. Use a blender to puree the soup until smooth." };
		Recipe potatoLeekSoup = new Recipe("Potato Leek Soup", MealType.MAIN, 4, measurementsArray6, methodArray6);
		weeklyMenu.addRecipe(potatoLeekSoup, 1, 2);

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
				methodArray7);
		weeklyMenu.addRecipe(cheesyBakedPennePasta, 2, 2);

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
				measurementsArray8, methodArray8);
		weeklyMenu.addRecipe(beefAndLeekPastaBake, 3, 2);

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
				methodArray9);
		weeklyMenu.addRecipe(appleJamGlazedChicken, 4, 2);

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
				methodArray10);
		weeklyMenu.addRecipe(eggOnionFriedRice, 5, 2);

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
				measurementsArray11, methodArray11);
		weeklyMenu.addRecipe(appleJamThumbprintCookies, 4, 3);

		Measurement[] measurementsArray12 = { new Measurement(flour, 250, Unit.GRAMS),
				new Measurement(eggs, 120, Unit.GRAMS), new Measurement(milk, 250, Unit.MILLILITRES),
				new Measurement(cheese, 150, Unit.GRAMS), new Measurement(jam, 120, Unit.GRAMS),
				new Measurement(butter, 20, Unit.GRAMS) };
		String[] methodArray12 = { "In a bowl, whisk together flour, eggs, and milk to make crepe batter.",
				"Cook thin crepes in a hot, buttered pan.",
				"Place a slice of cheese and a spoonful of jam in the center of each crepe.",
				"Fold the crepes and serve." };
		Recipe cheeseJamStuffedCrepes = new Recipe("Cheese and Jam Stuffed Crepes", MealType.DESSERT, 4,
				measurementsArray12, methodArray12);
		weeklyMenu.addRecipe(cheeseJamStuffedCrepes, 5, 3);

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
				measurementsArray13, methodArray13);
		weeklyMenu.addRecipe(appleCinnamonMuffins, 1, 3);

		Measurement[] measurementsArray14 = { new Measurement(puffPastry, 320, Unit.GRAMS),
				new Measurement(apples, 300, Unit.GRAMS), new Measurement(cheese, 100, Unit.GRAMS),
				new Measurement(jam, 100, Unit.GRAMS), new Measurement(honey, 20, Unit.MILLILITRES) };
		String[] methodArray14 = { "Preheat the oven to 200°C (400°F).",
				"Cut the puff pastry into squares and place them on a baking sheet.",
				"Layer sliced apples, grated cheese, and a small spoonful of jam on each square.",
				"Bake until the pastry is golden brown.", "Drizzle with honey before serving." };
		Recipe cheeseAndAppleTartlets = new Recipe("Cheese and Apple Tartlets", MealType.DESSERT, 12,
				measurementsArray14, methodArray14);
		weeklyMenu.addRecipe(cheeseAndAppleTartlets, 2, 3);

		Measurement[] measurementsArray15 = { new Measurement(puffPastry, 320, Unit.GRAMS),
				new Measurement(apples, 300, Unit.GRAMS), new Measurement(sugar, 30, Unit.GRAMS),
				new Measurement(cinnamon, 15, Unit.GRAMS), new Measurement(honey, 20, Unit.MILLILITRES) };
		String[] methodArray15 = { "Preheat the oven to 200°C (400°F).",
				"Roll out the puff pastry and sprinkle diced apples, sugar, and cinnamon evenly.",
				"Roll the pastry into a log and slice into rounds.",
				"Place the rounds on a baking sheet and bake until golden.", "Drizzle with honey before serving." };
		Recipe cinnamonApplePastryRolls = new Recipe("Cinnamon Apple Pastry Rolls", MealType.DESSERT, 12,
				measurementsArray15, methodArray15);
		weeklyMenu.addRecipe(cinnamonApplePastryRolls, 3, 3);

		return weeklyMenu;
	}
}
