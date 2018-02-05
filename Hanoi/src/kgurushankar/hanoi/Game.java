package kgurushankar.hanoi;

public class Game {
	int[][] game; // left to right, bottom to top

	public Game(int tiles) {
		game = new int[3][tiles];
		for (int j = 0; j < game[0].length; j++) {
			game[0][j] = j;
		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				if (game[j][i] != 0) {
					sb.append(game[j][i]);
				} else {
					sb.append('-');
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	public int size() {
		return game[0].length;
	}

	private boolean legal(int peg) {
		peg = peg - 1;
		for (int i = 0; i < game[peg].length - 1; i++) {
			if (game[peg][i] < game[peg][i + 1]) {
				return false;
			}
		}
		return true;
	}

	private boolean legal() {
		for (int i = 1; i <= game.length; i++) {
			if (!legal(i)) {
				return false;
			}
		}
		return true;
	}

	private int findTopDisk(int peg) {
		for (int i = game[peg].length - 1; i >= 0; i--) {
			if (game[peg][i] != 0) {
				return i;
			}
		}
		return -1;
	}

	public boolean moveDisk(int from, int to) {
		from = from - 1;
		to = to - 1;
		int f = findTopDisk(from);
		if (f == -1) {
			return false;
		}
		int t = findTopDisk(to);
		if (t == 9) {
			return false;
		}
		game[to][t + 1] = game[from][f];
		game[from][f] = 0;
		if (legal()) {
			return true;
		} else {
			game[from][f] = game[to][t + 1];
			game[to][t + 1] = 0;
			return false;
		}
	}
}
