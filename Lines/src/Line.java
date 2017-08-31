import processing.core.PApplet;

public class Line {
	private int[][] points;

	public Line(int mouseX, int mouseY, int mouseX2, int mouseY2) {
		points = new int[2][2];
		points[0][0] = mouseX;
		points[0][1] = mouseY;
		points[1][0] = mouseX2;
		points[1][1] = mouseY2;
	}

	public void draw(PApplet applet) {
		applet.line(points[0][0], points[0][1], points[1][0], points[1][1]);
	}

	public boolean intersects(Line l2) {
		try {
			int x1 = this.points[0][0];
			int y1 = this.points[0][1];
			int x2 = this.points[1][0];
			int y2 = this.points[1][1];
			int x3 = l2.points[0][0];
			int y3 = l2.points[0][1];
			int x4 = l2.points[1][0];
			int y4 = l2.points[1][1];

			int x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4))
					/ ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
			int y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4))
					/ ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

			return this.contains(x, y) && l2.contains(x, y);
		} catch (Exception e) {
			return false;
		}
	}

	public void setPoint2(int mouseX, int mouseY) {
		points[1][0] = mouseX;
		points[1][1] = mouseY;

	}

	private boolean contains(int x, int y) {
		try {
			int m = (this.points[0][1] - this.points[1][1]) / (this.points[0][0] - this.points[1][0]);
			return (y - this.points[0][1]) == m * (x - this.points[0][0]);
		} catch (Exception e) {
			return false;
		}
	}

}
