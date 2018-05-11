package midtermproject;

public class Grid {

	// hard coated test
	public final boolean[][] secret =

			{ { false, false, false }, { false, true, true }, { true, true, false } };

	public boolean[][] random;
	public int mineCount;

	public boolean[][] getRandom() {
		return random;
	}

	public void setRandom(boolean[][] random) {
		this.random = random;
	}

	public int getMineCount() {
		return mineCount;
	}

	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}

	public Grid(boolean[][] random, int mineCount) {
		super();
		this.random = random;
		this.mineCount = mineCount;

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

}
