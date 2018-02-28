package kgurushankar.maze;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

public class DP {

	private int[][] grid;
	private char[][] sol;
	public int[][] exit;
	public int[] entrance;

	public DP() {
		this(20, 20);
	}

	public DP(int r, int w) {
		grid = new int[r][w];
	}

	// Constructs the grid defined in the file specified
	public DP(String filename) {
		this(filename, 20, 20);
	}

	public DP(String filename, int r, int w) {
		grid = new int[r][w];
		readData(filename, grid);
		solve();
	}

	private void solve() {
		// write grid
		setup();

		// choose best exit
		int curr = grid[exit[0][0]][exit[0][1]];
		int index = 0;
		for (int i = 1; i < exit.length; i++) {
			int dist = grid[exit[i][0]][exit[i][1]];
			if (dist != 0 && dist < curr) {
				index = i;
				curr = dist;
			}
		}
		sol = getSolutionTo(exit[index]);
	}

	public void setup() {
		setup(entrance, 1);
	}

	// is diag legal?
	// out of bounds check?
	// leave a trail dont numerically backwork just yet
	private void setup(int[] coords, int curr) {
		if (coords[0] < 0 || coords[0] >= grid.length - 1) {// out of bounds
			return;
		} else if (coords[1] < 0 || coords[1] >= grid[coords[0]].length - 1) {// out of bounds
			return;
		} else if (grid[coords[0]][coords[1]] == -1) {// wall
			return;
		} else if (grid[coords[0]][coords[1]] == 0 || grid[coords[0]][coords[1]] > curr) {// on path OR already explored
																							// but with longer path
			grid[coords[0]][coords[1]] = curr;
			curr++;
			setup(new int[] { coords[0] + 1, coords[1] }, curr);// right
			setup(new int[] { coords[0] - 1, coords[1] }, curr);// left
			setup(new int[] { coords[0], coords[1] + 1 }, curr);// up
			setup(new int[] { coords[0], coords[1] - 1 }, curr);// down
		}

	}

	public void readData(String filename, int[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++) {
						if (i < gameData.length && count < gameData[i].length) {
							if (line.charAt(i) == '#') {
								gameData[count][i] = -1;
							} else if (line.charAt(i) == '.') {
								gameData[count][i] = 0;
							} else if (line.charAt(i) == 'C') {
								gameData[count][i] = 0;
								entrance = new int[] { count, i };
							} else if (line.charAt(i) == 'X') {
								gameData[count][i] = 0;
								if (exit == null) {
									exit = new int[][] { { count, i } };
								} else {
									int[][] oldexit = exit;
									exit = new int[oldexit.length + 1][2];
									for (int j = 0; j < oldexit.length; j++) {
										exit[j] = oldexit[j];
									}
									exit[oldexit.length] = new int[] { count, i };
								}
							} else {
								gameData[count][i] = -1;
							}
						}
					}
					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++) {
				s.append(sol[i][j]);
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
		float px = x;
		float py = y;
		float ix = width / grid.length;
		float iy;
		for (int i = 0; i < grid.length; i++) {
			iy = height / grid[i].length;
			for (int j = 0; j < grid[i].length; j++) {
				marker.text(grid[j][i], px, py);
				px += ix;
			}
			py += iy;
			px = x;
		}
	}

	public char[][] getSolutionTo(int[] coords) {
		char[][] out = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				out[i][j] = (grid[i][j] == -1) ? '#' : '.';
			}
		}
		out[entrance[0]][entrance[1]] = 'C';
		for (int[] e : exit) {
			out[e[0]][e[1]] = 'X';
		}
		int[] loc = coords;
		while (grid[loc[0]][loc[1]] > 2) { // last one was more than 2 so last run will happen on 2 leaving 1, the
											// initial location
			loc = getPrevCell(loc);
			out[loc[0]][loc[1]] = '!';
		}
		return out;
	}

	public int getDistTo(int[] coords) {
		return grid[coords[0]][coords[1]];
	}

	private int[] getPrevCell(int[] coords) {
		int curr = grid[coords[0]][coords[1]];
		if (coords[0] > 0 && grid[coords[0] - 1][coords[1]] == curr - 1) {
			return new int[] { coords[0] - 1, coords[1] };
		} else if (coords[0] < grid.length - 1 && grid[coords[0] + 1][coords[1]] == curr - 1) {
			return new int[] { coords[0] + 1, coords[1] };
		} else if (coords[1] > 0 && grid[coords[0]][coords[1] - 1] == curr - 1) {
			return new int[] { coords[0], coords[1] - 1 };
		} else if (coords[1] < grid[coords[0]].length - 1 && grid[coords[0]][coords[1] + 1] == curr - 1) {
			return new int[] { coords[0], coords[1] + 1 };
		} else {
			return new int[] { -1 };
		}
	}
}
