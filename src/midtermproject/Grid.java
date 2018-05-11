package midtermproject;

import java.util.Arrays;

/*
 * 	Grand Circus Java Bootcamp
 * 		April 2018 Cohort
 * 		Midterm Project - Minefield
 * 			John Aoraha, Tim Pieniazek, Victoria Rush, Jonah Wooten
 * 			https://github.com/Jonah-Wooten/MineField
 */
public class Grid {

	// hard coated test
	public final boolean[][] secret =

			{ { false, false, false }, { false, true, true }, { true, true, false } };

	public final boolean[][] secret2 = { { true, true, true, false }, { true, false, true, false },
			{ false, true, true, false }, { false, true, false, true } };

	public final boolean[][] secret3 = { { false, false, true, false, false }, { true, true, false, true, true },
			{ true, false, true, false, true }, { false, true, false, true, false },
			{ true, true, true, false, false } };

	public boolean[][] randomGrid;
	public int mineCount;

	public String[][] displayGrid;

	public Grid(boolean[][] random, int mineCount) {
		super();
		this.randomGrid = random;
		this.mineCount = mineCount;
	}

	public Grid(String[][] displayGrid) {
		super();
		this.displayGrid = displayGrid;
	}

	public static boolean[][] generateRandom(int x, int y) {
		return new boolean[x][y];

	}

	public static String[][] generateDisplay(int x, int y) {
		String[][] temp = new String[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = "O";
			}
		}
		return temp;
	}

	public boolean[][] getRandom() {
		return randomGrid;
	}

	public void setRandom(boolean[][] random) {
		this.randomGrid = random;
	}

	public int getMineCount() {
		return mineCount;
	}

	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}

	public String[][] getDisplayGrid() {
		return displayGrid;
	}

	public void setDisplayGrid(String[][] displayGrid) {
		this.displayGrid = displayGrid;
	}

	public static Grid setBombs(Grid g) {
		int x = g.getRandom().length;
		int y = g.getRandom()[0].length;
		g.getRandom();

		// When all mines are placed, exit out of Recursive Method.
		if (g.mineCount == 0) {

			return g;
		} else {
			// generate a random xy coordinant for a random Array
			int rx = (int) Math.random() * x;
			int ry = (int) Math.random() * y;
			//
			if (g.getRandom()[rx][ry] == false) {
				g.getRandom()[rx][ry] = true;
				g.mineCount--;

			}
			return setBombs(g);
		}

	}

	public static void main(String[] args);{
		boolean [][] test;
		boolean [][] pleaseWork = new boolean[3][3];
		pleaseWork = setBoms3(3,3,4);
		
		for(boolean)[]row: pleaseWork){
			System.out.println(Arrays.toString(row));
		}
		public static boolean[][] setBombs3(int x, int y, int mineCount){
			
			boolean[][] temp = new boolean [x][y];
			ArrayList<Boolean> bombScrable = new ArrayList<>();
			
			for(int i = 0; i < mineCount; i++) {
				bombScramble.add(true);
				
				int notBomb = x * y - mineCount;
				
				for(int i =0; i < notBomb; i++) {
					bombScramble.add(false);
					
					Collection.shuggle(bombScramble);
					
					int index = 0;
					for (int i = 0; i < x; i++);{
						temp[i][j] = bombScramble.get(index++);
					}
				}
				return temp;
			}
			
		}
	}
}
