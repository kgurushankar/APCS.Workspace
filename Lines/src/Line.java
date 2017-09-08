import java.awt.geom.Line2D;

import processing.core.PApplet;

public class Line {
	private float[][] points;

	public Line(float mouseX, float mouseY, float mouseX2, float mouseY2) {
		points = new float[2][2];
		points[0][0] = mouseX;
		points[0][1] = mouseY;
		points[1][0] = mouseX2;
		points[1][1] = mouseY2;
	}

	public void draw(PApplet applet) {
		applet.line(points[0][0], points[0][1], points[1][0], points[1][1]);
	}

	/**
	 * @return[-1] if there is no intersection point or [x,y] if there is a point
	 */
	public float[] intersects(Line l2) {
		float x1 = this.points[0][0];
		float y1 = this.points[0][1];
		float x2 = this.points[1][0];
		float y2 = this.points[1][1];
		float x3 = l2.points[0][0];
		float y3 = l2.points[0][1];
		float x4 = l2.points[1][0];
		float y4 = l2.points[1][1];

		float x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4))
				/ ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
		float y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4))
				/ ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

		if (x == Float.NaN || y == Float.NaN) {
			return new float[] { -1f };
		}

		if (this.contains(x, y) && l2.contains(x, y)) {
			return new float[] { x, y };
		} else {
			return new float[] { -1f };
		}

	}

	public void setPoint2(float mouseX, float mouseY) {
		points[1][0] = mouseX;
		points[1][1] = mouseY;

	}

	private boolean contains(float x, float y) {
		return inRange(x, points[0][0], points[1][0]) && inRange(y, points[0][1], points[1][1]);
	}

	private boolean inRange(float x, float points2, float points3) {
		return ((x >= points2 && x <= points3) || (x <= points2 && x >= points3));
	}
}
