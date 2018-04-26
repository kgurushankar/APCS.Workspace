package kgurushankar.crypt;

import java.io.*;
import java.util.Arrays;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms: Random
 * monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author kgurushankar
 * @version 1.0.0
 * 
 */
public class Crypt3 {

	/**
	 * 
	 * An integer representing the algorithm chosen. Set to: 1 for random
	 * monoalphabet 2 for Vigenere 3 for Playfair
	 * 
	 */
	public static final int algorithm = 3;

	/**
	 * Reads from the file specified, and writes out an encrypted version of the
	 * file. If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename
	 *            The path of the file to be encrypted.
	 * @param outputFilename
	 *            The path of the encrypted file to be saved.
	 * @param keyword
	 *            The keyword to be used in the encryption algorithm.
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) {
		BufferedReader in;
		PrintWriter out;
		try {
			in = new BufferedReader(new FileReader(inputFilename));
			out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
			char[][] map = new char[5][5];
			int i = 0;
			int j = 0;
			char[] a = keyword.toLowerCase().toCharArray();
			for (char c : a) {
				if (!contains(map, c, i, j)) {
					map[i][j] = c;
					j++;
					if (j > 4) {
						j = 0;
						i++;
					}
				}
			}
			if (i <= 4)
				for (char c = 'a'; c <= 'z'; c++) {
					if (!contains(map, c, i, j)) {
						map[i][j] = c;
						j++;
						if (j > 4) {
							j = 0;
							i++;
							if (i > 4) {
								break;
							}
						}
					}
				}
			for (char[] c : map) {
				System.out.println(Arrays.toString(c));
			}
			int c1 = in.read();
			int c2 = in.read();
			StringBuffer s = new StringBuffer();
			do {
				while (!((c1 > 64 && c1 < 91) || (c1 > 96 && c1 < 123))) { // is not char
					s.append((char) c1);
					c1 = c2;
					c2 = in.read();
				}
				while (!((c2 > 64 && c2 < 91) || (c2 > 96 && c2 < 123))) { // is not char
					s.append((char) c2);
					c2 = in.read();
				}
				boolean caps1 = c1 > 64 && c1 < 91;
				boolean caps2 = c2 > 64 && c2 < 91;
				c1 += (caps1) ? 32 : 0;
				c2 += (caps2) ? 32 : 0;
				int[] loc1 = getLoc(map, (char) c1);
				int[] loc2 = getLoc(map, (char) c2);
				char c3, c4;
				if (loc1[1] == loc2[1]) {
					c3 = (char) (c2 - (caps1 ? 32 : 0));
					c4 = (char) (c1 - (caps2 ? 32 : 0));
				} else {
					c3 = (char) (map[loc1[0]][loc2[1]] - (caps1 ? 32 : 0));
					c4 = (char) (map[loc2[0]][loc1[1]] - (caps2 ? 32 : 0));
				}
				// this is somehow happening in the order c3, c4, s... confused af...
				s.insert(0, c3);
				s.append(c4);
				out.append(s.toString());
				s = new StringBuffer();
				c1 = in.read();
				c2 = in.read();
			} while (c1 != -1 && c2 != -1);
			if (c1 != -1 && c2 == -1) { // odd # of characters
				if (!((c1 > 64 && c1 < 91) || (c1 > 96 && c1 < 123))) {// not a character
					out.append((char) c1);
				} else {
					c2 = 'j';
					int[] loc1 = getLoc(map, (char) c1);
					int[] loc2 = getLoc(map, (char) c2);
					char c3 = map[loc1[0]][loc2[1]];
					char c4 = map[loc2[0]][loc1[1]];
					out.append(c3);
					out.append(c4);
				}
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reads from the (previously encrypted) file specified, and writes out a
	 * decrypted version of the file. If the output file already exists, overwrite
	 * it.
	 * 
	 * @param inputFilename
	 *            The path of the encrypted file.
	 * @param outputFilename
	 *            The path of the decrypted file to be saved.
	 * @param keyword
	 *            The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) {
		// BufferedReader in;
		// PrintWriter out;
		// try {
		// in = new BufferedReader(new FileReader(inputFilename));
		// out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
		// int x = keyword.length();
		// int[] shifts = new int[x];
		// for (int i = 0; i < x; i++) {
		// shifts[i] = keyword.charAt(i) - 97;
		// }
		// int m = 0;
		// int c = in.read();
		// do {
		// if (c > 64 && c < 91) { // upper
		// out.append((char) (((c + 13 - shifts[m]) % 26) + 65));
		// m = (m + 1) % shifts.length;
		// } else if (c > 96 && c < 123) {// lower
		// out.append((char) (((c + 7 - shifts[m]) % 26) + 97));
		// m = (m + 1) % shifts.length;
		// } else {// other stuff
		// out.append((char) c);
		// }
		//
		// c = in.read();
		// } while (c != -1);
		// in.close();
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	public boolean contains(char[][] arr, char target, int i, int j) {
		if (target == 'j') { // j maps to i
			target = 'i';
		}
		for (int x = 0; x < i; x++) {
			for (int y = 0; y < 5; y++) {
				if (arr[x][y] == target) {
					return true;
				}
			}
		}
		for (int y = 0; y <= j; y++) {
			if (arr[i][y] == target) {
				return true;
			}
		}
		return false;
	}

	public int[] getLoc(char[][] arr, char target) {
		if (target == 'j') { // j maps to i
			target = 'i';
		}
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				if (arr[x][y] == target) {
					return new int[] { x, y };
				}
			}
		}
		throw new IllegalArgumentException("target not found in the array");
	}
}
