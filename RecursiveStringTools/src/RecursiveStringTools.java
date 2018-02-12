import java.util.Scanner;

public class RecursiveStringTools {

	// Example
	public static int length(String in) {
		if (in.equals("")) {
			return 0;
		} else {
			return 1 + length(in.substring(1));
		}
	}

	// Example
	public static boolean equals(String in1, String in2) {
		if (in1.length() != in2.length()) {
			return false;
		} else if (in1 == "" || in2 == "") {
			return true;
		} else if (in1.charAt(0) != in2.charAt(0)) {
			return false;
		} else {
			return equals(in1.substring(1), in2.substring(1));
		}
	}

	// Exercise #1
	public static boolean matches(String in1, String in2) {
		if (in1.length() != in2.length()) {
			return false;
		} else if (in1.length() == 0 && in2.length() == 0) {
			return true;
		} else {
			boolean eq = in1.charAt(0) == '?' || '?' == in2.charAt(0) || in1.charAt(0) == in2.charAt(0);
			String str1 = in1.substring(1);
			String str2 = in2.substring(1);
			return eq && matches(str1, str2);
		}

	}

	// Exercise #2
	public static boolean isPalindrome(String in) {
		if (in.length() <= 1) {
			return true;
		} else {
			if (!Character.isLetter(in.charAt(0))) {
				return isPalindrome(in.substring(1));
			} else if (!Character.isLetter(in.charAt(in.length() - 1))) {
				return isPalindrome(in.substring(0, in.length() - 1));
			} else if (in.charAt(0) != in.charAt(in.length() - 1)) {
				return false;
			} else {
				return isPalindrome(in.substring(1, in.length() - 1));
			}
		}
	}

	// Exercise #3
	public static void printPermutations(String in) {
		anagram("", in);
	}

	private static void anagram(String start, String end) {
		if (end.length() <= 1) {
			System.out.println(start + end);
		} else {
			run(start, end, 0);
		}
	}

	private static void run(String start, String end, int i) {
		char cur = end.charAt(i);
		String before = end.substring(0, i);
		String after = end.substring(i + 1);
		anagram(start + cur, before + after);
		if (i + 1 < end.length()) {
			run(start, end, i + 1);
		}
	}

	public static String piglatinate(String in) {
		if (in.contains(" ")) { // sentence case
			return piglatinate(in.substring(0, in.indexOf(" "))) + " "
					+ piglatinate(in.substring(in.indexOf(" ") + 1, in.length()));
		} else if (isVowel(in.charAt(0))) { // 1st letter Vowel
			return in + "yay";
		} else {
			int loc = containsVowel(in);
			if (loc == -1) { // has no vowel
				return in + "ay";
			} else {
				String end = in.substring(loc);
				String start = in.substring(0, loc);
				if (Character.isUpperCase(start.charAt(0))) {
					final int SHIFT = 32;
					end = (char) (end.charAt(0) - SHIFT) + end.substring(1);
					start = (char) (start.charAt(0) + SHIFT) + start.substring(1);
				}
				return end + start + "ay";
			}
		}
	}

	public static int containsVowel(String in) {
		return containsVowel(in, 0);
	}

	private static int containsVowel(String in, int i) {
		if (in.length() == 0) {
			return -1;
		} else if (isVowel(in.charAt(i))) {
			return i;
		} else {
			return containsVowel(in, i + 1);
		}
	}

	private static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = kboard.nextLine();
		kboard.close();
		String out = RecursiveStringTools.piglatinate(s);
		System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
