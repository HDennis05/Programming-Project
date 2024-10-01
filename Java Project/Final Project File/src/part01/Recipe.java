package part01;

import java.util.ArrayList;

/**
 * Class to represent a Recipe
 * 
 * @author Hannah Dennis - 40406567
 */
public class Recipe {
	private int ID; // Unique Recipe Identifier
	private static int nextID = 0; // Static ID counter
	private String name; // Recipe name
	private MealType mealType; // Recipe meal type
	private int portions; // Recipe portion size
	private ArrayList<Measurement> measurements = new ArrayList<Measurement>(); // List of Ingredients and their
																				// measurements
	private ArrayList<String> method = new ArrayList<String>(); // List of Method steps

	/**
	 * Recipe Constructor
	 * 
	 * @param name         - Name of Recipe
	 * @param mealType     - Recipe meal type - Starter, Main or Dessert
	 * @param portions     - Amount of portions recipe feeds
	 * @param measurements - Array of Measurements
	 * @param method       - Array of Method steps
	 * @throws Exception - If data cannot be written correctly, error describes
	 *                   reason(s)
	 */
	public Recipe(String name, MealType mealType, int portions, ArrayList<Measurement> measurements,
			ArrayList<String> method) throws Exception {
		this.ID = nextID++;
		String error = ""; // Any errors made when constructing added to this string
		try {
			this.setName(name);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setMealType(mealType);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setPortions(portions);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setMeasurements(measurements);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setMethod(method);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}

		if (error != "") {
			throw new Exception("\nData could not be written\nReason(s):" + error);
		}
	}

	public Recipe(String name, MealType mealtype, int portions, Measurement[] measurementsArr, String[] methodArr)
			throws Exception {
		this.ID = nextID++;
		String error = ""; // Any errors made when constructing added to this string
		try {
			this.setName(name);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setMealType(mealtype);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setPortions(portions);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			ArrayList<Measurement> measurements = new ArrayList<Measurement>();
			for (int i = 0; i < measurementsArr.length; i++) {
				measurements.add(measurementsArr[i]);
			}
			this.setMeasurements(measurements);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			ArrayList<String> method = new ArrayList<String>();
			for (int i = 0; i < methodArr.length; i++) {
				method.add(methodArr[i]);
			}
			this.setMethod(method);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}

		if (error != "") {
			throw new Exception("\nData could not be written\nReason(s):" + error);
		}
	}

	/**
	 * Calculates total calories of recipe per portion
	 * 
	 * @return - total calories per portion
	 */
	public double totalCalories() {
		double total = 0; // total calories
		for (int i = 0; i < this.measurements.size(); i++) {
			Ingredient ingredient = this.measurements.get(i).getIngredient(); // Ingredient in current measurement
			double calories = (ingredient.getCalories()); // calories for specific ingredient per 100g/100ml
			int amount = this.measurements.get(i).getAmount(); // amount of specific ingredient in measurement
			total += (calories/100 * amount);
		}
		return total/this.portions;
	}

	/**
	 * Adds measurement object to measurement list
	 * 
	 * @param measurement - Measurement object
	 * @throws Exception - if reference passed is null
	 */
	public void addMeasurement(Measurement measurement) throws Exception {
		if (measurement != null) {
			this.measurements.add(measurement);
		} else {
			throw new Exception("Measurement cannot be null");
		}
	}

	/**
	 * Adds method step to method list
	 * 
	 * @param index - index of insertion into list
	 * @param step  - method step
	 * @throws Exception - if step passed is invalid
	 */
	public void addMethodStep(int index, String step) throws Exception {
		if (step.length() > 0 && step.length() < 100) {
			this.method.add(index, step);
		} else {
			throw new Exception("Step must be between 0 and 100 characters");
		}
	}

