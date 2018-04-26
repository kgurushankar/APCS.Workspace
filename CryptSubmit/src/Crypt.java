
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
public class Crypt {

	/**
	 * 
	 * An integer representing the algorithm chosen. Set to: 1 for random
	 * monoalphabet 2 for Vigenere 3 for Playfair
	 * 
	 */
	public static final int algorithm = 2;


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
			int x = keyword.length();
			int[] shifts = new int[x];
			for (int i = 0; i < x; i++) {
				shifts[i] = keyword.charAt(i) - 97;
			}
			int m = 0;
			int c = in.read();
			do {
				if (c > 64 && c < 91) { // upper
					out.append((char) (((c + 13 + shifts[m]) % 26) + 65));
					m = (m + 1) % shifts.length;
				} else if (c > 96 && c < 123) {// lower
					out.append((char) (((c + 7 + shifts[m]) % 26) + 97));
					m = (m + 1) % shifts.length;
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
			int x = keyword.length();
			int[] shifts = new int[x];
			for (int i = 0; i < x; i++) {
				shifts[i] = keyword.charAt(i) - 97;
			}
			int m = 0;
			int c = in.read();
			do {
				if (c > 64 && c < 91) { // upper
					out.append((char) (((c + 13 - shifts[m]) % 26) + 65));
					m = (m + 1) % shifts.length;
				} else if (c > 96 && c < 123) {// lower
					out.append((char) (((c + 7 - shifts[m]) % 26) + 97));
					m = (m + 1) % shifts.length;
				} else {// other stuff
					out.append((char)c);
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
