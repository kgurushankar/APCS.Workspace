package kgurushankar.crypt;

import java.io.*;

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
public class Crypt1 {

	/**
	 * 
	 * An integer representing the algorithm chosen. Set to: 1 for random
	 * monoalphabet 2 for Vigenere 3 for Playfair
	 * 
	 */
	public static final int algorithm = 1;

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
	 * @throws Exception
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) {
		BufferedReader in;
		BufferedWriter out;
		try {
			in = new BufferedReader(new FileReader(inputFilename));
			out = new BufferedWriter(new FileWriter(outputFilename));

			StringBuffer d = new StringBuffer(26);
			char[] a = keyword.toLowerCase().toCharArray();
			for (char c : a) {
				if (d.indexOf(Character.toString(c)) == -1) {
					d.append(c);
				}
			}
			for (char i = 'z'; i >= 'a'; i--) {
				if (d.indexOf(Character.toString(i)) == -1) {
					d.append(i);
				}
			}
			char[] dictionary = new char[26];
			for (int i = 0; i < 26; i++) {
				dictionary[i] = d.charAt(i);
			}
			int c = in.read();
			do {
				if (c > 64 && c < 91) { // upper
					out.append((char) (dictionary[c - 65] - 32));
				} else if (c > 96 && c < 123) {// lower
					out.append((dictionary[c - 97]));
				} else {// other stuff
					out.append((char) c);
				}
				c = in.read();
			} while (c != -1);
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
		BufferedReader in;
		PrintWriter out;
		try {

			in = new BufferedReader(new FileReader(inputFilename));
			out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));

			StringBuffer d = new StringBuffer(26);
			char[] a = keyword.toLowerCase().toCharArray();
			for (char c : a) {
				if (d.indexOf(Character.toString(c)) == -1) {
					d.append(c);
				}
			}
			for (char i = 'z'; i >= 'a'; i--) {
				if (d.indexOf(Character.toString(i)) == -1) {
					d.append(i);
				}
			}
			String dictionary = d.toString();
			int c = in.read();
			do {
				if (c > 64 && c < 91) { // upper
					out.append((char) (dictionary.indexOf(c + 32) + 65));
				} else if (c > 96 && c < 123) {// lower
					out.append((char) (dictionary.indexOf(c) + 97));
				} else {// other stuff
					out.append((char) c);
				}
				c = in.read();
			} while (c != -1);
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
