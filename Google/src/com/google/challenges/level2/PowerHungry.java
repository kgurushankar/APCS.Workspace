package com.google.challenges.level2;

import java.math.BigInteger;

public class PowerHungry {
	// Count number of zeroes and if it is xs.lenngth-1 0s return 0

//	public static String answer(int[] xs) {
//		int pos = 0;
//		int neg = 0;
//		int low = Integer.MIN_VALUE;
//		long[] v = new long[(int) Math.ceil(xs.length / 6d)];
//		for (int i = 0; i < v.length; i++) {
//			v[i] = xs[6 * i];
//			if (xs[6 * i] > 0) {
//				pos++;
//			} else {
//				neg++;
//				if (xs[i] > low) {
//					low = xs[i];
//				}
//			}
//		}
//		for (int i = 1; i < xs.length; i++) {
//			if (i % 6 != 0) {
//				v[i / 6] *= xs[i];
//				if (xs[i] > 0) {
//					pos++;
//				} else {
//					neg++;
//					if (xs[i] > low) {
//						low = xs[i];
//					}
//				}
//			}
//		}
//		BigInteger num = BigInteger.valueOf(1);
//		for (long l : v) {
//			num = num.multiply(BigInteger.valueOf(l));
//		}
//		if (xs.length == 1) {
//			return String.valueOf(xs[0]);
//		} else if ((pos + neg) == 0) { // all 0
//			return "0";
//		} else if (neg == 1 && pos == 0) {
//			return "0";
//		} else if (num.abs().equals(num)) {
//			return num.toString();
//		} else {
//			return (num.divide(BigInteger.valueOf(low))).toString();
//		}
//	}

	public static String answer(int[] xs) {
		int pos = 0;
		int neg = 0;
		BigInteger num = new BigInteger("1");
		int low = Integer.MIN_VALUE;
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] != 0) {
				num = num.multiply(BigInteger.valueOf(xs[i]));
				if (xs[i] > 0) {
					pos++;
				} else {
					neg++;
					if (xs[i] > low) {
						low = xs[i];
					}
				}
			}
		}
		if (xs.length == 1) {
			return String.valueOf(xs[0]);
		} else if ((pos + neg) == 0) { // all 0
			return "0";
		} else if (neg == 1 && pos == 0) {
			return "0";
		} else if (num.abs().equals(num)) {
			return num.toString();
		} else {
			return (num.divide(BigInteger.valueOf(low))).toString();
		}
	}

	// public static String answer(int[] xs) {
	// int p = 0, n = 0;
	// int[] post = new int[xs.length];
	// int[] negt = new int[xs.length];
	// for (int i = 0; i < xs.length; i++) {
	// if (xs[i] > 0) {
	// post[p++] = xs[i];
	// } else if (xs[i] < 0) {
	// negt[n++] = xs[i];
	// }
	// }
	// int[] neg = new int[n];
	// int small = Integer.MIN_VALUE;
	// for (int i = 0; i < neg.length; i++) {
	// small = Math.max(small, negt[i]);
	// neg[i] = negt[i];
	// }
	// int[] pos = new int[p];
	// for (int i = 0; i < pos.length; i++) {
	// pos[i] = post[i];
	// }
	//
	// if (xs.length == 1) {// only 1 number
	// return String.valueOf(xs[0]);
	// } else if (pos.length + neg.length == 0 && xs.length >= 1) {// only 0s
	// return "0";
	// } else if (pos.length + neg.length == 1) {// 1 nonnegative number
	// if (pos.length == 1) {// 1 positive number
	// return String.valueOf(pos[0]);
	// } else {// 1 negative number
	// if (xs.length > 1) {// also 0s
	// return String.valueOf(xs[0]);
	// } else {// only number
	// return String.valueOf(neg[0]);
	// }
	// }
	// } else {//general solution
	// BigInteger one = BigInteger.valueOf(1);
	// for (int a : pos) {
	// one.multiply(BigInteger.valueOf(a));
	// }
	// BigInteger two = BigInteger.valueOf(1);
	// for (int a : neg) {
	// two.multiply(BigInteger.valueOf(a));
	// }
	// if (neg.length % 2 != 0) {
	// two.divide(BigInteger.valueOf(small));
	// }
	// return (one.multiply(two)).toString();
	// }
	// }

	public static void main(String[] args) {
		long n = System.currentTimeMillis();
		int[] xs = { 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023,
				1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023,
				1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023,
				1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023 };
		String res = (answer(xs));
		System.out.println(res);
		System.out.println(System.currentTimeMillis() - n);
		// int tmp = 0;
		// for (char c : res.toCharArray()) {
		// if (c == '0')
		// tmp++;
		// }
		// System.out.println(tmp);
	}
}