package part01;

public enum FoodType {
	/*
	 * Enum to describe an Ingredients Food Group
	 */
	DAIRY("Dairy"),
	FRUITVEG("Fruit & Veg"),
	COMP("Composite Food"),
	PROTEIN("Protein"),
	CEREAL("Cereal"),
	SUGAR("Sugar"),
	FAT("Fat"),
	SPICEHERB("Spice & Herb"),
	NUTRIENT("Essential Nutrient"),
	UNDEFINED("Undefined");
	
	private String foodStr; //Food type as string
	
	/**
	 * Food Type Constructor
	 * @param food - Food type as string
	 */
	private FoodType(String food) {
		this.foodStr = food;
	}
	/**
	 * Food Type To String
	 * @return - Food type as a string
	 */
	public String toString() {
		return foodStr;
	}
}
