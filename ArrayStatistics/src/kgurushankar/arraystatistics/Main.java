package kgurushankar.arraystatistics;

public class Main {
	public static void main(String args[]) {
		int[] arr = new int[1000];
		for (int i = 0; i < 5; i++) {
			System.out.println("File number: " + i);
			new ArrayReader("Data/numbers" + i + ".txt").fillArray(arr);
			Statistics s = new Statistics(arr);
			System.out.println(s.average());
			System.out.println(s.standardOfDeviation());
			for (int x : s.mode()) {
				System.out.print(x + ", ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
