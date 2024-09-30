package part03;

public enum MealType {
	/*
	 * Enum to describe a Recipes meal type
	 */
	STARTER("Starter"),
	MAIN("Main"),
	DESSERT("Dessert"),
	UNDEFINED("Undefined");
	
	private String mealStr; //Meal type as string
	
	/**
	 * Meal Type Constructor
	 * @param meal - Meal type as a string
	 */
	private MealType(String meal) {
		this.mealStr = meal;
	}
	/**
	 * Meal Type to String
	 * @return - Meal type as a string
	 */
	public String toString() {
		return mealStr;
	}
}
