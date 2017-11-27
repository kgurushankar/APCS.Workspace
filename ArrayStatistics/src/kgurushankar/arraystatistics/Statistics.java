package kgurushankar.arraystatistics;

import java.util.Arrays;

public class Statistics {
	private int[] arr;
	private int length;

	public Statistics(int[] arr) {
		this.arr = arr;
		Arrays.sort(this.arr);
	}

	public Statistics(int[] arr, int l) {
		this.arr = arr;
		this.length = l;
		Arrays.sort(this.arr, 0, l);
	}

	public double average() {
		long out = 0;
		for (int x : arr) {
			out += x;
		}
		return (out / (double) (arr.length));
	}

	public double standardOfDeviation() {
		double avg = average();
		double sq = 0;
		for (int x : arr) {
			double dif = (avg - x);
			sq += dif * dif;
		}
		double x = sq / (arr.length - 1);
		return Math.sqrt(x);
	}

	/*
	 * public int mode() { int countlast = 0; int numlast = 0; int count = 0; int
	 * num = 0; for (int i = 0; i < arr.length; i++) { if (num == arr[i]) { count++;
	 * } else if (count > countlast) { numlast = num; count = 0; num = 0; } } return
	 * numlast; }
	 */

	public int[] mode() {
		int[] count = new int[101];
		for (int i = 0; i < length; i++) {
			count[arr[i]]++;
		}
		int max = 0;
		int len = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				len = 1;
				max = count[i];
			} else if (count[i] == max) {
				len++;
			}
		}
		int[] out = new int[len];
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == max) {
				out[j] = i;
				j++;
			}
		}
		return out;
	}
}
