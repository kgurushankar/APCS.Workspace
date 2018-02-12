import processing.core.PApplet;

/**
 *
 * Represents a Game Of Life grid.
 *
 * @author kgurushankar
 * @date 1/11/18
 *
 */

public class Two048 {
	private int[][] grid;

	// Constructs an empty grid
	public Two048() {
		grid = new int[4][4]; // [row][column]
		this.spawnNew();
	}

	// Runs a single turn of the Game Of 2048
	/**
	 *
	 * @param dir
	 *            direction to move the cells in
	 *            <table>
	 *            <tr>
	 *            <td></td>
	 *            <td>0</td>
	 *            <td></td>
	 *            </tr>
	 *            <tr>
	 *            <td>3</td>
	 *            <td></td>
	 *            <td>1</td>
	 *            </tr>
	 *            <tr>
	 *            <td></td>
	 *            <td>2</td>
	 *            <td></td>
	 *            </tr>
	 *            </table>
	 */
	public void step(int dir) {
		Two048 old = this.clone();
		if (dir == 0) { // Up
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (j < 3 && grid[j][i] == grid[j + 1][i] && grid[j][i] != 0) {
						grid[j][i]++;
						grid[j + 1][i] = 0;
					}
					for (int k = 0; k < 4; k++) {
						if (k < 3 && grid[k][i] == 0) {
							grid[k][i] = grid[k + 1][i];
							grid[k + 1][i] = 0;
						}
					}
				}
			}
		} else if (dir == 1) { // Right
			for (int i = 3; i >= 0; i--) {
				for (int j = 3; j >= 0; j--) {
					if (j > 0 && grid[i][j] == grid[i][j - 1] && grid[i][j] != 0) {
						grid[i][j]++;
						grid[i][j - 1] = 0;
					}
					for (int k = 3; k >= 0; k--) {
						if (k > 0 && grid[i][k] == 0) {
							grid[i][k] = grid[i][k - 1];
							grid[i][k - 1] = 0;
						}
					}
				}
			}
		} else if (dir == 2) { // Down
			for (int i = 3; i >= 0; i--) {
				for (int j = 3; j >= 0; j--) {
					if (j > 0 && grid[j][i] == grid[j - 1][i] && grid[j][i] != 0) {
						grid[j][i]++;
						grid[j - 1][i] = 0;
					}
					for (int k = 3; k >= 0; k--) {
						if (k > 0 && grid[k][i] == 0) {
							grid[k][i] = grid[k - 1][i];
							grid[k - 1][i] = 0;
						}
					}
				}
			}
		} else if (dir == 3) { // Left
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (j < 3 && grid[i][j] == grid[i][j + 1] && grid[i][j] != 0) {
						grid[i][j]++;
						grid[i][j + 1] = 0;
					}
					for (int k = 0; k < 4; k++) {
						if (k < 3 && grid[i][k] == 0) {
							grid[i][k] = grid[i][k + 1];
							grid[i][k + 1] = 0;
						}
					}
				}
			}
		}
		if (!this.equals(old)) {
			spawnNew();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				s.append((int) Math.pow(2, grid[i][j]));
			}
			s.append('\n');
		}
		return s.toString();
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 *
	 * @param marker
	 *            The PApplet used for drawing.
	 * @param x
	 *            The x pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param y
	 *            The y pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param width
	 *            The pixel width of the grid drawing.
	 * @param height
	 *            The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.textFont(marker.createFont("Comic Sans", 32), 32);
		float px = x;
		float py = y;
		float ix = width / grid.length;
		float iy;
		for (int i = 0; i < grid.length; i++) {
			iy = height / grid[i].length;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					marker.text((int) Math.pow(2, grid[i][j]), px + ix / 2, py + iy / 2);
				}
				px += ix;
			}
			py += iy;
			px = x;
		}
	}

	public boolean equals(Object o) {
		Two048 other = (Two048) o;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (other.grid[i][j] != this.grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public Two048 clone() {
		Two048 n = new Two048();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				n.grid[i][j] = this.grid[i][j];
			}
		}
		return n;
	}

	public void spawnNew() {
		int set = (Math.random() < 0.9) ? 1 : 2;
		while (true && !fill()) {
			int x = (int) (Math.random() * 4);
			int y = (int) (Math.random() * 4);
			if (grid[x][y] == 0) {
				grid[x][y] = set;
				return;
			}
		}

	}

	private boolean fill() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean movePossible() {
		Two048 u = this.clone();
		Two048 d = this.clone();
		Two048 l = this.clone();
		Two048 r = this.clone();
		u.step(0);
		d.step(2);
		r.step(1);
		l.step(3);
		if (u.equals(this) && d.equals(this) && l.equals(this) && r.equals(this)) {
			return false;
		}
		return true;
	}

	public boolean lose() {
		return fill() && !movePossible();
	}

	public boolean win() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 12) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void makeWin() {
		grid = new int[][] { { 1, 1, 2, 3 }, { 7, 6, 5, 4 }, { 8, 9, 10, 11 }, { 15, 14, 13, 12 } };
	}
}