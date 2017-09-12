import processing.core.PApplet;

public class Rain extends Drawable {
	private int height;
	private static final float a = 9.81f / 30;
	private float v = 0;

	public Rain(int x, int height) {
		super(x, 0, true);
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(x, y);
		applet.scale(size);
		applet.color(0, 0, 255);
		applet.line(0, 0, 0, height);

	}

	@Override
	public void changeSize(float size) {
		this.height = (int) (size + .5f);
	}

	public void fall(PApplet applet, Ground ground) {
		if (ground.getLocation(applet).doesIntersect(new Line(x, y, x, y + height))) {
			((DrawingSurface) (applet)).remove(this);
		} else {
			this.y += v;
			this.v += a;
		}

	}

}
