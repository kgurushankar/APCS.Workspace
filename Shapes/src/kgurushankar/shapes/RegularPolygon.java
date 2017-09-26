package kgurushankar.shapes;
import processing.core.PApplet;
import processing.core.PShape;

public class RegularPolygon {
	// x & y represent center of polygon;
	private double x, y, sideLength;
	private int sides;

	// Creates a default instance of a Rectangle object with all dimensions
	// set to zero.
	public RegularPolygon() {
		this(0, 0, 0, 0);
	}

	// Creates a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public RegularPolygon(double x, double y, double sideLength, int sides) {

	}

	// Calculates and returns the perimeter of the rectangle
	public double getPerimeter() {
		return sides * sideLength;
	}

	// Calculates and returns the area of the rectangle
	public void getArea() {

	}

	// Determines whether the point x,y is contained inside this rectangle
	public void isPointInside(double x, double y) {
	}

	// Draws a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public void draw(PApplet marker) {
	}

	private PShape polygon(PApplet applet, float radius, int sides) {
		double angle = Math.PI * 2 / sides;
		PShape polygon = applet.createShape();
		polygon.beginShape();
		for (double a = 0; a < PApplet.TWO_PI; a += angle) {
			double sx = Math.cos(a) * radius;
			double sy = Math.sin(a) * radius;
			polygon.vertex((float) sx, (float) sy);
		}
		polygon.endShape(PApplet.CLOSE);
		return polygon;
	}

	private void getRadius() {
		double internalAngle = Math.PI * 2 / sides;
		double legAngle = (Math.PI - internalAngle) / 2;

	}
}
