import processing.core.PApplet;

public class Ground extends Drawable {
	public Ground(int y) {
		super(0, y, false);
		// TODO Auto-generated constructor stub
	}

	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(x, y);
		applet.scale(size);
		applet.line(0, 0, applet.width, 0);

	}

	public Line getLocation(PApplet applet) {
		return new Line(0, y, x + applet.width, y);
	}

}
