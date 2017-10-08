package devansh.shapes;
import processing.core.PApplet;

/**
 * @author Devansh Mishra
 * @version 1
 */

public class Rectangle extends Shape{
	
	private double width;
	private double height;
	
	

	public Rectangle() {
		super(0, 0);
		width = 0;
		height = 0;
	}

	/**
	 * @param x x coordinate of rectangle
	 * @param y y coordinate of rectangle
	 * @param width width of rectangle
	 * @param height height of rectangle 
	 * @post creates a rectangle at x y with width and height
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x,y);
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * @return the Perimeter of the rectangle as a double using the width and height
	 */
	public double getPerimeter() {
		return 2*width + 2*height;
	}

	/**
	 * 
	 * @return the Area of the rectangle as a double
	 */
	public double getArea() {
		return width*height;
	}

	/**
	 * 
	 * @param x the x-coordinate of the point
	 * @param y the y-coordinate of the point 
	 * @return a boolean whether a point is inside the rectangle
	 */
	public boolean isPointInside(double x, double y) {
		return ((this.x <= x && x <= (this.x + width)) && (this.y <= y && y <= (this.y + this.height))); 
	}
	
	
	/**
	 * post Randomly changes the rectangle color
	 */
	public void randColor() {
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
	}
	public void fill(int r, int g, int b) {
		this.r = r;
		this.g= g;
		this.b = b;
	}
	
	/**
	 * @param marker a PApplet needed in order to draw the rectangle
	 * @post draws a rectangle at the current values(x, y, width, height)
	 */
	public void draw(PApplet marker) {
		marker.fill(r, g, b);
		marker.rect((float)x, (float)y, (float)width, (float)height);
	}

	
	//Getters and Setters




	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}

	
	
	
	
	

}
