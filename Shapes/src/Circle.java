import processing.core.PApplet;

public class Circle {
	// x & y are center points
	private double x, y, r;

	// Creates a default instance of a Circle object with all dimensions
	// set to zero.
	public Circle() {
		this(0, 0, 0);
	}

	// Creates a new instance of a Circle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.r = (r < 0) ? -r : r;
	}

	// Calculates and returns the perimeter of the Circle
	public double getPerimeter() {
		return 2 * Math.PI * this.r;
	}

	// Calculates and returns the area of the Circle
	public double getArea() {
		return Math.PI * this.r * this.r;
	}

	// Determines whether the point x,y is contained inside this Circle
	public boolean isPointInside(double x, double y) {
		return (Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= this.r);
	}

	// Draws a new instance of a Circle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public void draw(PApplet applet) {
		applet.ellipseMode(PApplet.RADIUS);
		applet.ellipse((float) this.x, (float) this.y, (float) this.r, (float) this.r);
	}

}
