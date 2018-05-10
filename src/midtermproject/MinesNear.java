package midtermproject;

public class MinesNear {

	public int calculateMinesNear(boolean mines[][], int x, int y) {
		int minesNear = 0;
		if (mines[x][y]) {
			// Oh no! They hit a mine!
			minesNear = 9;
		} else {
			// Cycle through rows nearby
			for (int i = x - 1; i <= x + 1; i++) {
				// Cycle through columns nearby
				for (int j = y - 1; j <= y + 1; j++) {
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
