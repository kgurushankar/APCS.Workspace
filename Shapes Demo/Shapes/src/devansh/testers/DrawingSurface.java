package devansh.testers;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import devansh.shapes.Circle;
import devansh.shapes.Rectangle;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	
	private Rectangle rectangle;
	private Circle circle;

	public DrawingSurface() {
		rectangle = new Rectangle(20, 20, 20 ,20);
		circle = new Circle(50, 50, 10);
		
	}

	
	public void settings() {
		  size(200, 200);
	}
	public void setup() {
		
	  
	}

	public void draw() {
		rectangle.draw(this);
		circle.draw(this);

	  
	}

	

}
