package devansh.shapes;
import processing.core.PApplet;

/**
 * @author Devansh Mishra
 * @version 1
 */
public class Circle extends Shape {
	private double radius;
	
	
	
	// Creates a default instance of a Rectangle object with all dimensions
	// set to zero.
	/**
	 * @post a Circle with coordinates and radius set to 0
	 */
	public Circle() {
		super(0, 0);
		setX(0);
		setY(0);
		radius = 0;
	}

	// Creates a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	/**
	 * 
	 * @param x - the x-coordinate of the Circle
	 * @param y - the y-coordinate of the Circle
	 * @param radius - the radius of the Circle
	 * @post creates a Circle at the given values
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.setX(x);
		this.setY(y);
		this.radius = radius;
	}

	// Calculates and returns the perimeter of the rectangle
	/**
	 * 
	 * @return the Circumference of the circle
	 */
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

	// Calculates and returns the area of the rectangle
	/**
	 * 
	 * @return the area of the circle
	 */
	public double getArea() {
		return Math.PI*radius*radius;
	}

	// Determines whether the point x,y is contained inside this rectangle
	/**
	 * 
	 * @param x - x-coordinate of the point
	 * @param y - y-coordinate of the point
	 * @return a boolean whether the point at the given values is inside the circle
	 */
	public boolean isPointInside(double x, double y) {
		double xDiff = this.getX() - x;
		double yDiff = this.getY() - y;
		double distance = Math.sqrt(Math.pow(xDiff, 2)+Math.pow(yDiff, 2));
		if(distance <= radius) {
			return true;
		}
		return false; 
	}
	/**
	 * 
	 * @param x - x-coordinate of the point
	 * @param y - y-coordinate of the point
	 * @return a boolean whether the point is on the border
	 */
	public boolean isPointOnBorder(double x, double y) {
		double xDiff = this.getX() - x;
		double yDiff = this.getY() - y;
		double distance = Math.sqrt(Math.pow(xDiff, 2)+Math.pow(yDiff, 2));
		if(Math.abs(distance - radius) < 0.0000001) {
			return true;
		}
		return false; 
	}
	/**
	 * 
	 * @param circle - A circle
	 * @return a boolean whether the circles are overlapping
	 */
	public boolean isOverlapping(Circle circle) {
		double xDiff = this.getX() - circle.getX();
		double yDiff = this.getY() - circle.getY();
		double distance = Math.sqrt(Math.pow(xDiff, 2)+Math.pow(yDiff, 2));
		if(distance <= radius*2) {
			return true;
		}
		return false; 
		
	}
	
	public void fill(int r, int g, int b) {
		this.r = r;
		this.g= g;
		this.b = b;
	}
	// Draws a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	/**
	 * 
	 * @param marker - a PApplet that draws the circle
	 * @post draws a circle at the given values
	 */
	public void draw(PApplet marker) {
		marker.ellipseMode(PApplet.CENTER);
		marker.fill(r, g, b);
		marker.ellipse((float)getX(), (float)getY(), (float)radius*2, (float)radius*2);
	}

	//Getters and Setters
	

	public double getWidth() {
		return radius;
	}
	public double getHeight() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	
	
	
	
}
