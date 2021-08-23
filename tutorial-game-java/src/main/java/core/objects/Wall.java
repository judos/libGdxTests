package core.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import core.Boot;

public class Wall {

	private float x, y;
	private int width, height;
	private Texture texture;

	public Wall(float y) {
		this.x = Boot.INSTANCE.getWidth() / 2;
		this.y = y;
		this.width = Boot.INSTANCE.getWidth();
		this.height = 64;
		this.texture = new Texture("white.png");
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x - (width / 2), y - (height / 2), width, height);
	}
}
