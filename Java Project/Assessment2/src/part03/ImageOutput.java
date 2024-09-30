package part03;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import console.Console;

public class ImageOutput {

	public static void main(String[] args) {
		// define a console
		Console test = new Console(true);
		test.setSize(1200, 500);
		test.setVisible(true);

		// set background colour for console
		test.setBgColour(Color.BLACK);
		// set font for console
		test.setFont(new Font("Courier", Font.BOLD, 20));
		// set text colour for console
		test.setColour(Color.WHITE);
		
		do { // infinite loop until user 'quits'
			// clear the console
			test.clear();
			
			// request user input
			test.print("Select Suit - (S)pades, (D)iamonds, (C)lubs, (H)earts or (Q)uit : ");
			String value = test.readLn();
			value = value.trim();
			if (value.length() > 0) {
				if (value.charAt(0) == 'Q' || value.charAt(0) == 'q')
					System.exit(1);	// quit the app
				printSuit(value, test); // output a card suit
			}
		} while (true); // an infinite loop
	}

	// prints a card suit - 'suit' is the chosen suit
	// picks up card images from 'Images' directory
	// create a corresponding 'ImageIcon' object and prints to console
	public static void printSuit(String suit, Console con) {
		
		String userdir = System.getProperty("user.dir");
		
		String path = userdir + "/Images/Cards/";
		switch (suit) {
		case "S":
		case "s":
			path += "Spades/";
			break;
		case "D":
		case "d":
			path += "Diamonds/";
			break;
		case "C":
		case "c":
			path += "Clubs/";
			break;
		case "H":
		case "h":
			path += "Hearts/";
			break;
		default:
			path = null;
		}

		if (path != null) {
			ImageIcon img = new ImageIcon(path + "A.png"); // Ace
			con.print(img);
			con.print(" "); // leave a gap between images
			for (int card = 2; card <= 10; card++) { // cards between 2 and 10
				img = new ImageIcon(path + card + ".png");
				con.print(img);
				con.print(" ");
			}
			img = new ImageIcon(path + "J.png"); // Jack
			con.print(img);
			con.print(" ");
			img = new ImageIcon(path + "Q.png"); // Queen
			con.print(img);
			con.print(" ");
			img = new ImageIcon(path + "K.png"); // King
			con.print(img);
			con.println();
		}
		con.print("Hit RETURN to continue.");
		con.readLn();
	}

}
