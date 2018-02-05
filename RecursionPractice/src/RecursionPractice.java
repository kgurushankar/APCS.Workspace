
public class RecursionPractice {
	public static void main(String[] args) {
		hanoi(6, 1, 3);
		System.out.println(i);
	}

	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return -1;
		}
		return factorial(n - 1) * n;
	}

	/*
	 * Eqn = past two counts + 1 Recursive 1 - 930971 - 1 2 - 437281 - 3 3 - 426098
	 * - 5 4 - 412068 - 9 5 - 608166 - 15 6 - 437831 - 25 7 - 517493 - 41 8 - 603016
	 * - 67 9 - 495385 - 109 10 - 392357 - 177 20 - 726085 - 21891 30 - 6879389 -
	 * 2692537 40 - 559759423 - 331160281 45 -6093736858 - 3672623805
	 *
	 * Eqn = n-1 Looping 1 - 500722 - 0 2 - 532874 - 1 3 - 448931 - 2 4 - 351921 - 3
	 * 5 - 484969 - 4 6 - 1624699 - 5 7 - 472491 - 6 8 - 476554 - 7 9 - 657057 - 8
	 * 10 - 349141 - 9 20 - 315767 - 19 30 - 393908 - 29 40 - 437823 - 39 45 -
	 * 431806 - 44
	 *
	 *
	 *
	 * Pattern in timing data: Recursion causes a huge increase as n becomes higher.
	 * Looping stays almost the same and probably is linear on larger cases.
	 * Recursion iterations_n = iterations_(n-1) + iterations_(n-2) +1 Looping
	 * iterations_n = n-1 Looping is faster because it does not recalculate anything
	 */
	public static long fibbonaci(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else if (n < 0) {
			return -1;
		}
		return fibbonaci(n - 1) + fibbonaci(n - 2);
	}

	public static long fib(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		}
		long num0 = 0;
		long num1 = 1;
		long tmp;
		for (int i = 1; i < n; i++) {
			tmp = num0 + num1;
			num0 = num1;
			num1 = tmp;
		}
		return num1;
	}

	public void printHanoiSolution(int numberOfDisks) {
		hanoi(numberOfDisks, 1, 3);
	}

	static int i = 0;

	private static void hanoi(int n, int from, int to) {
		i++;
		if (n <= 1) {
			printHanoi(from, to);
		} else {
			hanoi(n - 1, from, (6 - from - to));
			printHanoi(from, to);
			hanoi(n - 1, (6 - from - to), to);
		}
	}

	private static void printHanoi(int from, int to) {
		System.out.println("Move the top disk from peg " + from + " to peg " + to);
	}
}
