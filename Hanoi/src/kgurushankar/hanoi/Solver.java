package kgurushankar.hanoi;

public class Solver {

	public static void main(String args[]) {
		Game g = new Game(10);
		Solver s = new Solver(g);
		s.hanoi(10, 1, 3);
	}

	private Game g;

	public Solver(Game g) {
		this.g = g;
		System.out.println(g);
		hanoi(g.size(), 1, 3);
		System.out.println(g);
	}

	public void hanoi(int n, int from, int to) {
		if (n <= 1) {
			move(from, to);
		} else {
			hanoi(n - 1, from, (6 - from - to));
			move(from, to);
			hanoi(n - 1, (6 - from - to), to);
		}
	}

	private void move(int from, int to) {
		g.moveDisk(from, to);
	}

}
