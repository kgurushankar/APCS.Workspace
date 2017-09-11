package com.google.challenges.level1;

import java.util.Scanner;

public class Answer {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println(answer(in.nextLine()));
	}

	public static int answer(String s) {
		int[] test = factor(s.length());
		for (int i = test.length - 1; i >= 0; i--) {
			String[] pieces = new String[test[i]];
			for (int j = 0; j < pieces.length; j++) {
				pieces[j] = s.substring((j) * (s.length() / test[i]), (j + 1) * (s.length() / test[i]) );
			}
			boolean clear = true;
			for (int j = 1; j < pieces.length; j++) {
				if (!(pieces[j].equals(pieces[0]))) {
					clear = false;
					break;
				}
			}
			if (clear)
				return test[i];
		}
		return 1;
	}

	public static int[] factor(int i) {
		boolean[] x = new boolean[i];
		int j = 0;
		for (int n = 1; n <= i; n++) {
			if (i % n == 0) {
				x[n - 1] = true;
				j++;
			}
		}
		int[] out = new int[j];
		int k = 0;
		for (int n = 1; n <= i; n++) {
			if (x[n - 1]) {
				out[k] = n;
				k++;
			}
		}
		return out;

	}
}
