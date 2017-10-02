package kgurushankar.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * Defines a 1D shape (defined by a line)
 * 
 * @author kgurushankar
 */
public abstract class Shape1D {
	/**
	 * Line that defines everything <br>
	 * Shape is built around this
	 */
	protected double[][] line;

	private Color color;
	private double weight;

	/**
	 * Create a Shape1D that has the given coordinates
	 * 
	 * @param x1
	 *            x coordinate of the starting point of the line
	 * @param y1
	 *            y coordinate of the starting point of the line
	 * @param x2
	 *            x coordinate of the ending point of the line
	 * @param y2
	 *            y coordinate of the ending point of the line
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	protected Shape1D(double x1, double y1, double x2, double y2, Color c, double strokeWidth) {
		line = new double[2][2];
		line[0][0] = x1;
		line[0][1] = y1;
		line[1][0] = x2;
		line[1][1] = y2;
		color = c;
		weight = strokeWidth;

	}

	/**
	 * Create a Shape1D that has the given coordinates
	 * 
	 * @param start
	 *            starting point of the line
	 * @param end
	 *            ending point of the line
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	protected Shape1D(Point2D.Double start, Point2D.Double end, Color c, double strokeWidth) {
		this(start.getX(), start.getY(), end.getX(), end.getY(), c, strokeWidth);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get a different shape with the same defining line
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	protected Shape1D(Shape1D shape) {
		this.line = shape.line;
		this.color = shape.color;
		this.weight = shape.weight;
	}

	/**
	 * Draws this object (in Processing Graphics)
	 * 
	 * @param applet
	 *            the PApplet this is being drawn on
	 * @post this will be drawn on the PApplet object
	 */
	public void draw(PApplet applet) {
		applet.stroke(color.getRGB());
		applet.strokeWeight((float) weight);
	}

	/**
	 * Draws this object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object this is being drawn on
	 * @post this will be drawn on the Graphics object
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke((float) weight));
	}

	protected double getdeltaX() {
		return Math.abs(line[0][0] - line[1][0]);
	}

	protected double getdeltaY() {
		return Math.abs(line[1][0] - line[1][1]);
	}

	protected double getLength() {
		return Math.sqrt(getdeltaX() * getdeltaX() + getdeltaY() * getdeltaY());
	}

}
