import processing.core.PApplet;
import processing.core.PShape;

public class House implements Drawable {
	private PShape frame, roof, window, door;
	private float size;

	public House(PApplet applet) {
		size = 1f;
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
		applet.pushMatrix();

		applet.translate(x, y);
		applet.scale(size);
		applet.shape(frame, 0, 100);
		applet.shape(roof, 150, 0);
		applet.shape(window, 50, 125);
		applet.shape(window, 200, 125);
		applet.shape(door, 125, 175);
		applet.line(0, 250, 300, 250);

		applet.popMatrix();

	}

	@Override
	public void changeSize(float size) {
		this.size = size;

	}

	public void incrementSize(float size) {
		if (this.size + size > 0f) {
			this.size += size;
		}

	}
}
