package midtermproject;

/*
 * 	Grand Circus Java Bootcamp
 * 		April 2018 Cohort
 * 		Midterm Project - Minefield
 * 			John Aoraha, Tim Pieniazek, Victoria Rush, Jonah Wooten
 * 			https://github.com/Jonah-Wooten/MineField
 */
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		int input = 0; // input for user menu selection
		String fu; // string to select flag or uncover
		int row;
		int column;
		int max = 0; // integer used to narrow row and column selection

		String[][] array;

		System.out.println("Welcome to minefield!");

		System.out.println("Please select a minefield size:");
		System.out.println("1. 3x3");
		System.out.println("2. 4x4");
		System.out.println("3. 5x5");
		System.out.println("4. Exit");

		Scanner scan = new Scanner(System.in);
		input = Validator.getInt(scan, "Enter a selection: ", 1, 4);

		while (input != 4) {
			if (input == 1) {
				System.out.println("You've selected a 3x3 grid: ");
				max = 3;
			}
			if (input == 2) {
				System.out.println("You've selected a 4x4 grid: ");
				max = 4;
			}
			if (input == 3) {
				System.out.println("You've selected a 5x5 grid: ");
				max = 5;
			}
			if (input == 4) {
				System.out.println("Goodbye!");
			}

			array = Grid.generateDisplay(max, max);

			// gameOver(array); just here for test

			while (true) {
				System.out.println();
				Display.renderGrid(array); // display grid
				System.out.println();

				fu = Validator.getString(scan, "Would you like to (f)flag a mine or (u)uncover a cell?  ");

				if (fu.equalsIgnoreCase("f")) {
					System.out.println("You've chosen to flag a cell.  Which cell would you like to flag?");
					row = Validator.getInt(scan, "Enter row(x): ", 1, max);
					column = Validator.getInt(scan, "Enter column(y): ", 1, max);
					Display.clearScreen();
					array = toggleFlag(array, row - 1, column - 1);
					input = 4;
				} else if (fu.equalsIgnoreCase("u")) {
					System.out.println("You've chosen to uncover a cell.  Which cell would you like to uncover?");
					row = Validator.getInt(scan, "Enter row(x): ", 1, max);
					column = Validator.getInt(scan, "Enter column(y): ", 1, max);
					Display.clearScreen();
					array[row - 1][column - 1] = revealMine(row-1, column-1);
					input = 4;
				} else {
					System.out.println("Invalid selection.");
				}
			}

		}
		System.out.println("Goodbye!");

	}

	public static String[][] toggleFlag(String[][] tempArray, int x, int y) {

		if (tempArray[x][y].equals("O")) {
			tempArray[x][y] = "F";
		} else if (tempArray[x][y].equals("F")) {
			tempArray[x][y] = "O";
		}
		return tempArray;

	}

	public static String revealMine(int x, int y) {
		int i = MinesNear.calculateMinesNear(Grid.secret, x, y);
		if (i == 0) {
			return " ";
		} else if (i == 9) {
			return "!";
		} else
			return Integer.toString(i);

	}

	public static void gameOver(String[][] temp) {
		Display.clearScreen();
		System.out.println("Game Over!");
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = revealMine(i, j);
			}
		}
		Display.renderGrid(temp);

	}
}
