package kgurushankar.shapes;
import java.awt.geom.Line2D;

import processing.core.PApplet;

/**
 * This class represents a line
 * 
 * @author kgurushankar
 */
public class Line {
	private float[][] points;

	/**
	 * Creates a new line with endpoints
	 * 
	 * @param x1
	 *            x coordinate of the start of the line
	 * @param y1
	 *            y coordinate of the start of the line
	 * @param x2
	 *            x coordinate of the end of the line
	 * @param y2
	 *            y coordinate of the end of the line
	 */
	public Line(float x1, float y1, float x2, float y2) {
		points = new float[2][2];
		points[0][0] = x1;
		points[0][1] = y1;
		points[1][0] = x2;
		points[1][1] = y2;
	}

	/**
	 * Draws this Line object (in Processing)
	 * 
	 * @param applet
	 *            The PApplet the line is being drawn on
	 * @post this line will be drawn on the PApplet
	 * 
	 */
	public void draw(PApplet applet) {
		applet.line(points[0][0], points[0][1], points[1][0], points[1][1]);
	}

	/**
	 * @param l2
	 *            the line that is being checked for an intersection
	 * @return [-1f] if there is no intersection point or [x,y] if there is a point
	 *         (both are float arrays)
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

		if (y == Float.POSITIVE_INFINITY || y == Float.NEGATIVE_INFINITY || y == Float.NaN || x == Float.NaN
				|| x == Float.POSITIVE_INFINITY || x == Float.NEGATIVE_INFINITY) {
			return new float[] { -1f }; // Div by 0 case
		}

		if (this.contains(x, y) && l2.contains(x, y)) {
			return new float[] { x, y };
		} else {
			return new float[] { -1f };
		}

	}

	/**
	 * @param l2
	 *            the line that is being checked for an intersection
	 * @return if this line intersects l2
	 */
	public boolean doesIntersect(Line l2) {
		return this.intersects(l2).length == 2;
	}

	/**
	 * Sets the end point of the line
	 * 
	 * @param x
	 *            new x coordinate of the end of the line
	 * @param y
	 *            new y coordinate of the end of the line
	 */
	public void setPoint2(float x, float y) {
		points[1][0] = x;
		points[1][1] = y;

	}

	private boolean contains(float x, float y) {
		return inRange(x, points[0][0], points[1][0]) && inRange(y, points[0][1], points[1][1]);
	}

	private boolean inRange(float x, float points2, float points3) {
		return ((x >= points2 && x <= points3) || (x <= points2 && x >= points3));
	}
}
