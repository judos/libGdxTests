package core.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class PlayerPaddle {

	protected float x, y, speed, velY;
	public int width, height, score;
	protected Texture texture;

	public PlayerPaddle(float x, float y) {
		this.x = x;
		this.y = y;
		velY = 0;
		this.speed = 6;
		this.width = 16;
		this.height = 64;
		this.texture = new Texture("white.png");
	}

	public void update() {
		this.y += velY * speed;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y, width, height);
	}
}
