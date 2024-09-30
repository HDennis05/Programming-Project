package part03;

/**
 * Class to represent a measurement of an ingredient in recipe
 * <br>Allows the ingredient, its amount and its unit to be easily contained together
 * @author Hannah Dennis - 40406567
 */
public class Measurement {
	private Ingredient ingredient; //Ingredient the amount is of
	private int amount; //Amount of ingredient
	private Unit unit; //Unit amount is in

	/**
	 * Measurement Constructor
	 * @param ingredient - Ingredient of measurement
	 * @param amount - Amount of Ingredient
	 * @param unit - Unit of Amount
	 * @throws Exception - If data cannot be written correctly, error describes reason(s)
	 */
	public Measurement(Ingredient ingredient, int amount, Unit unit) throws Exception {
		this.ingredient = ingredient;
		this.amount = amount;
		this.unit = unit;
		String error = ""; //Any errors made when constructing added to this string
		try {
			this.setIngredient(ingredient);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setAmount(amount);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}
		try {
			this.setUnit(unit);
		} catch (Exception e) {
			error += "\n";
			error += e;
		}

		if (error != "") {
			throw new Exception("\nData could not be written\nReason(s):" + error);
		}
	}

	//Setters
	/**
	 * Sets Measurement Ingredient
	 * @param ingredient - Ingredient of measurement
	 * @throws Exception - if reference passed is null
	 */
	public void setIngredient(Ingredient ingredient) throws Exception {
		if (ingredient != null) {
			this.ingredient = ingredient;
		} else {
			throw new Exception("Ingredient cannot be null");
		}
	}
	/**
	 * Sets Measurements Amount 
	 * @param amount - amount of ingredient in recipe
	 * @throws Exception - if amount passed is invalid
	 */
	public void setAmount(int amount) throws Exception {
		if (amount > 0 && amount < 10000) {
			this.amount = amount;
		} else {
			throw new Exception("Amount must be 1-9999");
		}
	}
	/**
	 * Sets Measurements Unit
	 * @param unit - unit of measurement
	 * @throws Exception - if reference passed is null
	 */
	public void setUnit(Unit unit) throws Exception {
		if (unit != null) {
			this.unit = unit;
		} else {
			throw new Exception("Unit cannot be null");
		}
	}

	//Getters
	/**
	 * Returns Measurement's Ingredient
	 * @return - Ingredient of measurement
	 */
	public Ingredient getIngredient() {
		return this.ingredient;
	}
	/**
	 * Returns Measurement's Amount
	 * @return - Amount of ingredient in recipe 
	 */
	public int getAmount() {
		return this.amount;
	}
	/**
	 * Returns Measurement's Unit as a string
	 * @return - Unit of measurement as a string
	 */
	public String getUnitStr() {
		return (this.unit).toString();
	}

	/**
	 * Returns Measurement's Unit as a Unit object
	 * @return - Unit of measurement as a Unit object
	 */
	public Unit getUnit() {
		return this.unit;
	}
}
