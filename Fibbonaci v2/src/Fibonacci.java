
/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.Scanner;

public class Fibonacci {
	// Prestore is purely for speed purposes. Could have also made fibonacci
	// iterative though.
	private static final long prestore[][] = {
			{ 55l, 6765l, 832040l, 102334155l, 12586269025l, 1548008755920l, 190392490709135l, 22926177108782145l,
					2819729391889494700l },
			{ 34l, 4181l, 514229l, 63245986, 63245986l, 694395159899l, 108749917012166l, 14169084167416069l,
					1742688602675164321l } };

	// 20th Fibonacci number is 6765
	public static long computeFibonacci(int x) {
		if (x <= 1) {
			return x;
		} else if (x % 10 == 0 && x <= prestore[0].length * 10) {
			return prestore[0][(x / 10) - 1];
		} else if (x % 10 == 9 && x <= prestore[1].length * 10) {
			return prestore[1][((x + 1) / 10) - 1];
		} else {
			long two = computeFibonacci(x - 2);
			long one = computeFibonacci(x - 1);
			long answer = two + one;
			if (answer < one) {
				throw new IllegalArgumentException("Input too big, Overflow " + x); // biggest number is 92
			}
			return answer;
		}

	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		Scanner in = new Scanner(System.in);
		System.out.print("Which fibonacci number would you like to find? --> ");
		boolean legal = false;
		while (!legal) {
			try {
				int x = Integer.parseInt(in.next());
				if (x < 0)
					throw new IllegalArgumentException(x + "");
				long answer = computeFibonacci(x);
				System.out.println("The " + x + " fibonacci number is " + answer + ".");
				legal = true;
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer less than " + Integer.MAX_VALUE);
			} catch (IllegalArgumentException e) {
				if (e.getMessage().contains("Input too big, Overflow")) {
					System.out.println("Please enter a smaller number");
				} else {
					System.out.println("Please enter a positive integer");
				}
			} catch (StackOverflowError e) {
				System.out.println("Input number too big");
			}
		}
		in.close();
	}

}
