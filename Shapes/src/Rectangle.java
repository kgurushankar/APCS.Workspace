import processing.core.PApplet;

public class Rectangle {
	private double x, y, width, height;

	// Creates a default instance of a Rectangle object with all dimensions
	// set to zero.
	public Rectangle() {
		this(0, 0, 0, 0);
	}

	// Creates a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		if (width < 0) {
			this.width = -width;
			this.x = this.x + width;
		} else {
			this.width = width;
		}
		if (height < 0) {
			this.height = -height;
			this.y = this.y + height;
		} else {
			this.height = height;
		}
		System.out.println(this.x + " " + this.y + ' ' + this.width + ' ' + this.height);
	}

	// Calculates and returns the perimeter of the rectangle
	public double getPerimeter() {
		return 2 * (width + height);
	}

	// Calculates and returns the area of the rectangle
	public double getArea() {
		return width * height;
	}

	// Determines whether the point x,y is contained inside this rectangle
	public boolean isPointInside(double x, double y) {
		return (x >= this.x && x <= (this.x + this.width)) && (y >= this.y && y <= (this.y + this.height));
	}

	// Draws a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public void draw(PApplet applet) {
		applet.rect((float) this.x, (float) this.y, (float) this.width, (float) this.height);
	}

}