	// Setters
	/**
	 * Sets Recipe's name
	 * 
	 * @param name - Name of recipe
	 * @throws Exception - if name passed is invalid
	 */
	public void setName(String name) throws Exception {
		name = name.trim();
		if (name != "" && name != null) {
			if (Utility.isName(name)) {
				this.name = name;
			} else {
				throw new Exception("Name must be letters or characters: /&,.'- ");
			}
		} else {
			throw new Exception("Name cannot be blank or null");
		}
	}

	/**
	 * Sets Recipe's meal type
	 * 
	 * @param mealType - Recipe meal type - Starter, Main or Dessert
	 * @throws Exception - if reference passed is null
	 */
	public void setMealType(MealType mealType) throws Exception {
		if (mealType != null) {
			this.mealType = mealType;
		} else {
			throw new Exception("MealType cannot be null");
		}
	}

	/**
	 * Sets Recipe's portion size
	 * 
	 * @param portions - portion size of recipe
	 * @throws Exception - if portions passed is invalid
	 */
	public void setPortions(int portions) throws Exception {
		if (portions > 0 && portions < 100) {
			this.portions = portions;
		} else {
			throw new Exception("Portions must be 1-99");
		}
	}

	/**
	 * Sets Recipe's measurements
	 * 
	 * @param measurements - Array of measurements for recipe
	 * @throws Exception - if reference passed is null or empty
	 */
	public void setMeasurements(ArrayList<Measurement> measurements) throws Exception {
		if (measurements != null && measurements.size() > 0) {
			this.measurements = measurements;
		} else {
			throw new Exception("Measurements cannot be empty or null");
		}
	}

	/**
	 * Sets Recipe's method
	 * 
	 * @param method - Array of method steps for recipes
	 * @throws Exception - if reference passed is null or empty
	 */
	public void setMethod(ArrayList<String> method) throws Exception {
		if (method != null && method.size() > 0) {
			this.method = method;
		} else {
			throw new Exception("Method cannot be empty or null");
		}
	}

	// Getters
	/**
	 * Returns Recipe's ID
	 * 
	 * @return - Recipe ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Returns Recipe's Name
	 * 
	 * @return - Name of Recipe
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns Recipe's meal type as a mealType object
	 * 
	 * @return - Recipe meal type (Starter, Main or Dessert)
	 */
	public MealType getMealType() {
		return this.mealType;
	}

	/**
	 * Returns Recipe's meal type as a String
	 * 
	 * @return - Recipe meal type (Starter, Main or Dessert)
	 */
	public String getMealTypeStr() {
		return this.mealType.toString();
	}

	/**
	 * Returns Recipe's portions
	 * 
	 * @return - Portion size that recipe feeds
	 */
	public int getPortions() {
		return this.portions;
	}

	/**
	 * Returns Recipe's measurements
	 * 
	 * @return - Array of measurements for recipe
	 */
	public ArrayList<Measurement> getMeasurements() {
		return this.measurements;
	}

	/**
	 * Returns Recipe's method
	 * 
	 * @return - Array of method steps for recipe
	 */
	public ArrayList<String> getMethod() {
		return this.method;
	}

	/**
	 * converts object into a human-understandable format
	 */
	public String toString() {
		String result = "";
		
		String IDFormatted = String.format("%04d", this.ID); // Pad left side with zeros to
		// make ID 4 digits
		result += "-------------------------------------\n" + IDFormatted + " - " + this.name + "\n\n"
				+ this.mealType + "\n" + this.portions + " Portion(s)" + "\n"
				+ String.format("%.2f", (this.totalCalories())) + " Calories per portion" + "\n\nIngredients:";
		
		for (int i = 0; i < this.measurements.size(); i++) { // Print recipe's ingredients
			Measurement measurement = this.measurements.get(i);
			result += "\n• " + measurement.getIngredient().getName() + " - " + measurement.getAmount()
					+ measurement.getUnitStr();
		}
		result += "\nMethod:"; // Print method steps
		for (int i = 0; i < this.method.size(); i++) {
			result += "\n"+((i + 1) + ". " + this.method.get(i));
		}

		result += "\n-------------------------------------";
		
		return result;
	}

}
