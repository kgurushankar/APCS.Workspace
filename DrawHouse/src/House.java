import processing.core.PApplet;
import processing.core.PShape;

public class House implements Drawable {
	private PShape frame, roof, window, door;

	public House(PApplet applet) {
		frame = applet.createShape();
		frame.beginShape();
		frame.fill(204);
		frame.vertex(0, 0);
		frame.vertex(0, 150);
		frame.vertex(300, 150);
		frame.vertex(300, 0);
		frame.endShape(PApplet.CLOSE);

		roof = applet.createShape();
		roof.beginShape();
		roof.fill(204);
		roof.vertex(0, 0); // point
		roof.vertex(150, 100);
		roof.vertex(-150, 100);
		roof.endShape(PApplet.CLOSE);

		window = applet.createShape();
		window.beginShape();
		window.vertex(0, 0);
		window.vertex(50, 0);
		window.vertex(50, 50);
		window.vertex(0, 50);
		window.endShape(PApplet.CLOSE);

		door = applet.createShape();
		door.beginShape();
		door.vertex(0, 0);
		door.vertex(0, 75);
		door.vertex(50, 75);
		door.vertex(50, 0);
		door.endShape(PApplet.CLOSE);
	}

	public void draw(PApplet applet, int x, int y) {
		applet.shape(frame, x, 100 + y);
		applet.shape(roof, 150 + x, y);
		applet.shape(window, 50 + x, 125 + y);
		applet.shape(window, 200 + x, 125 + y);
		applet.shape(door, 125 + x, 175 + y);
		applet.line(x, 250 + y, 300 + x, 250 + y);

	}

}
