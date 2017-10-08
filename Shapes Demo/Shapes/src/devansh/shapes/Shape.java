package devansh.shapes;

import processing.core.PApplet;
/**
 * 
 * @author dmishra734
 * @version 1
 *
 */
public abstract class Shape {
	//FIELDS
	protected double x;
	protected double y;
	protected int r;
	protected int g;
	protected int b;
	//CONSTRUCTOR
	public Shape(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	
	public abstract double getPerimeter();
	public abstract double getArea();
	
	/**
	 * 
	 * @param r = red value
	 * @param g - green value
	 * @param b - blue value
	 * @post changes the color
	 */
	public abstract void fill(int r, int g, int b);
	public abstract boolean isPointInside(double x, double y);
	
	/**
	 * 
	 * @param marker A PApplet for drawing
	 * @post draws the current object
	 */
	public abstract void draw(PApplet marker);
	
	//METHODS
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
