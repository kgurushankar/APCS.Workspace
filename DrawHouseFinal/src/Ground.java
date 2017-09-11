import processing.core.PApplet;

public class Ground extends Drawable {
	public Ground(int x, int y, PApplet applet) {
		super(0, y, false, new Line(0, y, applet.width, y));
		// TODO Auto-generated constructor stub
	}

	public void draw(PApplet applet) {
		super.draw(applet);
		applet.line(0, 0, applet.width, 0);

	}

}
