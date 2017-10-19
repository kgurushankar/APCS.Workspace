package kgurushankar.tax;

public class TaxCalculator {
	/**
	 * Calculates Tax based on status and income passed in as strings
	 * 
	 * @pre status must be "1" or "2"<br />
	 *      income must be a decimal without any symbols (in the format xxxxx.xx)
	 * 
	 * @return -1 if any parameters are incorrectly formatted
	 */
	public double calculateTax(String status, String income) {
		int s;
		double i;
		if (status.trim().equals("1")) {
			s = 1;
		} else if (status.trim().equals("2")) {
			s = 2;
		} else {
			return -1;
		}
		try {
			i = Double.parseDouble(income.trim());
		} catch (Exception e) {
			return -1;
		}

		return calculateTax(s, i);
	}

	public double calculateTax(int status, double income) {
		double out = -1;
		if (status == 1) {
			if (income >= 297350) {
				out = (income - 297350) * .391d + 93374;
			} else if (income >= 136750) {
				out = (income - 136750) * .355d + 36361;
			} else if (income >= 65550) {
				out = (income - 65550) * .305d + 14645;
			} else if (income >= 27050) {
				out = (income - 27050) * .275 + 4057.5;
			} else if (income >= 0) {
				out = (income) * .15;
			}
		} else if (status == 2) {
			if (income >= 297350) {
				out = (income - 297350) * .391d + 88306;
			} else if (income >= 166500) {
				out = (income - 166500) * .355d + 41855;
			} else if (income >= 109250) {
				out = (income - 109250) * .305d + 24393.75;
			} else if (income >= 45200) {
				out = (income - 45200) * .271d + 6780;
			} else if (income >= 0) {
				out = (income) * .15d;
			}
		}
		if (Math.abs(out + 1) < 1e-7) {
			return -1;
		}
		return (int) (Math.round(out * 100)) / 100d;
	}

}
