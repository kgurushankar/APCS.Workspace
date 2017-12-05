package kgurushankar.arrays.statistics;

import java.util.Arrays;

public class SortAndPrint {
	public static void main(String args[]) {
		int[] arr = new int[1000];
		int i = 4;
		new ArrayReader("Data/numbers" + i + ".txt").fillArray(arr);
		Arrays.sort(arr);
		for (int x : arr) {
			System.out.println(x);
		}
	}
}
