package part01;

public enum Unit {
	/*
	 * Enum to describe Units of measurement
	 */
	MILLILITRES("ml"),
	GRAMS("g"),
	UNDEFINED("Undefined");
	
	private String unitStr; //Unit as a string
	
	/**
	 * Unit constructor
	 * @param unit - Unit as a string
	 */
	private Unit(String unit) {
		this.unitStr = unit;
	}
	/**
	 * Unit to String
	 * @return Unit as a string
	 */
	public String toString() {
		return unitStr;
	}
}
