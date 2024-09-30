package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import console.Console;

/**
 * Main program file <br>
 * Provides all menus displayed to the user
 * 
 * @author Hannah Dennis - 40406567
 */
public class QUBKitchen {

	public static Console con = new Console(true);

	/**
	 * Starting point for Application <br>
	 * Displays Main Menu to user
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// define the console
		con.setSize(800, 600);
		con.setVisible(true);

		// set background colour for console
		con.setBgColour(Color.LIGHT_GRAY);

		Application.initialiseQUBKitchen();

		String[] mainOptions = { "Manage Ingredients", "Manage Recipes", "Manage Weekly Menu", "Exit" }; // Main menu
																											// option
		Menu main = new Menu("QUBKitchen", mainOptions);
		boolean finished = false; // Marker to escape loop
		do {
			String choice = main.getUserChoice();
			switch (choice) {
			case "1":
				IngredientsMain();
				break;
			case "2":
				RecipesMain();
				break;
			case "3":
				WeeklyMenu();
				break;
			case "4":
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);

		System.exit(1);

	}

	/**
	 * Displays menu for Managing Ingredients to User <br>
	 * Including functionality to View, Search, Add, Update and Delete
	 * 
	 * @throws Exception
	 */
	public static void IngredientsMain() throws Exception {
		String[] ingredientOptions = { "View All", "Search", "Add", "Update", "Delete", "Back" };
		Menu ingredients = new Menu("Manage Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			String choice = ingredients.getUserChoice();
			switch (choice) {
			case "1": // Displays all ingredients
				con.clear();
				Application.DisplayTitle("All Ingredients");
				Application.DisplayAllIngredients(true);
				con.print("\nPress Enter to Exit: ");
				con.readLn();
				break;
			case "2": // Go to Search ingredients menu
				IngredientsSearch();
				break;
			case "3": // Add Ingredient
				Application.AddIngredient();
				break;
			case "4": // Update Ingredients
				String toBeUpdated = "";
				while (!toBeUpdated.equalsIgnoreCase("X")) {
					Application.DisplayTitle("Update Ingredients");
					con.println();
					Application.DisplayAllIngredients(false);
					boolean valid = false; // Marker for validation loop
					do {
						con.print("\nChoose an ingredient to update (or X to go back): ");
						toBeUpdated = con.readLn();
						if (toBeUpdated.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(toBeUpdated)) {
							int updateInt = Integer.parseInt(toBeUpdated);
							if (updateInt > 0 && updateInt < Application.ingredientsList.size() + 1) {
								Application.UpdateIngredient(updateInt);
								valid = true;
							} else {
								con.println("Invalid option");
							}
						} else {
							con.println("Invalid option");
						}
					} while (valid == false);
					con.println();
				}
				;
				break;
			case "5": // Delete Ingredients

				String toBeDeleted = "";
				do {
					Application.DisplayTitle("Delete Ingredients");
					con.println();
					Application.DisplayAllIngredients(false);
					boolean valid = false; // Marker for validation loop
					do {
						con.print("\nChoose an ingredient to delete (or X to go back): ");
						toBeDeleted = con.readLn();
						if (toBeDeleted.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(toBeDeleted)) {
							int deleteInt = Integer.parseInt(toBeDeleted);
							if (deleteInt > 0 && deleteInt < Application.ingredientsList.size() + 1) {
								Application.DeleteIngredient(deleteInt);
								valid = true;
							} else {
								con.println("Invalid option");
							}
						} else {
							con.println("Invalid option");
						}
					} while (valid == false);
					con.println();
				} while (!toBeDeleted.equalsIgnoreCase("X"));

				break;
			case "6": // Go back to main menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Searching Ingredients to User <br>
	 * Including functionality to search by ID, Name, Food Group
	 * 
	 * @throws Exception
	 */
	public static void IngredientsSearch() {
		String[] ingredientOptions = { "Search by ID", "Search by Name/Part Name", "Search by Food Group", "Back" };
		Menu ingredients = new Menu("Search Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			String choice = ingredients.getUserChoice();
			switch (choice) {
			case "1": // Search by ID
				Application.DisplayTitle("Searching by ID");

				con.print("\nInput search (or X to go back): ");
				String search = con.readLn();
				while (!search.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					if (Utility.isNumeric(search)) {
						indexes = Application.SearchIngredients(Integer.parseInt(search)); // get indexes of all matches
						if (indexes.size() < 1) {
							con.println("\nNo Matching Results");
						} else {
							Application.DisplaySpecificIngredients(indexes);
						}
					} else {
						con.println("Invalid input - must be integer");
					}

					con.print("\nInput search (or X to go back): ");
					search = con.readLn();
				}
				break;
			case "2": // Search by Name
				Application.DisplayTitle("Searching by Name/Part Name");
				con.print("\nInput search (or X to go back): ");
				search = con.readLn();
				while (!search.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchIngredients(search); // get indexes of all matches
					if (indexes.size() < 1) {
						con.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificIngredients(indexes);
					}

					con.print("\nInput search (or X to go back): ");
					search = con.readLn();
				}
				break;
			case "3":
				Application.DisplayTitle("Searching by Food Group");
				FoodType searchFT = Application.ChooseFoodGroup(true);
				con.println(searchFT);
				while (searchFT != FoodType.UNDEFINED) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchIngredients(searchFT); // get indexes of all matches
					if (indexes.size() < 1) {
						con.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificIngredients(indexes);
					}
					searchFT = Application.ChooseFoodGroup(true);
				}
				break;
			case "4": // back to manage ingredients
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);

	}

	/**
	 * Displays menu for Managing Recipes to User <br>
	 * Including functionality to view, search, add, update and delete
	 * 
	 * @throws Exception
	 */
	public static void RecipesMain() throws Exception {
		String[] ingredientOptions = { "View All", "Search", "Add", "Update", "Delete", "Back" };
		Menu ingredients = new Menu("Manage Recipes", ingredientOptions);
		boolean finished = false;
		do {
			String choice = ingredients.getUserChoice();
			switch (choice) {
			case "1": // View all recipes and allow user to choose one to see full recipe
				String recipeChoice = "";
				do {
					Application.DisplayTitle("All Recipes");
					con.println();
					Application.DisplayAllRecipes(true);
					con.print("\nChoose a recipe to view (or X to go back): ");
					recipeChoice = con.readLn();
					boolean valid = false; // marker for validation loop
					do {
						if (!recipeChoice.equalsIgnoreCase("X")) {
							if (Utility.isNumeric(recipeChoice)) {
								if (Integer.parseInt(recipeChoice) > 0
										&& Integer.parseInt(recipeChoice) < Application.recipesList.size() + 1) {
									valid = true;
									Application.ViewRecipe(Integer.parseInt(recipeChoice));
									con.print("\nPress Enter to Return: ");
									con.readLn();
								} else {
									con.println("Invalid option");
								}
							} else {
								con.println("Invalid option");
							}
						} else {
							break;
						}
					} while (valid == false);
				} while (!recipeChoice.equalsIgnoreCase("X"));
				break;
			case "2": // Go to recipe search menu
				RecipesSearch();
				break;
			case "3": // Add recipe
				Application.AddRecipe();
				break;
			case "4": // Choose recipe to update and go to update menu
				String toBeUpdated = "";
				do {
					Application.DisplayTitle("Update Recipes\n");
					Application.DisplayAllRecipes(false);
					boolean valid = false; // Marker for validation loop
					do {
						con.print("\nChoose a recipe to update (or X to go back): ");
						toBeUpdated = con.readLn();
						if (toBeUpdated.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(toBeUpdated)) {
							int updateInt = Integer.parseInt(toBeUpdated);
							if (updateInt > 0 && updateInt < Application.ingredientsList.size() + 1) {
								RecipesUpdate(Application.recipesList.get(updateInt - 1), updateInt);
								valid = true;
							} else {
								con.println("Invalid option");
							}
						} else {
							con.println("Invalid option");
						}
					} while (valid == false);
					con.println();
				} while (!toBeUpdated.equalsIgnoreCase("X"));

				break;
			case "5": // Delete recipe
				String toBeDeleted = "";
				do {
					Application.DisplayTitle("Delete Recipes\n");
					Application.DisplayAllRecipes(false);
					 boolean valid = false; // Marker for validation loop
					do {
						con.print("\nChoose a recipe to delete (or X to go back): ");
						toBeDeleted = con.readLn();
						if (toBeDeleted.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(toBeDeleted)) {
							int deleteInt = Integer.parseInt(toBeDeleted);
							if (deleteInt > 0 && deleteInt < Application.ingredientsList.size() + 1) {
								Application.DeleteRecipe(Integer.parseInt(toBeDeleted));
								valid = true;
							} else {
								con.println("Invalid option");
							}
						} else {
							con.println("Invalid option");
						}
					} while (valid == false);
					con.println();
				} while (!toBeDeleted.equalsIgnoreCase("X"));

				break;
			case "6": // back to main menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Updating Recipes to User <br>
	 * Including functionality to update name, meal type, portions, ingredients and
	 * method
	 * 
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdate(Recipe recipe, int updateInt) throws Exception {
		String[] updateOptions = { "Name", "Meal Type", "Portions", "Ingredients", "Method", "Back" };
		Menu update = new Menu("Fields to Update", updateOptions);
		boolean finished = false;
		do {
			Application.ViewRecipe(updateInt);
			con.println("\n\t\t\t\t----------------");

			QUBKitchen.con.setFont(new Font("Monospaced", Font.BOLD, 18));
			QUBKitchen.con.println("\nFields to Update:");

			QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));
			String choice = update.getUserChoice(false);
			switch (choice) {
			case "1": // Input new Name
				con.println("------------------");
				String currentName = recipe.getName();
				con.println("Current Name: " + currentName);
				boolean valid = false;
				do {
					con.print("Input new name: ");
					String newName = (con.readLn()).trim();
					if (newName != "") {
						if (Utility.isName(newName)) {
							recipe.setName(newName);
							valid = true;
						} else {
							con.println("Name must be letters or characters: /&,.'- ");
						}
					} else {
						con.println("Name is a required field");
					}
				} while (valid == false);
				con.println("------------------");
				break;
			case "2": // Input new mealType
				con.println("------------------");
				String currentMealType = recipe.getMealTypeStr();
				con.println("Current Food Group: " + currentMealType);
				MealType newMealType = Application.ChooseMealType(false);
				recipe.setMealType(newMealType);
				con.println("------------------");
				break;
			case "3": // Input new portion size
				con.println("------------------");
				int currentPortions = recipe.getPortions();
				con.println("\nCurrent portions: " + currentPortions);
				valid = false;
				while (valid == false) {
					con.print("Input new portions: ");
					String newPortions = (con.readLn()).trim();
					if (Utility.isNumeric(newPortions) && newPortions != null) {
						if (Integer.parseInt(newPortions) > 0 && Integer.parseInt(newPortions) < 99) {
							recipe.setPortions(Integer.parseInt(newPortions));
							valid = true;
						} else {
							con.println("Portions must be between 0 and 99");
						}
					} else {
						con.println("Portions must be a number");
					}
				}
				con.println("------------------");
				break;
			case "4": // Go to update ingredients menu
				RecipesUpdateIngredients(recipe);
				break;
			case "5": // Go to update method menu
				RecipesUpdateMethod(recipe);
				break;
			case "6": // Back to Managing Ingredients Menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Updating Recipe Ingredients to User <br>
	 * Including functionality to add, update or delete ingredients from a recipe
	 * 
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdateIngredients(Recipe recipe) throws Exception {
		String[] ingredientOptions = { "Add an Ingredient", "Update Amount of Ingredient", "Remove Ingredient",
				"Back" };
		Menu ingredients = new Menu("Update Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			Application.DisplayTitle("Update Ingredients");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.BOLD, 18));
			con.println("\nIngredients: ");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));
			for (int i = 0; i < recipe.getMeasurements().size(); i++) {
				Measurement temp = recipe.getMeasurements().get(i);
				con.println("• " + temp.getIngredient().getName() + " - " + temp.getAmount() + temp.getUnitStr());
			}
			con.println("\n\t\t\t\t----------------\n");

			String choice = ingredients.getUserChoice(false);
			switch (choice) {
			case "1": // Add new Measurement
				con.println("------------------");
				con.println("Choose Ingredient:");
				Application.DisplayAllIngredients(false);

				Ingredient ingredient = null;
				boolean valid = false;
				do {
					con.print("Choose an ingredient: ");
					String ingredientIndexStr = con.readLn();
					if (Utility.isNumeric(ingredientIndexStr)) {
						int ingredientIndex = Integer.parseInt(ingredientIndexStr);
						if (ingredientIndex > 0 && ingredientIndex < Application.ingredientsList.size()) {
							ingredient = Application.ingredientsList.get(ingredientIndex - 1);
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				} while (valid = false);

				int amount = 0;
				Unit unit = Unit.UNDEFINED;
				do {
					valid = false;
					con.print("Input measurement in g or ml (eg. 400 g /350 ml): ");
					String measurement = con.readLn();
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
							con.println("Unit must be 'g' or 'ml'");
						}
					} else {
						con.println("Incorrect format");
					}
				} while (valid == false);

				Measurement newMeasurement = new Measurement(ingredient, amount, unit);
				recipe.addMeasurement(newMeasurement);
				con.println("------------------");
				break;
			case "2": // Update Existing Measurement
				con.println("------------------");
				con.println("Choose measurement to Update: ");
				for (int i = 0; i < recipe.getMeasurements().size(); i++) {
					Measurement temp = recipe.getMeasurements().get(i);
					con.println((i + 1) + ". " + temp.getIngredient().getName() + " - " + temp.getAmount()
							+ temp.getUnitStr());
				}
				int measurementChoice = -1;
				valid = false;
				do {
					con.print("Input choice: ");
					String measurementChoiceStr = con.readLn();
					if (Utility.isNumeric(measurementChoiceStr)) {
						measurementChoice = Integer.parseInt(measurementChoiceStr);
						if (measurementChoice <= recipe.getMeasurements().size() && measurementChoice > 0) {
							valid = true;
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				} while (valid == false);

				Measurement measurementToUpdate = recipe.getMeasurements().get(measurementChoice - 1);

				amount = 0;
				unit = Unit.UNDEFINED;
				do {
					con.print("Input measurement in g or ml (eg. 400 g /350 ml): ");
					String measurement = con.readLn();
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
							con.println("Unit must be 'g' or 'ml'");
						}
					} else {
						con.println("Incorrect format");
					}
				} while (valid == false);

				measurementToUpdate.setAmount(amount);
				measurementToUpdate.setUnit(unit);
				con.println("------------------");
				break;

			case "3": // Delete a measurement
				con.println("------------------");
				con.println("Choose measurement to Delete: ");
				for (int i = 0; i < recipe.getMeasurements().size(); i++) {
					Measurement temp = recipe.getMeasurements().get(i);
					con.println((i + 1) + ". " + temp.getIngredient().getName() + " - " + temp.getAmount()
							+ temp.getUnitStr());
				}
				measurementChoice = -1;
				valid = false;
				do {
					con.print("Input choice: ");
					String measurementChoiceStr = con.readLn();
					if (Utility.isNumeric(measurementChoiceStr)) {
						measurementChoice = Integer.parseInt(measurementChoiceStr);
						if (measurementChoice <= recipe.getMeasurements().size() && measurementChoice > 0) {
							valid = true;
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				} while (valid == false);

				String name = recipe.getMeasurements().get(measurementChoice - 1).getIngredient().getName();
				boolean done = false;
				do {
					con.print("Remove " + name + "? (Y/N): ");
					String sure = con.readLn();
					switch (sure) {
					case "Y":
					case "y":
						recipe.getMeasurements().remove(measurementChoice - 1);
						con.println(name + " deleted");
						done = true;
						break;
					case "N":
					case "n":
						con.println("Not deleted");
						done = true;
						break;
					default:
						con.println("Enter Y or N");
					}
				} while (done == false);

				con.println("------------------");
				break;
			case "4": // Go back to updating recipe details menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Updating Recipe Method to User <br>
	 * Including functionality to add, update or delete method steps from a recipe
	 * 
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdateMethod(Recipe recipe) throws Exception {
		String[] methodOptions = { "Add a Step", "Update Step", "Remove Step", "Back" };
		Menu methodMenu = new Menu("Update Method", methodOptions);
		boolean finished = false;
		do {
			Application.DisplayTitle("Update Method");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.BOLD, 18));
			con.println("\nMethod:");
			QUBKitchen.con.setFont(new Font("Monospaced", Font.PLAIN, 18));

			for (int i = 0; i < recipe.getMethod().size(); i++) {
				con.println((i + 1) + ". " + recipe.getMethod().get(i));
			}
			con.println("\n\t\t\t\t----------------\n");
			String choice = methodMenu.getUserChoice(false);
			switch (choice) {
			case "1": // Add step
				con.println("------------------");
				boolean valid = false;
				String step = "";
				do {
					con.print("Write Step: ");
					step = con.readLn();
					if (step.length() < 0 || step.length() > 100) {
						con.println("Step must be between 0 and 100 characters");
					} else {
						valid = true;
					}
				} while (valid = false);

				valid = false;
				int index = 0;
				while (valid == false) {
					con.print("Which number will this step be?: ");
					String indexInput = con.readLn();
					if (Utility.isNumeric(indexInput)) {
						index = Integer.parseInt(indexInput);
						if (index > 0 && index <= (recipe.getMethod().size() + 1)) {
							valid = true;
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				}

				recipe.addMethodStep((index - 1), step);
				con.println("------------------");
				break;
			case "2": // Update existing step
				con.println("------------------");
				con.println("Choose Step to Update: ");
				for (int i = 0; i < recipe.getMethod().size(); i++) {
					con.println((i + 1) + ". " + recipe.getMethod().get(i));
				}
				int stepChoice = -1;
				valid = false;
				while (valid == false) {
					con.print("Input choice: ");
					String stepChoiceStr = con.readLn();
					if (Utility.isNumeric(stepChoiceStr)) {
						stepChoice = Integer.parseInt(stepChoiceStr);
						if (stepChoice <= recipe.getMethod().size() && stepChoice > 0) {
							valid = true;
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				}

				valid = false;
				step = "";
				do {
					con.print("Input updated step: ");
					step = con.readLn();
					if (step.length() < 0 || step.length() > 100) {
						con.println("Step must be between 0 and 100 characters");
					} else {
						valid = true;
					}
				} while (valid = false);

				recipe.getMethod().set((stepChoice - 1), step);
				con.println("------------------");
				break;
			case "3": // Remove Step
				con.println("------------------");
				con.println("Choose Step to Delete: ");
				for (int i = 0; i < recipe.getMethod().size(); i++) {
					con.println((i + 1) + ". " + recipe.getMethod().get(i));
				}
				stepChoice = -1;
				valid = false;
				while (valid == false) {
					con.print("Input choice: ");
					String stepChoiceStr = con.readLn();
					if (Utility.isNumeric(stepChoiceStr)) {
						stepChoice = Integer.parseInt(stepChoiceStr);
						if (stepChoice <= recipe.getMethod().size() && stepChoice > 0) {
							valid = true;
						} else {
							con.println("Invalid option");
						}
					} else {
						con.println("Invalid option");
					}
				}

				boolean done = false;
				do {
					con.print("Remove Step " + stepChoice + "? (Y/N): ");
					String sure = con.readLn();
					switch (sure) {
					case "Y":
					case "y":
						recipe.getMethod().remove(stepChoice - 1);
						con.println("Deleted");
						done = true;
						break;
					case "N":
					case "n":
						con.println("Not deleted");
						done = true;
						break;
					default:
						con.println("Enter Y or N");
					}
				} while (done == false);

				con.println("------------------");
				break;
			case "4": // Go back to updating recipe details menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Searching Recipe to User <br>
	 * Including functionality to search by ID, Name, meal type or ingredient
	 * 
	 * @throws Exception
	 */
	public static void RecipesSearch() {
		String[] recipesOptions = { "Search by ID", "Search by Name/Part Name", "Search by Meal Type",
				"Search by Ingredient", "Back" };
		Menu recipes = new Menu("Search Recipes", recipesOptions);
		boolean finished = false;
		do {
			String choice = recipes.getUserChoice();
			switch (choice) {
			case "1": // Search by ID
				Application.DisplayTitle("Searching by ID");

				String search = "";
				do {
					boolean valid = false;
					do {
						con.print("\nInput search (or X to go back): ");
						search = con.readLn();
						if (search.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(search)) {
							valid = true;
							ArrayList<Integer> indexes = new ArrayList<Integer>();
							indexes = Application.SearchRecipes(Integer.parseInt(search));
							if (indexes.size() < 1) {
								con.println("\nNo Matching Results");
							} else {
								Application.DisplaySpecificRecipe(indexes);
							}
						} else {
							con.println("Input a number");
						}
					} while (valid = false);
				} while (!search.equalsIgnoreCase("X"));
				break;
			case "2": // Search by Name
				Application.DisplayTitle("Searching by Name/Part Name");
				con.print("\nInput search (or X to go back): ");
				String search2 = con.readLn();
				while (!search2.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchRecipes(search2);
					if (indexes.size() < 1) {
						con.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificRecipe(indexes);
					}

					con.print("\nInput search (or X to go back): ");
					search2 = con.readLn();
				}
				break;
			case "3": // Search by Meal Type
				Application.DisplayTitle("Searching by Meal Type");
				MealType searchMT = Application.ChooseMealType(true);
				while (searchMT != MealType.UNDEFINED) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchRecipes(searchMT);
					if (indexes.size() < 1) {
						con.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificRecipe(indexes);
					}
					searchMT = Application.ChooseMealType(true);
				}
				break;
			case "4": // Search by Ingredient
				Application.DisplayTitle("Searching by Ingredient\n");

				con.println("Ingredients:");
				Application.DisplayAllIngredients(false);

				String ingredientIndexStr = "";
				do {
					con.println("\nIngredients:");
					Application.DisplayAllIngredients(false);
					boolean valid = false;
					do {
						con.print("Input number of choice (or X to go back): ");
						ingredientIndexStr = con.readLn();
						if (Utility.isNumeric(ingredientIndexStr)) {
							int ingredientIndex = Integer.parseInt(ingredientIndexStr);
							if (ingredientIndex > 0 && ingredientIndex < Application.ingredientsList.size()) {
								valid = true;
								Ingredient ingredient = Application.ingredientsList.get(ingredientIndex - 1);
								ArrayList<Integer> indexes = new ArrayList<Integer>();
								indexes = Application.SearchRecipes(ingredient);
								if (indexes.size() < 1) {
									con.println("\nNo Matching Results");
								} else {
									Application.DisplaySpecificRecipe(indexes);
								}
							} else {
								con.println("Invalid option");
							}
						} else {
							con.println("Invalid option");
						}
					} while (valid = false);

				} while (!ingredientIndexStr.equalsIgnoreCase("X"));

				break;
			case "5": // back to manage Recipes Menu
				finished = true;
				break;
			default:
				con.println("Invalid option.");
			}
		} while (!finished);

	}

	/**
	 * Display menu for managing weekly menu to user <br>
	 * Providing functionality to Create Menu, Add/Update meals, delete meals and
	 * clear menu;
	 * 
	 * @throws Exception
	 */
	public static void WeeklyMenu() throws Exception {
		if (!Application.weeklyMenu.isEmpty()) { // If the menu is not empty
			String[] weeklyOptions = { "Add/Update Meal", "Delete Meal", "Clear Menu", "Back" };
			Menu weekly = new Menu("Weekly Menu", weeklyOptions);
			boolean finished = false;
			do {
				Application.DisplayTitle("Weekly Menu");
				con.println(Application.weeklyMenu);
				String choice = weekly.getUserChoice(false);
				switch (choice) {
				case "1": // Add/Update recipe in menu
					con.println("\n--------------------------------------\nAdding/Updating Meal\n");
					int[] array = Application.MenuChooseMeal();
					int day = array[0];
					int course = array[1];
					con.println("\nChoose Recipe:");
					Application.DisplayAllRecipes(false);
					boolean valid = false;
					int recipeIndex = 0;
					do {
						con.print("Enter Choice: ");
						String recipeIndexStr = con.readLn();
						if (Utility.isNumeric(recipeIndexStr)) {
							recipeIndex = Integer.parseInt(recipeIndexStr);
							if (recipeIndex < Application.recipesList.size() + 2 && recipeIndex > 0) {
								valid = true;
							} else {
								con.println("Invalid choice");
							}
						} else {
							con.println("Invalid choice");
						}

					} while (valid = false);
					Recipe recipe = Application.recipesList.get(recipeIndex - 1);
					Application.weeklyMenu.addRecipe(recipe, day, course);
					con.println("\n--------------------------------------");
					break;
				case "2": // Delete recipe from menu
					con.println("\n--------------------------------------\nDeleting Meal\n");
					array = Application.MenuChooseMeal();
					Application.weeklyMenu.removeRecipe(array[0], array[1]);
					con.println("\n--------------------------------------");
					break;
				case "3": // Clear entire menu
					boolean done = false;
					do {
						con.print("Are you sure you want to clear the menu? (Y/N): ");
						String sure = con.readLn();
						switch (sure) {
						case "Y":
						case "y":
							Application.weeklyMenu.clearMenu();
							done = true;
							break;
						case "N":
						case "n":
							done = true;
							break;
						default:
							con.println("Enter Y or N");
						}
					} while (done == false);
					WeeklyMenu();
					finished = true;
					break;
				case "4": // Go back to main menu
					finished = true;
					break;
				default:
					con.println("Invalid option.");
				}
			} while (!finished);
		} else { // If menu is empty only give options to create or go back
			String[] weeklyOptions = { "Create Menu", "Back" };
			Menu weekly = new Menu("Weekly Menu", weeklyOptions);
			boolean finished = false;
			do {
				Application.DisplayTitle("Weekly Menu\n");
				String choice = weekly.getUserChoice(false);
				switch (choice) {
				case "1":
					Application.CreateMenu();
					finished = true;
					break;
				case "2":
					finished = true;
					break;
				default:
					con.println("Invalid Option.");
				}
			} while (!finished);
		}

	}

}
