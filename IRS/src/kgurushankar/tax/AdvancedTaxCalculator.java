package kgurushankar.tax;

import java.text.NumberFormat;

public class AdvancedTaxCalculator {
	private Bracket bracket;

	public AdvancedTaxCalculator(Bracket b) {
		this.bracket = b;
	}

	public String calculateTax(String status, String income) {
		int s;
		double i;
		try {
			s = Integer.parseInt(status.trim());
		} catch (Exception e) {
			return "-1";
		}
		try {
			i = Double.parseDouble(income.trim());
		} catch (Exception e) {
			return "-1";
		}
		if (s < 0 || s >= bracket.getStatus().length) {
			return "-1";
		}

		return calculateTax(s, i);
	}

	public String calculateTax(int status, double income) {
		double out = -1;
		int[] brackets = bracket.getBrackets(status);
		double[] percentages = bracket.getPercentages(status);
		int i = 0;
		while (i < brackets.length - 1 && income > brackets[i + 1]) {
			out += (brackets[i + 1] - brackets[i]) * percentages[i];
			i++;
		}
		out += percentages[i] * (income - brackets[i]);
		if (Math.abs(out + 1) < 1e-7) {
			return "-1";
		} else {
			out += 1;
		}
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(out);
	}

	public Bracket getBracket() {
		return this.bracket;
	}
}
