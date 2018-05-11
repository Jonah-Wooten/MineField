package midtermproject;

/*
 * 	Grand Circus Java Bootcamp
 * 		April 2018 Cohort
 * 		Midterm Project - Minefield
 * 			John Aoraha, Tim Pieniazek, Victoria Rush, Jonah Wooten
 * 			https://github.com/Jonah-Wooten/MineField
 */
public class Display {

	public static void renderGrid(int x, int y) {
		// int i cycles through x-coordinates
		for (int i = 0; i <= x; i++) {
			
			// int j cycles through y-coordinates
			for (int j = 0; j <= y; j++) {

				// first row displays " " + 1 to y
				if (i == 0 && j == 0) {
					System.out.print("  ");

				} else if (i == 0) {
					System.out.print(" " + j);
					
				// following rows display x + "OOOO..."
				} else if (j == 0) {
					System.out.print("\n " + i);
					
				} else {
				System.out.print(" O");
				
				}
			}
		}
		System.out.println();
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
