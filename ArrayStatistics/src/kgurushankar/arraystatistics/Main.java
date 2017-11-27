package kgurushankar.arraystatistics;

public class Main {
	public static void main(String args[]) {
		for (int i = 0; i < 5; i++) {
			int[] arr = new int[10000];
			System.out.println("File number: " + i);
			int l = new ArrayReader("Data/numbers" + i + ".txt").fillArray(arr);
			Statistics s = new Statistics(arr,l);
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
