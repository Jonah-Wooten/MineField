package midtermproject;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		int input = 0; // input for user menu selection
		String fu; // string to select flag or uncover
		int row;
		int column;
		int max = 0; // integer used to narrow row and column selection

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

			System.out.println();
			Display.renderGrid(max, max);	//display grid
			System.out.println();
			System.out.println();


			fu = Validator.getString(scan, "Would you like to (f)flag a mine or (u)uncover a cell?  ");

			if (fu.equalsIgnoreCase("f")) {
				System.out.println("You've chosen to flag a cell.  Which cell would you like to flag?");
				row = Validator.getInt(scan, "Enter row(x): ", 1, max);
				column = Validator.getInt(scan, "Enter column(y): ", 1, max);
				input = 4;
			} else if (fu.equalsIgnoreCase("u")) {
				System.out.println("You've chosen to uncover a cell.  Which cell would you like to uncover?");
				row = Validator.getInt(scan, "Enter row(x): ", 1, max);
				column = Validator.getInt(scan, "Enter column(y): ", 1, max);
				input = 4;
			} else {
				System.out.println("Invalid selection.");
			}

		}
		System.out.println("Goodbye!");

	}
}
