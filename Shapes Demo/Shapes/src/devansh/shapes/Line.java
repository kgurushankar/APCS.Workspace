package devansh.shapes;
import processing.core.PApplet;

/*
 * 2 good things: class design, clear and easily readable code and thought process 
 * 2 suggestions: maybe split up the equations into smaller portions so that it doesn't appear to be as lengthy
 * (split into separate variables for numerator and denominator?)
 * 
 * 
 */
/**
 * 
 * @author Devansh Mishra
 * @version 1
 *
 */
public class Line extends Shape{
	private double x, x2, y, y2;
	/**
	 * 
	 * @param x first x-coordinate
	 * @param y first y-coordinate
	 * @param x2 second x-coordinate
	 * @param y2 second y-coordinate
	 * @post creates a line at the given values
	 */
	public Line(double x, double y, double x2,double y2) {
		super(x,y);
		this.x2 = x2;
		this.y2 = y2;
	}
	/**
	 * 
	 * @param drawer A PApplet to draw the line
	 * @post Draws a line at given values
	 */
	public void draw(PApplet drawer) {
		drawer.stroke(r, g, b);
		drawer.line((float)x, (float)y, (float)x2, (float)y2);
	}
	/**
	 * 
	 * @param x changes the first x-coordinate
	 * @param y changes the first y-coordinate
	 * @post changes the first coordinate to the given values
	 */
	public void setPoint1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @param x2 changes the second x-coordinate
	 * @param y2 changes the second y-coordinate
	 * @post changes the second coordinate to the given values
	 */
	public void setPoint2(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	/**
	 * 
	 * @param l2 a Line
	 * @return a boolean whether the two lines intersect
	 */
	public boolean intersects(Line l2) {
		double x3 = l2.getX();
		double x4 = l2.getX2();
		double y3 = l2.getY();
		double y4 = l2.getY2();
		double xTop = (x*y2 - y*x2)*(x3-x4)-(x-x2)*(x3*y4-y3*x4);
		double xBottom = (x-x2)*(y3-y4)-(y-y2)*(x3-x4);
		double yTop = ((x*y2 - y*x2)*(y3-y4)-(y-y2)*(x3*y4-y3*x4));
		double yBottom = ((x-x2)*(y3-y4)-(y-y2)*(x3-x4));
		if(xBottom == 0 || yBottom == 0) {
			return false;
		}
		double x = xTop/xBottom;
		double y = yTop/yBottom;
		double xMin1 = Math.min(x, x2);
		double xMax = Math.max(x, x2);
		double yMin1 = Math.min(y, y2);
		double yMax = Math.max(y, y2);
		double xMin2 = Math.min(x3, x4);
		double xMax2 = Math.max(x3, x4);
		double yMin2 = Math.min(y3, y4);
		double yMax2 = Math.max(y3, y4);
		if(x >= xMin1 && x <= xMax) {
			if(x >= xMin2 && x <= xMax2) {
				if(y >= yMin1 && y <= yMax) {
					if(y >= yMin2 && y <= yMax2) {
						return true;
					}
				}
			}
		}

		return false;
		
		
	
	}
	
	//Getters and Setters
	public double getX() {
		return x;
	}
	public double getX2() {
		return x2;
	}
	public double getY() {
		return y;
	}
	public double getY2() {
		return y2;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void fill(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
		
	}
	@Override
	public boolean isPointInside(double x, double y) {
		
		return false;
	}
	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
