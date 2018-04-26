package kgurushankar.crypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Compare {
	public static void main(String[] args) {
		String iline = null, aline = null;
		BufferedReader in, ans;
		try {

			ans = new BufferedReader(new FileReader("data.ans"));
			in = new BufferedReader(new FileReader("data.out"));

			while ((iline = in.readLine()) != null && (aline = ans.readLine()) != null) {
				if (!iline.equals(aline)) {
					System.out.println(iline);
					System.out.println(aline);
					System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
