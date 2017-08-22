import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private House house;
	private final boolean maintainAspectRatio = true;

	public void setup() {
		house = new House(this);
	}

	public void draw() {
		float scalex = (float) (width / 500.);
		float scaley = (float) (height / 500.);
		float scalef = Math.min(scalex, scaley);

		scale((maintainAspectRatio) ? scalef : scalex, (maintainAspectRatio) ? scalef : scaley);
		background(204);

		house.draw(this, 100, 100);

	}

}
