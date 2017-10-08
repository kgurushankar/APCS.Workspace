package com.google.challenges.level2;

public class LuckyLambs {
	public static int answer(int total_lambs) {
		int count = 2;
		int total = 2;
		int x1 = 1; // index-1
		int x2 = 1; // index-2
		while (total <= total_lambs) {
			count++;
			int tmp = x2;
			x2 = x1;
			x1 = tmp + x2;
			total += x1;
		}

		return (count - 1) - log2(total_lambs + 1);
	}

	public static int log2(int in) {
		int log = (int) (Math.log(in) / Math.log(2));
		int used = (int) Math.pow(2, log) - 1;
		int left = in - used;
		int needed = ((int) Math.pow(2, log - 1)) + ((int) Math.pow(2, log - 2));
		if (left > needed) {
			return log + 1;
		} else {
			return log;
		}
	}

	public static void main(String args[]) {
		long n = System.currentTimeMillis();

		System.out.println(answer(14));

		System.out.println(System.currentTimeMillis() - n);
	}
}
