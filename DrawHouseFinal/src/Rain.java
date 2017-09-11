import processing.core.PApplet;

public class Rain extends Drawable {
	private int height;

	public Rain(int x, int y, int height) {
		super(x, y, true, new Line(x, y, x, y + height));
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet applet) {
		super.draw(applet);
		applet.color(0, 0, 255);
		applet.line(0, 0, 0, height);

	}

	@Override
	public void changeSize(float size) {
		this.height = (int) (size + .5f);
	}

}
