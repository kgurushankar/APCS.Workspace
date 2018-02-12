package kgurushankar.fractal;

import java.awt.Point;

import processing.core.PApplet;

public class Line {
	private Point start;
	private Point end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Line(Point start, int length, double angle) {
		this.start = start;
		this.end = new Point((int) (start.x - length * Math.sin(angle)), (int) (start.y - length * Math.cos(angle)));
	}

	public Line rotate(double angle) {
		return new Line(start, (int) start.distance(end), Math.atan((start.y - end.y) / (start.x - end.x)) - angle);
	}

	public void draw(PApplet applet) {
		applet.line(start.x, start.y, end.x, end.y);
	}
}
