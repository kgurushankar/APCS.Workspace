package kgurushankar.arraystatistics;

import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		// Compact : 84065831
		// N1:115394813
		// N2:92434995
		// N3:164627476
		// N4:105257734

		long t;
		int[] arr = new int[10000];
		long time = System.nanoTime();
		int l = new ArrayReader("Data/numbers4.txt").fillArray(arr);
		Statistics s = new Statistics(arr, l);
		System.out.println(s.compact());
		t = System.nanoTime() - time;
		System.out.println(t);
		System.out.println();

		for (int i = 0; i < 5; i++) {
			arr = new int[10000];
			time = System.nanoTime();
			System.out.println("File number: " + i);
			l = new ArrayReader("Data/numbers" + i + ".txt").fillArray(arr);
			s = new Statistics(arr, l);
			s.compact();
			System.out.println("Average: " + s.average());
			System.out.println("Standard of Deviation: " + s.standardOfDeviation());
			System.out.println("Mode: " + Arrays.toString(s.mode()));
			t = System.nanoTime() - time;
			System.out.println(t);
			System.out.println();
		}

	}
}
