package midtermproject;

public class MinesNear {

	public static int calculateMinesNear(boolean mines[][], int x, int y) {
		int minesNear = 0;
		int rows = mines.length;
		int columns = mines[0].length;
		int xBegin, xEnd, yBegin, yEnd;

		// Determine if we're on an edge and set indices so we don't go outside the
		// mines array
		if (x == 0) {
			xBegin = 0;
		} else {
			xBegin = x - 1;
		}
		if (x == mines.length) {
			xEnd = mines.length;
		} else {
			xEnd = x + 1;
		}

		if (y == 0) {
			yBegin = 0;
		} else {
			yBegin = y - 1;
		}
		if (y == mines.length) {
			yEnd = mines.length;
		} else {
			yEnd = y + 1;
		}

		if (mines[x][y]) {
			// Oh no! They hit a mine!
			minesNear = 9;
		} else {
			// Cycle through rows nearby
			for (int i = xBegin; i <= xEnd; i++) {
				// Cycle through columns nearby
				for (int j = yBegin; j <= yEnd; j++) {
					// Don't count the cell we're in
					if (i != j) {
						// if there's a mine, count it
						if (mines[i][j]) {
							minesNear++;
						}
					}
				}
			}
		}

		return minesNear;
	}
}
