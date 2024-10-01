package part03;

/**
 * Class to represent a Ingredient
 * @author Hannah Dennis - 40406567
 */
public class Ingredient {
	private int ID; //Unique Ingredient Identifier
	private static int nextID = 0; //Static ID counter
	private String name; //Ingredient Name
	private FoodType foodGroup; //Ingredient Food Group
	private int calories; //Ingredient Calories per 100g/100ml
	private String fileName; //Name of image file
	
	/**
	 * Ingredient Constructor
	 * @param name - Name of ingredient
	 * @param foodGroup - Food group ingredient belongs too
	 * @param calories - Calories of ingredient per 100g/100ml
	 * @param fileName - File name for ingredient's image
	 * @throws Exception If data cannot be written correctly, error describes reason(s)
	 */
	public Ingredient(String name, FoodType foodGroup, int calories, String fileName) throws Exception {
		this.ID = nextID++;
		String error = ""; //Any errors made when constructing added to this string
		try {
			this.setName(name);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setFoodGroup(foodGroup);;
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setCalories(calories);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setFileName(fileName);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		
		if (error != "") {
			throw new Exception("\nData could not be written\nReason(s):"+error);
		}
	}
	
	/**
	 * Ingredient Constructor - with default fileName
	 * @param name - Name of ingredient
	 * @param foodGroup - Food group ingredient belongs too
	 * @param calories - Calories of ingredient per 100g/100ml
	 * @param fileName - File name for ingredient's image
	 * @throws Exception If data cannot be written correctly, error describes reason(s)
	 */
	public Ingredient(String name, FoodType foodGroup, int calories) throws Exception {
		this.ID = nextID++;
		String error = ""; //Any errors made when constructing added to this string
		try {
			this.setName(name);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setFoodGroup(foodGroup);;
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setCalories(calories);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			String fileName = "";
			for (int i=0; i<name.length(); i++) {
				if (name.charAt(i) != ' ') {
					fileName += name.charAt(i);
				}
			}
			fileName += ".png";
			this.setFileName(fileName);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		
		if (error != "") {
			throw new Exception("\nData could not be written\nReason(s):"+error);
		}
	}
	
	//Setters
	/**
	 * Sets the ingredient name
	 * @param name - Name of ingredient 
	 * @throws Exception - if name passed is invalid 
	 */
	public void setName(String name) throws Exception {
		name = name.trim();
		if (name != "" && name != null ) {
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
	 * Sets the food group of ingredient
	 * @param foodGroup - Food group ingredient belongs too
	 * @throws Exception - if reference passed is null
	 */
	public void setFoodGroup(FoodType foodGroup) throws Exception {
		if (foodGroup != null) {
			this.foodGroup = foodGroup;
		} else {
			throw new Exception("Invalid Food Group");
		}
	}
	/**
	 * Sets ingredient's calories
	 * @param calories - Calories of ingredient per 100g/100ml
	 * @throws Exception - if calories passed is invalid
	 */
	public void setCalories(int calories) throws Exception {
		if (calories > -1 && calories < 1000) {
			this.calories = calories;
		} else {
			throw new Exception("Calories must be 0-999");
		}
	}
	/**
	 * Sets ingredient's image file name
	 * @param fileName - Name of image file 
	 * @throws Exception - if name passed is invalid
	 */
	public void setFileName(String fileName) throws Exception {
		if (Utility.isFileName(fileName)) {
			this.fileName = fileName;
		} else {
			throw new Exception("File name cannot contain spaces or characters: \\ / : | < > *");
		}
	}
	//Getters
	/**
	 * Returns ingredient's ID
	 * @return - Ingredient ID
	 */
	public int getID() {
		return this.ID;
	}
	/**
	 * Returns ingredient's Name
	 * @return - Name of ingredient
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Returns ingredient's Food Group as a string
	 * @return - Food group as a string
	 */
	public String getFoodGroupStr() {
		return (this.foodGroup).toString();
	}
	/**
	 * Returns ingredient's Food Group as a FoodType object
	 * @return - Food group as a FoodType object
	 */
	public FoodType getFoodGroup() {
		return this.foodGroup;
	}
	/**
	 * Returns ingredient's Calories
	 * @return - Calories of ingredient per 100g/100ml
	 */
	public int getCalories() {
		return this.calories;
	}
	/**
	 * Returns ingredient image file name
	 * @return - File name of image 
	 */
	public String getFileName() {
		return this.fileName;
	}
	/**
	 * Returns path to image file 
	 * @return - path to ingredient's image file
	 */
	public String getImgPath() {
		return "/images/Ingredients/"+this.fileName;
	}
	
	
	public String toString() {
		return "ID: "+this.ID+"\nName: "+this.name+"\nFood Group: "+getFoodGroupStr()+"\nCalories: "+this.calories;
	}
}
