import processing.core.PApplet;

public class Person implements Drawable {

	@Override
	public void draw(PApplet applet, int x, int y) {
		applet.polygon();
	}

	private PShape polygon(float x, float y, float radius, int npoints) {
		float angle = PApplet.TWO_PI / npoints;
		PShape polygon = applet.beginShape();
		for (float a = 0; a < TWO_PI; a += angle) {
			float sx = x + cos(a) * radius;
			float sy = y + sin(a) * radius;
			vertex(sx, sy);
		}
		endShape(CLOSE);
	}
}
