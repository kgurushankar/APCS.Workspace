package kgurushankar.checkmail;

/** @author */
public class Package {
	private int x, y, z;
	private double weight;

	public Package(int x, int y, int z, double weight) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.weight = weight;
	}

	public String firstClass() {
		boolean isHeavy = weight >= 70;
		int girth, length;
		if (x > y && x > z) {
			girth = 2 * y + 2 * z;
			length = x;
		} else {
			if (y > x && y > z) {
				girth = 2 * x + 2 * z;
				length = y;
			} else {
				girth = 2 * x + 2 * y;
				length = z;
			}
		}

		if (isHeavy) {
			if (girth + length >= 100) {
				return "Package is too large and too heavy";
			} else {
				return "Package is too heavy";
			}
		} else {
			if (girth + length >= 100) {
				return "Package is too large";
			} else {
				return "Package is acceptable";
			}
		}

	}
}
