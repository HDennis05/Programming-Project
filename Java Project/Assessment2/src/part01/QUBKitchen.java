package part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main program file
 * <br>Provides all menus displayed to the user
 * @author Hannah Dennis - 40406567
 */
public class QUBKitchen {
	static Scanner input = new Scanner(System.in);

	/**
	 * Starting point for Application
	 * <br>Displays Main Menu to user
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Application.initialiseQUBKitchen();
		
		String[] mainOptions = { "Manage Ingredients", "Manage Recipes", "Manage Weekly Menu", "Exit" }; //Main menu option
		Menu main = new Menu("QUBKitchen", mainOptions); 
		boolean finished = false; //Marker to escape loop
		do {
			int choice = main.getUserChoice();
			switch (choice) {
			case 1:
				IngredientsMain();
				break;
			case 2:
				RecipesMain();
				break;
			case 3:
				WeeklyMenu();
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);

	}

	/**
	 * Displays menu for Managing Ingredients to User
	 * <br>Including functionality to View, Search, Add, Update and Delete
	 * @throws Exception
	 */
	public static void IngredientsMain() throws Exception {
		String[] ingredientOptions = { "View All", "Search", "Add", "Update", "Delete", "Back" };
		Menu ingredients = new Menu("Manage Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			int choice = ingredients.getUserChoice();
			switch (choice) {
			case 1: //Displays all ingredients
				System.out.println("\n\n---------------");
				System.out.println("All Ingredients");
				System.out.println("---------------");
				Application.DisplayAllIngredients(true);
				System.out.print("\nPress Enter to Exit: ");
				input.nextLine();
				break;
			case 2: //Go to Search ingredients menu
				IngredientsSearch();
				break;
			case 3: //Add Ingredient 
				Application.AddIngredient();
				break;
			case 4: //Update Ingredients
				System.out.println("\n\n------------------");
				System.out.println("Update Ingredients");
				System.out.println("------------------");

				String toBeUpdated = "";
				do {
					Application.DisplayAllIngredients(false);
					boolean valid = false; //Marker for validation loop
					do {
						System.out.print("\nChoose an ingredient to update (or X to go back): ");
						toBeUpdated = input.nextLine();
						if (Utility.isNumeric(toBeUpdated)) {
							int updateInt = Integer.parseInt(toBeUpdated);
							if (updateInt > 0 && updateInt < Application.ingredientsList.size() + 1) {
								Application.UpdateIngredient(updateInt);
								valid = true;
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} while (valid == false);
					System.out.println();
				} while (!toBeUpdated.equalsIgnoreCase("X"));
				break;
			case 5: //Delete Ingredients
				System.out.println("\n\n------------------");
				System.out.println("Delete Ingredients");
				System.out.println("------------------");

				String toBeDeleted = "";
				do {
					Application.DisplayAllIngredients(false);
					boolean valid = false; //Marker for validation loop
					do {
						System.out.print("\nChoose an ingredient to delete (or X to go back): ");
						toBeDeleted = input.nextLine();
						if (Utility.isNumeric(toBeDeleted)) {
							int deleteInt = Integer.parseInt(toBeDeleted);
							if (deleteInt > 0 && deleteInt < Application.ingredientsList.size() + 1) {
								Application.DeleteIngredient(deleteInt);
								valid = true;
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} while (valid == false);
					System.out.println();
				} while (!toBeDeleted.equalsIgnoreCase("X"));

				break;
			case 6: //Go back to main menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Searching Ingredients to User
	 * <br>Including functionality to search by ID, Name, Food Group
	 * @throws Exception
	 */
	public static void IngredientsSearch() {
		String[] ingredientOptions = { "Search by ID", "Search by Name/Part Name", "Search by Food Group", "Back" };
		Menu ingredients = new Menu("Search Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			int choice = ingredients.getUserChoice();
			switch (choice) {
			case 1: //Search by ID
				System.out.println("\n---------------");
				System.out.println("Searching by ID\n");
				System.out.print("Input search (or X to go back): ");
				String search = input.nextLine();
				while (!search.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchIngredients(Integer.parseInt(search)); //get indexes of all matches
					if (indexes.size() < 1) {
						System.out.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificIngredients(indexes);
					}

					System.out.print("\nInput search (or X to go back): ");
					search = input.nextLine();
				}
				System.out.println("------------------");
				break;
			case 2: //Search by Name
				System.out.println("\n---------------------------");
				System.out.println("Searching by Name/Part Name\n");
				System.out.print("Input search (or X to go back): ");
				search = input.nextLine();
				while (!search.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchIngredients(search); //get indexes of all matches
					if (indexes.size() < 1) {
						System.out.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificIngredients(indexes);
					}

					System.out.print("\nInput search (or X to go back): ");
					search = input.nextLine();
				}
				System.out.println("------------------");
				break;
			case 3:
				System.out.println("\n---------------------------");
				System.out.println("Searching by Food Group\n");
				FoodType searchFT = Application.ChooseFoodGroup();
				System.out.println(searchFT);
				while (searchFT != FoodType.UNDEFINED) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchIngredients(searchFT); //get indexes of all matches
					if (indexes.size() < 1) {
						System.out.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificIngredients(indexes);
					}
					searchFT = Application.ChooseFoodGroup();
				}
				System.out.println("------------------");
				break;
			case 4: //back to manage ingredients
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);

	}

	/**
	 * Displays menu for Managing Recipes to User
	 * <br>Including functionality to view, search, add, update and delete
	 * @throws Exception
	 */
	public static void RecipesMain() throws Exception {
		String[] ingredientOptions = { "View All", "Search", "Add", "Update", "Delete", "Back" };
		Menu ingredients = new Menu("Manage Recipes", ingredientOptions);
		boolean finished = false;
		do {
			int choice = ingredients.getUserChoice();
			switch (choice) {
			case 1: //View all recipes and allow user to choose one to see full recipe
				System.out.println("\n\n---------------");
				System.out.println("All Recipes");
				System.out.println("---------------");
				Application.DisplayAllRecipes(true);
				
				boolean valid = false; //marker for validation loop
				do {
					System.out.print("\nChoose a recipe to view (or X to go back): ");
					String recipeChoice = input.nextLine();
					if (!recipeChoice.equalsIgnoreCase("X")) {
						if (Utility.isNumeric(recipeChoice)) {
							if (Integer.parseInt(recipeChoice)>0 && Integer.parseInt(recipeChoice)<Application.recipesList.size()+1) {
								valid = true;
								Application.ViewRecipe(Integer.parseInt(recipeChoice));
								System.out.println("\nPress Enter to Return: ");
								input.nextLine();
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				} while (valid == false);
				break;
			case 2: //Go to recipe search menu
				RecipesSearch();
				break;
			case 3: //Add recipe
				Application.AddRecipe();
				break;
			case 4: //Choose recipe to update and go to update menu
				System.out.println("\n\n--------------");
				System.out.println("Update Recipes");
				System.out.println("--------------");

				String toBeUpdated = "";
				do {
					Application.DisplayAllRecipes(false);
					valid = false;  //Marker for validation loop
					do {
						System.out.print("\nChoose a recipe to update (or X to go back): ");
						toBeUpdated = input.nextLine();
						if (Utility.isNumeric(toBeUpdated)) {
							int updateInt = Integer.parseInt(toBeUpdated);
							if (updateInt > 0 && updateInt < Application.ingredientsList.size() + 1) {
								Application.ViewRecipe(updateInt);
								RecipesUpdate(Application.recipesList.get(updateInt - 1));
								valid = true;
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} while (valid == false);
					System.out.println();
				} while (!toBeUpdated.equalsIgnoreCase("X"));

				break;
			case 5: //Delete recipe
				System.out.println("\n\n--------------");
				System.out.println("Delete Recipes");
				System.out.println("--------------");

				String toBeDeleted = "";
				do {
					Application.DisplayAllIngredients(false);
					valid = false; //Marker for validation loop
					do {
						System.out.print("\nChoose a recipe to delete (or X to go back): ");
						toBeDeleted = input.nextLine();
						if (Utility.isNumeric(toBeDeleted)) {
							int deleteInt = Integer.parseInt(toBeDeleted);
							if (deleteInt > 0 && deleteInt < Application.ingredientsList.size() + 1) {
								Application.DeleteRecipe(Integer.parseInt(toBeDeleted));
								valid = true;
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} while (valid == false);
					System.out.println();
				} while (!toBeDeleted.equalsIgnoreCase("X"));

				break;
			case 6: //back to main menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);
	}
	/**
	 * Displays menu for Updating Recipes to User
	 * <br>Including functionality to update name, meal type, portions, ingredients and method
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdate(Recipe recipe) throws Exception {
		String[] updateOptions = { "Name", "Meal Type", "Portions", "Ingredients", "Method", "Back" };
		Menu update = new Menu("Fields to Update", updateOptions);
		boolean finished = false;
		do {

			int choice = update.getUserChoice();
			switch (choice) {
			case 1: //Input new Name
				System.out.println("------------------");
				String currentName = recipe.getName();
				System.out.println("Current Name: " + currentName);
				boolean valid = false;
				do {
					System.out.print("Input new name: ");
					String newName = (input.nextLine()).trim();
					if (newName != "") {
						if (Utility.isName(newName)) {
							recipe.setName(newName);
							valid = true;
						} else {
							System.out.println("Name must be letters or characters: /&,.'- ");
						}
					} else {
						System.out.println("Name is a required field");
					}
				} while (valid == false);
				System.out.println("------------------");
				break;
			case 2: //Input new mealType
				System.out.println("------------------");
				String currentMealType = recipe.getMealTypeStr();
				System.out.println("Current Food Group: " + currentMealType);
				MealType newMealType = Application.ChooseMealType();
				recipe.setMealType(newMealType);
				System.out.println("------------------");
				break;
			case 3: //Input new portion size
				System.out.println("------------------");
				int currentPortions = recipe.getPortions();
				System.out.println("\nCurrent portions: " + currentPortions);
				valid = false;
				while (valid == false) {
					System.out.print("Input new portions: ");
					String newPortions = (input.nextLine()).trim();
					if (Utility.isNumeric(newPortions) && newPortions != null) {
						if (Integer.parseInt(newPortions) > 0 && Integer.parseInt(newPortions) < 99) {
							recipe.setPortions(Integer.parseInt(newPortions));
							valid = true;
						} else {
							System.out.println("Portions must be between 0 and 99");
						}
					} else {
						System.out.println("Portions must be a number");
					}
				}
				System.out.println("------------------");
				break;
			case 4: //Go to update ingredients menu
				RecipesUpdateIngredients(recipe);
				break;
			case 5: //Go to update method menu
				RecipesUpdateMethod(recipe);
				break;
			case 6: //Back to Managing Ingredients Menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Updating Recipe Ingredients to User
	 * <br>Including functionality to add, update or delete ingredients from a recipe
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdateIngredients(Recipe recipe) throws Exception {
		String[] ingredientOptions = { "Add an Ingredient", "Update Amount of Ingredient", "Remove Ingredient",
				"Back" };
		Menu ingredients = new Menu("Update Ingredients", ingredientOptions);
		boolean finished = false;
		do {
			System.out.println("\nIngredients: ");
			for (int i = 0; i < recipe.getMeasurements().size(); i++) {
				Measurement temp = recipe.getMeasurements().get(i);
				System.out
						.println("• " + temp.getIngredient().getName() + " - " + temp.getAmount() + temp.getUnitStr());
			}
			int choice = ingredients.getUserChoice();
			switch (choice) {
			case 1: //Add new Measurement
				System.out.println("Choose Ingredient:");
				Application.DisplayAllIngredients(false);
				
				Ingredient ingredient = null;
				boolean valid = false;
				do {
					System.out.print("Choose an ingredient: ");
					String ingredientIndexStr = input.nextLine();
					if (Utility.isNumeric(ingredientIndexStr)) {
						int ingredientIndex = Integer.parseInt(ingredientIndexStr);
						if (ingredientIndex > 0 && ingredientIndex < Application.ingredientsList.size()) {
							ingredient = Application.ingredientsList.get(ingredientIndex - 1);
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				} while (valid = false);
				
				int amount = 0;
				Unit unit = Unit.UNDEFINED;
				do {
					System.out.print("Input measurement in g or ml (eg. 400 g /350 ml): ");
					String measurement = input.nextLine();
					if (Utility.isMeasurement(measurement)) {
						String[] measurementDetails = measurement.split(" ");
						amount = Integer.parseInt(measurementDetails[0]);
						String unitStr = measurementDetails[1];
						switch (unitStr) {
						case "g":
							unit = Unit.GRAMS;
							valid = true;
						case "ml":
							unit = Unit.MILLILITRES;
							valid = true;
						default:
							System.out.println("Unit must be 'g' or 'ml'");
						}
					} else {
						System.out.println("Incorrect format");
					}
				} while (valid == false);

				Measurement newMeasurement = new Measurement(ingredient, amount, unit);
				recipe.addMeasurement(newMeasurement);
				break;
			case 2: //Update Existing Measurement
				System.out.println("Choose measurement to Update: ");
				for (int i = 0; i < recipe.getMeasurements().size(); i++) {
					Measurement temp = recipe.getMeasurements().get(i);
					System.out.println((i + 1) + ". " + temp.getIngredient().getName() + " - " + temp.getAmount()
							+ temp.getUnitStr());
				}
				int measurementChoice = -1;
				valid = false;
				do {
					System.out.print("Input choice: ");
					String measurementChoiceStr = input.nextLine();
					if (Utility.isNumeric(measurementChoiceStr)) {
						measurementChoice = Integer.parseInt(measurementChoiceStr);
						if (measurementChoice <= recipe.getMeasurements().size() && measurementChoice > 0) {
							valid = true;
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				} while (valid == false);
				
				Measurement measurementToUpdate = recipe.getMeasurements().get(measurementChoice - 1);
				
				amount = 0;
				unit = Unit.UNDEFINED;
				do {
					System.out.print("Input measurement in g or ml (eg. 400 g /350 ml): ");
					String measurement = input.nextLine();
					if (Utility.isMeasurement(measurement)) {
						String[] measurementDetails = measurement.split(" ");
						amount = Integer.parseInt(measurementDetails[0]);
						String unitStr = measurementDetails[1];
						switch (unitStr) {
						case "g":
							unit = Unit.GRAMS;
							valid = true;
						case "ml":
							unit = Unit.MILLILITRES;
							valid = true;
						default:
							System.out.println("Unit must be 'g' or 'ml'");
						}
					} else {
						System.out.println("Incorrect format");
					}
				} while (valid == false);
				
				measurementToUpdate.setAmount(amount);
				measurementToUpdate.setUnit(unit);
				break;
				
			case 3: //Delete a measurement
				System.out.println("Choose measurement to Delete: ");
				for (int i = 0; i < recipe.getMeasurements().size(); i++) {
					Measurement temp = recipe.getMeasurements().get(i);
					System.out.println((i + 1) + ". " + temp.getIngredient().getName() + " - " + temp.getAmount()
							+ temp.getUnitStr());
				}
				measurementChoice = -1;
				valid = false;
				do {
					System.out.print("Input choice: ");
					String measurementChoiceStr = input.nextLine();
					if (Utility.isNumeric(measurementChoiceStr)) {
						measurementChoice = Integer.parseInt(measurementChoiceStr);
						if (measurementChoice <= recipe.getMeasurements().size() && measurementChoice > 0) {
							valid = true;
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				} while (valid == false);
				
				String name = recipe.getMeasurements().get(measurementChoice - 1).getIngredient().getName();
				boolean done = false;
				do {
					System.out.print("Remove " + name + "? (Y/N): ");
					String sure = input.nextLine();
					switch (sure) {
					case "Y":
					case "y":
						recipe.getMeasurements().remove(measurementChoice - 1);
						System.out.println(name + " deleted");
						done = true;
						break;
					case "N":
					case "n":
						System.out.println("Not deleted");
						done = true;
						break;
					default:
						System.out.println("Enter Y or N");
					}
				} while (done == false);
				
				break;
			case 4: //Go back to updating recipe details menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Updating Recipe Method to User
	 * <br>Including functionality to add, update or delete method steps from a recipe
	 * @param recipe - recipe to be Updated
	 * @throws Exception
	 */
	public static void RecipesUpdateMethod(Recipe recipe) throws Exception {
		String[] methodOptions = { "Add a Step", "Update Step", "Remove Step", "Back" };
		Menu methodMenu = new Menu("Update Method", methodOptions);
		boolean finished = false;
		do {
			System.out.println("\nMethod:");
			for (int i = 0; i < recipe.getMethod().size(); i++) {
				System.out.println((i + 1) + ". " + recipe.getMethod().get(i));
			}
			int choice = methodMenu.getUserChoice();
			switch (choice) {
			case 1: //Add step
				boolean valid = false;
				String step = "";
				do {
					System.out.print("Write Step: ");
					step = input.nextLine();
					if (step.length() < 0 || step.length() > 100) {
						System.out.println("Step must be between 0 and 100 characters");
					} else {
						valid = true;
					}
				} while (valid = false);
				
				valid = false;
				int index = 0;
				while (valid == false) {
					System.out.print("Which number will this step be?: ");
					String indexInput = input.nextLine();
					if (Utility.isNumeric(indexInput)) {
						index = Integer.parseInt(indexInput);
						if (index > 0 && index <= (recipe.getMethod().size() + 1)) {
							valid = true;
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				}

				recipe.addMethodStep((index - 1), step);
				break;
			case 2: //Update existing step
				System.out.println("Choose Step to Update: ");
				for (int i = 0; i < recipe.getMethod().size(); i++) {
					System.out.println((i + 1) + ". " + recipe.getMethod().get(i));
				}
				int stepChoice = -1;
				valid = false;
				while (valid == false) {
					System.out.print("Input choice: ");
					String stepChoiceStr = input.nextLine();
					if (Utility.isNumeric(stepChoiceStr)) {
						stepChoice = Integer.parseInt(stepChoiceStr);
						if (stepChoice <= recipe.getMethod().size() && stepChoice > 0) {
							valid = true;
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				}
				
				valid = false;
				step = "";
				do {
					System.out.print("Input updated step: ");
					step = input.nextLine();
					if (step.length() < 0 || step.length() > 100) {
						System.out.println("Step must be between 0 and 100 characters");
					} else {
						valid = true;
					}
				} while (valid = false);

				recipe.getMethod().set((stepChoice - 1), step);
				break;
			case 3: //Remove Step
				System.out.println("Choose Step to Delete: ");
				for (int i = 0; i < recipe.getMethod().size(); i++) {
					System.out.println((i + 1) + ". " + recipe.getMethod().get(i));
				}
				stepChoice = -1;
				valid = false;
				while (valid == false) {
					System.out.print("Input choice: ");
					String stepChoiceStr = input.nextLine();
					if (Utility.isNumeric(stepChoiceStr)) {
						stepChoice = Integer.parseInt(stepChoiceStr);
						if (stepChoice <= recipe.getMethod().size() && stepChoice > 0) {
							valid = true;
						} else {
							System.out.println("Invalid option");
						}
					} else {
						System.out.println("Invalid option");
					}
				}
				
				boolean done = false;
				do {
					System.out.print("Remove Step " + stepChoice + "? (Y/N): ");
					String sure = input.nextLine();
					switch (sure) {
					case "Y":
					case "y":
						recipe.getMethod().remove(stepChoice - 1);
						System.out.println("Deleted");
						done = true;
						break;
					case "N":
					case "n":
						System.out.println("Not deleted");
						done = true;
						break;
					default:
						System.out.println("Enter Y or N");
					}
				} while (done == false);
				
				break;
			case 4: //Go back to updating recipe details menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);
	}

	/**
	 * Displays menu for Searching Recipe to User
	 * <br>Including functionality to search by ID, Name, meal type or ingredient
	 * @throws Exception
	 */
	public static void RecipesSearch() {
		String[] recipesOptions = { "Search by ID", "Search by Name/Part Name", "Search by Meal Type",
				"Search by Ingredient", "Back" };
		Menu recipes = new Menu("Search Recipes", recipesOptions);
		boolean finished = false;
		do {
			int choice = recipes.getUserChoice();
			switch (choice) {
			case 1: //Search by ID
				System.out.println("\n---------------");
				System.out.println("Searching by ID");
			
				String search = "";
				do {
					boolean valid = false;
					do {
						System.out.print("\nInput search (or X to go back): ");
						search = input.nextLine();
						if (search.equalsIgnoreCase("X")) {
							break;
						}
						if (Utility.isNumeric(search)) {
							valid = true;
							ArrayList<Integer> indexes = new ArrayList<Integer>();
							indexes = Application.SearchRecipes(Integer.parseInt(search));
							if (indexes.size() < 1) {
								System.out.println("\nNo Matching Results");
							} else {
								Application.DisplaySpecificRecipe(indexes);
							}
						} else {
							System.out.println("Input a number");
						}
					} while (valid = false);
				} while (!search.equalsIgnoreCase("X"));
				System.out.println("------------------");
				break;
			case 2: //Search by Name
				System.out.println("\n---------------------------");
				System.out.println("Searching by Name/Part Name\n");
				System.out.print("Input search (or X to go back): ");
				String search2 = input.nextLine();
				while (!search2.equalsIgnoreCase("X")) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchRecipes(search2);
					if (indexes.size() < 1) {
						System.out.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificRecipe(indexes);
					}

					System.out.print("\nInput search (or X to go back): ");
					search2 = input.nextLine();
				}
				System.out.println("------------------");
				break;
			case 3: //Search by Meal Type 
				System.out.println("\n---------------------------");
				System.out.println("Searching by Meal Type");
				MealType searchMT = Application.ChooseMealType();
				while (searchMT != MealType.UNDEFINED) {
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					indexes = Application.SearchRecipes(searchMT);
					if (indexes.size() < 1) {
						System.out.println("\nNo Matching Results");
					} else {
						Application.DisplaySpecificRecipe(indexes);
					}
					searchMT = Application.ChooseMealType();
				}
				System.out.println("------------------");
				break;
			case 4: //Search by Ingredient
				System.out.println("\n---------------------------");
				System.out.println("Searching by Ingredient\n");

				System.out.println("Ingredients:");
				Application.DisplayAllIngredients(false);
				
				String ingredientIndexStr = "";
				do {
					System.out.println("\nIngredients:");
					Application.DisplayAllIngredients(false);
					boolean valid = false;
					do {
						System.out.print("Input number of choice (or X to go back): ");
						ingredientIndexStr = input.nextLine();
						if (Utility.isNumeric(ingredientIndexStr)) {
							int ingredientIndex = Integer.parseInt(ingredientIndexStr);
							if (ingredientIndex > 0 && ingredientIndex < Application.ingredientsList.size()) {
								valid = true;
								Ingredient ingredient = Application.ingredientsList.get(ingredientIndex - 1);
								ArrayList<Integer> indexes = new ArrayList<Integer>();
								indexes = Application.SearchRecipes(ingredient);
								if (indexes.size() < 1) {
									System.out.println("\nNo Matching Results");
								} else {
									Application.DisplaySpecificRecipe(indexes);
								}
							} else {
								System.out.println("Invalid option");
							}
						} else {
							System.out.println("Invalid option");
						}
					} while (valid = false);
				
				} while (!ingredientIndexStr.equalsIgnoreCase("X"));
				
				System.out.println("------------------");
				break;
			case 5: //back to manage Recipes Menu
				finished = true;
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (!finished);

	}

	/**
	 * Display menu for managing weekly menu to user
	 * <br>Providing functionality to Create Menu, Add/Update meals, delete meals and clear menu;
	 * @throws Exception 
	 */
	public static void WeeklyMenu() throws Exception {
		if (!Application.weeklyMenu.isEmpty()) { //If the menu is not empty
			String[] weeklyOptions = { "Add/Update Meal", "Delete Meal", "Clear Menu", "Back" };
			Menu weekly = new Menu("Weekly Menu", weeklyOptions);
			boolean finished = false;
			do {
				System.out.println("\n-----------\nWeekly Menu\n-----------");
				System.out.println(Application.weeklyMenu);
				int choice = weekly.getUserChoice(false);
				switch (choice) {
				case 1: //Add/Update recipe in menu
					System.out.println("\n--------------------------------------\nAdding/Updating Meal\n");
					int[] array = Application.MenuChooseMeal();
					int day = array[0];
					int course = array[1];
					System.out.println("\nChoose Recipe:");
					Application.DisplayAllRecipes(false);
					boolean valid = false;
					int recipeIndex = 0;
					do { 
						System.out.print("Enter Choice: ");
						String recipeIndexStr = input.nextLine();
						if (Utility.isNumeric(recipeIndexStr)) {
							recipeIndex = Integer.parseInt(recipeIndexStr);
							if (recipeIndex < Application.recipesList.size() + 2 && recipeIndex > 0) {
								valid = true;
							} else {
								System.out.println("Invalid choice");
							}
						} else {
							System.out.println("Invalid choice");
						}
						
					} while (valid = false);
					Recipe recipe = Application.recipesList.get(recipeIndex - 1);
					Application.weeklyMenu.addRecipe(recipe, day, course);
					System.out.println("\n--------------------------------------");
					break;
				case 2: //Delete recipe from menu
					System.out.println("\n--------------------------------------\nDeleting Meal\n");
					array = Application.MenuChooseMeal();
					Application.weeklyMenu.removeRecipe(array[0], array[1]);
					System.out.println("\n--------------------------------------");
					break;
				case 3: //Clear entire menu
					boolean done = false;
					do {
						System.out.print("Are you sure you want to clear the menu? (Y/N): ");
						String sure = input.nextLine();
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
							System.out.println("Enter Y or N");
						}
					} while (done == false);
					WeeklyMenu();
					finished = true;
					break;
				case 4: //Go back to main menu
					finished = true;
					break;
				default:
					System.out.println("Invalid option.");
				}
			} while (!finished);
		} else { //If menu is empty only give options to create or go back
			String[] weeklyOptions = { "Create Menu", "Back" };
			Menu weekly = new Menu("Weekly Menu", weeklyOptions);
			boolean finished = false;
			do {
				System.out.println("\n-----------\nWeekly Menu\n-----------");
				int choice = weekly.getUserChoice(false);
				switch (choice) {
				case 1:
					Application.CreateMenu();
					finished = true;
					break;
				case 2:
					finished = true;
					break;
				default:
					System.out.println("Invalid Option.");
				}
			} while (!finished);
		}

	}

}
