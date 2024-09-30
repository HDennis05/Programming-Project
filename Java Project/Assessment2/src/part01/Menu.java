package part01;

import java.util.Scanner;

/**
 * Provides menu that displays a title and options to the user and gets their choice
 * @author Hannah Dennis - 40406567
 */
public class Menu {
	private String items[]; //Menu options
	private String title; //Menu title
	private Scanner input; 

	/**
	 * Menu constructor
	 * @param title - title for menu
	 * @param data - menu options
	 */
	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}

	/**
	 * Displays Menu Title 
	 */
	private void display() {
		System.out.println();
		for (int count = 0; count < title.length(); count++) {
			System.out.print("-");
		}
		System.out.println("\n" + title);
		for (int count = 0; count < title.length(); count++) {
			System.out.print("-");
		}

		System.out.println();
		displayOptions(); 
	}

	/**
	 * Displays menu options
	 */
	private void displayOptions() {
		for (int option = 1; option <= items.length; option++) {
			System.out.println(option + ". " + items[option - 1]);
		}
		System.out.println();

	}

	/**
	 * Asks the user for their input
	 * @return - User's input
	 */
	public int getUserChoice() {
		display();
		System.out.print("Enter Choice: ");
		int value = input.nextInt();
		return value;
	}

	/**
	 * Polymorphic
	 * <br>getUserChoice with option to display no title
	 * @param title - true if title should be displayed, false if not
	 * @return - User's input
	 */
	public int getUserChoice(boolean title) {
		if (title == true) {
			display();
		} else {
			displayOptions();
		}
		System.out.print("Enter Choice: ");
		int value = input.nextInt();
		return value;
	}
}
