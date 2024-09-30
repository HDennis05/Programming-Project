package part03;

import java.awt.Color;
import java.awt.Font;
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
		Application.DisplayTitle(this.title);

		QUBKitchen.con.println("\n");
		displayOptions(); 
	}

	/**
	 * Displays menu options
	 */
	private void displayOptions() {
		for (int option = 1; option <= items.length; option++) {
			QUBKitchen.con.println(option + ". " + items[option - 1]);
		}
	}

	/**
	 * Asks the user for their input
	 * @return - User's input
	 */
	public String getUserChoice() {
		display();
		QUBKitchen.con.println();
		QUBKitchen.con.print("Enter Choice: ");
		String value = QUBKitchen.con.readLn();
		return value;
	}

	/**
	 * Polymorphic
	 * <br>getUserChoice with option to display no title
	 * @param title - true if title should be displayed, false if not
	 * @return - User's input
	 */
	public String getUserChoice(boolean title) {
		if (title == true) {
			display();
		} else {
			displayOptions();
		}
		QUBKitchen.con.println();
		QUBKitchen.con.print("Enter Choice: ");
		String value = QUBKitchen.con.readLn();
		return value;
	}
}
