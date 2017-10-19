package kgurushankar.tax.brackets;

public abstract class Bracket {
	public String getStatusList() {
		StringBuffer out = new StringBuffer();
		String[] status = getStatus();
		for (int i = 0; i < status.length; i++) {
			out.append(i + "-" + status[i] + " ");
		}
		return out.toString().trim();
	}

	public abstract String[] getStatus();

	public abstract double[][] getPercentages();

	public double[] getPercentages(int status) {
		return getPercentages()[status];
	}

	public abstract int[][] getBrackets();

	public int[] getBrackets(int status) {
		return getBrackets()[status];
	}

	public static class US2001 extends Bracket {
		private static final String status[] = { "Single", "Married" };
		// [status][level] = %
		private static final double[][] percentages = { { 0.15, 0.275, 0.305, 0.355, 0.391 },
				{ 0.15, 0.275, 0.305, 0.355, 0.391 } };

		private static final int[][] brackets = { { 0, 27050, 65550, 136750, 297350 },
				{ 0, 45200, 109250, 166500, 297350 } };

		public String[] getStatus() {
			return status;
		}

		public double[][] getPercentages() {
			return percentages;
		}

		public int[][] getBrackets() {
			return brackets;
		}
	}

	public static class US2017 extends Bracket {
		private static final String status[] = { "Single", "Married", "Head of Household" };
		// [status][level] = %
		private static final double[][] percentages = { { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35, 0.396 },
				{ 0.10, 0.15, 0.25, 0.28, 0.33, 0.35, 0.396 }, { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35, 0.396 } };

		private static final int[][] brackets = { { 0, 9325, 37950, 91900, 191650, 416700, 418400 },
				{ 0, 18650, 75900, 153100, 233350, 416700, 470700 },
				{ 0, 13350, 50800, 131200, 212500, 416700, 444500 } };

		public String[] getStatus() {
			return status;
		}

		public double[][] getPercentages() {
			return percentages;
		}

		public int[][] getBrackets() {
			return brackets;
		}
	}
}
