package midtermproject;

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

	public static boolean[][] setBombs2(boolean[][] boom, int mineCount) {
		int x = boom.length;
		int y = boom[0].length;
		// boom.getRandom();

		// When all mines are placed, exit out of Recursive Method.
		if (mineCount == 0) {

			return boom;
		} else {
			// generate a random xy coordinant for a random Array
			int rx = (int) Math.random() * x;
			int ry = (int) Math.random() * y;
			//
			if (boom[rx][ry] == false) {
				boom[rx][ry] = true;
				mineCount--;

			}
			return setBombs2(boom, mineCount);
		}
	}
}
