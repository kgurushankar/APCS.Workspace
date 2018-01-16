import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/**
 *
 * Represents a Game Of Life grid.
 *
 * @author kgurushankar
 * @date 1/11/18
 *
 */

public class Life {
	private boolean[][] grid;

	// Constructs an empty grid
	public Life() {
		this(20, 20);
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		this();
		readData(filename, grid);
	}

	public Life(int r, int w) {
		grid = new boolean[r][w];
	}

	// Runs a single turn of the Game Of Life
	// Uses 2 buffer arrays instead of making whole new copy
	public void step() {
		boolean[][] tmp = new boolean[2][]; // [last,current]
		for (int i = 0; i < grid.length; i++) {
			tmp[1] = new boolean[grid[i].length];
			for (int j = 0; j < grid[i].length; j++) {
				tmp[1][j] = processCell(i, j);
			}
			if (tmp[0] != null) {
				grid[i - 1] = tmp[0];
			}
			tmp[0] = tmp[1];
		}
		grid[grid.length - 1] = tmp[0];
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				s.append((grid[j][i]) ? '*' : ' ');
			}
			s.append('\n');
		}
		return s.toString();
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData(String filename, boolean[][] gameData) {
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
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length && line.charAt(i) == '*')
							gameData[i][count] = true;

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
		float iy = height / grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[j][i]) {
					marker.fill(Color.WHITE.getRGB());
				} else {
					marker.fill(Color.BLACK.getRGB());

				}
				marker.rect(px, py, ix, iy);
				px += ix;
			}
			py += iy;
			px = x;
		}
	}

	/**
	 * Optionally, complete this method to determine which element of the grid
	 * matches with a particular pixel coordinate.
	 *
	 * @param p
	 *            A Point object representing a graphical pixel coordinate.
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
	 * @return A Point object representing a coordinate within the game of life
	 *         grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		double X = p.getX() - x;
		double Y = p.getY() - y;
		int c = (int) (grid.length * X / width);
		int r = (int) (grid[c].length * Y / height);
		return new Point(c, r);

	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 *
	 * @param i
	 *            The x coordinate of the cell in the grid.
	 * @param j
	 *            The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		grid[i][j] = !grid[i][j];
	}

	private boolean processCell(int i, int j) {
		int n = 0;
		n += (j > 0 && i > 0 && grid[i - 1][j - 1]) ? 1 : 0;
		n += (j > 0 && grid[i][j - 1]) ? 1 : 0;
		n += (j > 0 && i < (grid.length - 1) && grid[i + 1][j - 1]) ? 1 : 0;

		n += (i > 0 && grid[i - 1][j]) ? 1 : 0;
		n += (i < (grid.length - 1) && grid[i + 1][j]) ? 1 : 0;

		n += (j < (grid[i].length - 1) && i > 0 && grid[i - 1][j + 1]) ? 1 : 0;
		n += (j < (grid[i].length - 1) && grid[i][j + 1]) ? 1 : 0;
		n += (j < (grid[i].length - 1) && i < (grid.length - 1) && grid[i + 1][j + 1]) ? 1 : 0;

		if (n <= 1 || n >= 4) {
			return false;
		} else if (n == 3) {
			return true;
		} else { // (n==2)
			return grid[i][j];
		}
	}

	public int countColumn(int j) {
		j--;
		int n = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][j]) {
				n++;
			}
		}
		return n;
	}

	public int countRow(int i) {
		i--;
		int n = 0;
		for (int j = 0; j < grid.length; j++) {
			if (grid[i][j]) {
				n++;
			}
		}
		return n;
	}

	public int countAllCells() {
		int n = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) {
					n++;
				}
			}
		}
		return n;
	}

	public boolean equals(Object o) {
		Life other = (Life) o;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (other.grid[i][j] != this.grid[i][j]) {
					System.out.println(i + "  " + j);
					return false;
				}
			}
		}
		return true;
	}
}