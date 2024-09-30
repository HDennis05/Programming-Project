package part03;

/**
 * Class to represent Weekly menu
 * <br>Allows Adding, Updating and Removal of recipes from Weekly Menu
 * @author Hannah Dennis - 40406567
 */
public class WeeklyMenu {
	private Recipe[] monday = { null, null, null }; //Array of Monday's meals - initialised to null
	private Recipe[] tuesday = { null, null, null }; //Array of Tuesday's meals - initialised to null
	private Recipe[] wednesday = { null, null, null }; //Array of Wednesday's meals - initialised to null
	private Recipe[] thursday = { null, null, null }; //Array of Thursday's meals - initialised to null
	private Recipe[] friday = { null, null, null }; //Array of Friday's meals - initialised to null
	private Recipe[][] days = {monday,tuesday,wednesday,thursday,friday}; //2-Dimensional Array of all meals for the week

	/**
	 * WeeklyMenu constructor
	 */
	public WeeklyMenu() {
	}

	/**
	 * Adds recipe to a specific day and course
	 * @param recipe - Recipe to be added
	 * @param day - Day the recipe will be on
	 * @param course - Course the recipe will be
	 * @throws Exception if data passed is invalid
	 */
	public void addRecipe(Recipe recipe, int day, int course) throws Exception {
		String error = "";
		if (recipe == null) {
			error += "\nRecipe cannot be null";
		}
		
		if (day < 1 || day > 5) {
			error += "\nDay must be 1-5";
		}
		
		if (course < 1 || course > 3) {
			error += "\nCourse must be 1-3";
		}
		
		if (error.equals("")) {
			Recipe[] chosenDay = days[day-1]; //get day array
			chosenDay[course-1] = recipe; //set to recipe
		} else {
			throw new Exception("\nErrors: "+error);
		}
	}	
	
	/**
	 * Removes recipe from a specific day and course
	 * @param day - Day the recipe is on
	 * @param course - Course the recipe is
	 * @throws Exception if data passed is invalid
	 */
	public void removeRecipe(int day, int course) throws Exception {
		String error = "";
		if (day < 1 || day > 5) {
			error += "\nDay must be 1-5";
		}
		
		if (course < 1 || course > 3) {
			error += "\nCourse must be 1-3";
		}
		
		if (error.equals("")) {
			Recipe[] chosenDay = days[day-1]; //get day array
			chosenDay[course-1] = null; //set to null
		} else {
			throw new Exception("Errors: "+error);
		}
		
	}
	
	/**
	 * Clear entire menu
	 * <br>Setting all meals to null
	 */
	public void clearMenu() {
		for (int i = 1; i<6; i++){ //for all days
			for (int j = 1; j<4; j++) { // for every course
				try {
					this.removeRecipe(i,j); //set to null
				} catch(Exception e) {
				}
			}
		}
	}
	
	/**
	 * Checks if the Weekly menu is entirely empty
	 * @return true if empty <br> false if any recipes exist
	 */
	public boolean isEmpty() {
		boolean empty = true; //if menu is empty
		for (int i = 0; i<5; i++) { //for all days
			for (int j = 0; j<3; j++) { //for every course
				if (days[i][j] != null) { //if recipe is not null menu isn't empty
					empty = false; 
					return empty;
				}
			}
		}
		return empty;
	}
	
	/**
	 * Weekly Menu to string
	 * @return String of Days and all their respective meals
	 */
	public String toString() {
		String string = ""; 
		string += "\nDay        Starter             Main                 Dessert\n\n";
		String[] dayNames = {"Monday","Tuesday","Wednesday","Thursday","Friday"}; 
		for (int i = 0; i<5; i++) { //for all days
			string += String.format("%1$-11s", dayNames[i]);
			for (int j = 0; j<3; j++) { //for every course
				if (days[i][j] == null) { 
					string += "-----          ";
				} else {
					String tempRecipe = days[i][j].getName(); 
					if (tempRecipe.length() <= 15) {
						string += String.format("%1$-15s", tempRecipe);
					} else {
					string += tempRecipe.substring(0,14)+"-";
					}
				}
				if (j == 3) { //add new line after third recipe
					string += "\n";
				} else {
					string += "     ";
				}
			}
		}
		string += "\n";
		return string;
	}

}
	
