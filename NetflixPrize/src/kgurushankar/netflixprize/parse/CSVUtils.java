package kgurushankar.netflixprize.parse;

import java.util.ArrayList;

public class CSVUtils {
	private static final char escape = '"';
	private static final char delimitor = ',';

	public static String[] parseLine(String line) {
		ArrayList<String> tmp = new ArrayList<String>();
		StringBuilder current = new StringBuilder();
		int pos;
		boolean inEscape = false;
		for (pos = 0; pos < line.length(); pos++) {
			if (line.charAt(pos) == escape) {
				if (line.charAt(pos + 1) == escape) { // double escape
					current.append(escape);
					pos++;
					continue;
				} else {
					inEscape = !inEscape;
					continue;
				}
			} else if (inEscape) {
				current.append(line.charAt(pos));
			} else if (line.charAt(pos) == delimitor) {
				tmp.add(current.toString());
				current.delete(0, current.length());
			} else {
				current.append(line.charAt(pos));
			}
		}
		tmp.add(current.toString());
		current.delete(0, current.length());
		String[] out = new String[tmp.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = tmp.get(i);
		}
		return out;
	}
}
