package kgurushankar.shapedemo;

import java.awt.Color;
import java.util.ArrayList;

import devansh.shapes.Rectangle;
import devansh.shapes.Shape;
import devansh.shapes.Circle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private Shape[] menu;
	private Rectangle[] boxes;
	private Options selection;

	private enum Options {
		Rect, Circle, Shape
	}

	private ArrayList<MovingShape> shapes = new ArrayList<MovingShape>();
	public static final float HEIGHT = 800;
	public static final float WIDTH = 800;
	private float pwidth;
	private float pheight;
	private Rectangle bounds;

	public DrawingSurface() {
		pwidth = WIDTH;
		pheight = HEIGHT;
		selection = null;

		// Menu and selection boxes
		menu = new Shape[2];
		boxes = new Rectangle[2];
		menu[0] = new Rectangle(0, 0, 50, 50);
		menu[0].fill(255, 255, 255);
		boxes[0] = new Rectangle(menu[0].getX(), menu[0].getY(), menu[0].getWidth(), menu[0].getHeight());
		menu[1] = new Circle(80, 25, 25);
		menu[1].fill(255, 255, 255);
		boxes[1] = new Rectangle(menu[1].getX() - menu[1].getWidth(), menu[1].getY() - menu[1].getHeight(),
				menu[1].getWidth() * 2, menu[1].getHeight() * 2);

	}

	public void setup() {
		bounds = new Rectangle(0, 0, width, height);
	}

	public void draw() {
		background(255);
		for (Shape s : menu) {
			s.draw(this);
		}
		for (MovingShape s : shapes) {
			s.draw(this);
			s.act(bounds);
		}
		sizeChanged();
	}

	private void sizeChanged() {
		if (width != pwidth || height != pheight) {
			bounds = new Rectangle(0, 0, width, height);
		}
	}

	private MovingShape activeShape;

	public void mousePressed() {
		if (mouseButton == LEFT) {
			// Check for existing shape
			for (MovingShape s : shapes) {
				if (s.getShape().isPointInside(mouseX, mouseY)) {
					activeShape = s;
					selection = Options.Shape;
					return;
				}
			}
			// If selecting Shape
			if (boxes[0].isPointInside(mouseX, mouseY)) {
				selection = Options.Rect;
				return;
			} else if (boxes[1].isPointInside(mouseX, mouseY)) {
				selection = Options.Circle;
				return;
			} // If shape selected and in drawing mode
			else if (selection != null) {
				MovingShape e = null;
				if (selection == Options.Circle) {
					e = new MovingShape(new Circle(mouseX, mouseY, 0), randomColor());
				} else if (selection == Options.Rect) {
					e = new MovingShape(new Rectangle(mouseX, mouseY, 0, 0), randomColor());
				}
				activeShape = e;
				if (e != null)
					shapes.add(e);

			}
		} else if (mouseButton == RIGHT) {
			for (MovingShape s : shapes) {
				if (s.getShape().isPointInside(mouseX, mouseY)) {
					shapes.remove(s);
					activeShape = null;
					selection = null;
					return;
				}
			}

		}

	}

	public void mouseDragged() {
		if (mouseButton == LEFT) {
			if (activeShape != null) {
				if (selection == Options.Shape) {

					if (inRange(mouseX, 0, width)) {
						activeShape.moveX(mouseX);
					}
					if (inRange(mouseY, 0, height)) {
						activeShape.moveY(mouseY);
					}
				} else if (selection == Options.Circle) {
					shapes.remove(activeShape);
					double x = activeShape.getX();
					double y = activeShape.getY();
					activeShape = new MovingShape(
							new Circle(x, y, Math.max(Math.abs(x - mouseX), Math.abs(y - mouseY))),
							activeShape.getFillColor());
					shapes.add(activeShape);
				} else if (selection == Options.Rect) {
					shapes.remove(activeShape);
					double x = activeShape.getX();
					double y = activeShape.getY();
					activeShape = new MovingShape(
							new Rectangle(activeShape.getX(), activeShape.getY(), -x + mouseX, -y + mouseY),
							activeShape.getFillColor());

					shapes.add(activeShape);
				}
			}
		}
	}

	public void mouseReleased() {
		if (selection == Options.Shape) {
			if (activeShape != null) {
				double vx = mouseX - pmouseX;
				double vy = mouseY - pmouseY;
				activeShape.setV(vx, vy);
			}
			activeShape = null;
			selection = null;
		}
	}

	private boolean inRange(float x, float low, float high) {
		return ((x >= low && x <= high) || (x <= low && x >= high));
	}

	private static Color randomColor() {
		return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}
}
