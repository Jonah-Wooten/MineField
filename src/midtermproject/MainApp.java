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

	static boolean[][] bombs;

	static String[][] array;

	static int winCount;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input = 0; // input for user menu selection
		String fu; // string to select flag or uncover
		int row;
		int column;
		int max = 0; // integer used to narrow row and column selection
		String cont = "y";

		int mineCount;

		System.out.println("Welcome to minefield!");

		while (cont.equalsIgnoreCase("y")) {
			boolean gameOver = false;
			System.out.println("Please select a minefield size:");
			System.out.println("1. 3x3");
			System.out.println("2. 4x4");
			System.out.println("3. 5x5");
			System.out.println("4. Exit");

			input = Validator.getInt(scan, "Enter a selection: ", 1, 4);

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
				max = 8;
			}
			if (input == 4) {
				// System.out.println("Goodbye!");
				gameOver = true;
				cont = "n";
			}

			mineCount = (int) (max * max / 5);
			//mineCount = 1;

			winCount = max * max - mineCount;

			bombs = Grid.setBombs3(max, max, mineCount);

			array = Grid.generateDisplay(max, max);

			// gameOver(array); //just here for test
			if (input != 4) {
				while (!gameOver && winCount > -1) {
					System.out.println();
					Display.renderGrid(array); // display grid
					System.out.println();

					fu = Validator.getString(scan, "Would you like to (f)flag a mine or (u)uncover a cell?  ");

					if (fu.equalsIgnoreCase("f")) {
						System.out.println("You've chosen to flag a cell.  Which cell would you like to flag?");
						row = Validator.getInt(scan, "Enter row(x): ", 1, max);
						column = Validator.getInt(scan, "Enter column(y): ", 1, max);
						Display.clearScreen();
						toggleFlag(row - 1, column - 1);
						input = 4;
					} else if (fu.equalsIgnoreCase("u")) {
						System.out.println("You've chosen to uncover a cell.  Which cell would you like to uncover?");
						row = Validator.getInt(scan, "Enter row(x): ", 1, max);
						column = Validator.getInt(scan, "Enter column(y): ", 1, max);
						Display.clearScreen();
						revealMine(row - 1, column - 1);
						// openSurroundingFields(row -1, column -1);
						if (bombs[row - 1][column - 1]) {
							gameOver = true;
						}
						input = 4;
					} else {
						System.out.println("Invalid selection.");
					}

				}
				// where does this go?
				if (winCount <= 0) {
					System.out.println("\nCongratulations! You've WON!!!\n");
					
					Display.renderGrid(array);
					Display.clearScreen();
					
					
				}

				if (gameOver) {
					gameOver();
				}

				cont = Validator.getYesOrNo(scan, "Would you like to continue (y/n?): ");
				System.out.println();
			}
		}

		System.out.println();
		System.out.println("Goodbye!");

	}

	// Method checks if the position in the display array is an "O"
	// if it is, then the space hasn't been clicked before so it
	// is safe to decrement our winCount
	public static void decWinCount(int x, int y) {
		// System.out.println(winCount);
		if (array[x][y].equals("O")) {
			winCount--;
		}
		//System.out.println(winCount);
		// Display.renderGrid(array);
		// System.out.println(winCount);
		// System.out.println();
	}

	public static void toggleFlag(int x, int y) {

		if (array[x][y].equals("O")) {
			array[x][y] = "F";
		} else if (array[x][y].equals("F")) {
			array[x][y] = "O";
		}
	}

	public static void revealMine(int x, int y) {
		int i = MinesNear.calculateMinesNear(bombs, x, y);
		 decWinCount(x, y);
		if (i == 0) {
			// array[x][y] = " ";
			openSurroundingFields(x, y);
		} else if (i == 9) {
			array[x][y] = "!";
		} else {
			array[x][y] = Integer.toString(i);
		}

	}

	// Runs out of revealMine() if the space is " " aka zero.
	// cycles around that spot in a 3X3 grid to reveal those spot
	// if it finds another zero-spot (not already revealed), then it recurs itself
	public static void openSurroundingFields(int i, int e) {
		for (int j = i - 1; j < i + 2; j++)
			for (int h = e - 1; h < e + 2; h++)
				if ((j > -1) && (j < array.length) && (h > -1) && (h < array[0].length) && (array[j][h] != " ")) {
					if (MinesNear.calculateMinesNear(bombs, j, h) == 0) {
						 decWinCount(j, h);
						array[j][h] = " ";
						openSurroundingFields(j, h);
					} else if (MinesNear.calculateMinesNear(bombs, j, h) != 9) {
						 decWinCount(j, h);
						array[j][h] = Integer.toString(MinesNear.calculateMinesNear(bombs, j, h));
					}
				}
	}

	// This means you lost.. =(
	// fills out rest of gameboard, so you can know what you did wrong
	public static void gameOver() {
		Display.clearScreen();
		System.out.println("Game Over!");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				revealMine(i, j);
			}
		}
		Display.renderGrid(array);
		System.out.println();

	}
}
