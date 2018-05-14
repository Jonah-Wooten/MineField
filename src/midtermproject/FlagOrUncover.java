package midtermproject;

import java.util.Scanner;

public class FlagOrUncover {

	private static String fu;
	private static int row;
	private static int column;

	private static int input;
	private static boolean gameOver = false;

	public void FlagUncover(Scanner scan, int gridSize) {

		fu = Validator.getString(scan, "Would you like to (f)flag a mine or (u)uncover a cell?  ");

		if (fu.equalsIgnoreCase("f")) {
			System.out.println("You've chosen to flag a cell.  Which cell would you like to flag?");
			row = Validator.getInt(scan, "Enter row(x): ", 1, gridSize);
			column = Validator.getInt(scan, "Enter column(y): ", 1, gridSize);
			Display.clearScreen();
			MainApp.toggleFlag(row - 1, column - 1);
			input = 4;
		} else if (fu.equalsIgnoreCase("u")) {
			System.out.println("You've chosen to uncover a cell.  Which cell would you like to uncover?");
			row = Validator.getInt(scan, "Enter row(x): ", 1, gridSize);
			column = Validator.getInt(scan, "Enter column(y): ", 1, gridSize);
			Display.clearScreen();

			// Don't step on a flagged mine
			if (!MainApp.array[row - 1][column - 1].equals(MainApp.FLAG_CELL)) {
				MainApp.revealMine(row - 1, column - 1);
				if (MainApp.bombs[row - 1][column - 1]) {
					gameOver = true;
				}
			}
			input = 4;
		} else {
			System.out.println("Invalid selection.");
		}
	}

	public static int getInput() {
		return input;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

}
