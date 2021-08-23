package core.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import core.Boot;
import core.GameScreen;

public class Ball {

	public float x, y, speed, velX, velY;
	private int width, height;
	private GameScreen screen;
	private Texture texture;

	public Ball(GameScreen screen) {
		reset();
		this.texture = new Texture("white.png");
		this.screen = screen;
		this.width = 32;
		this.height = 32;
	}

	private float getRandomDirection() {
		return Math.random() < 0.5 ? 1 : -1;
	}

	public void update() {
		x += velX * speed;
		y += velY * speed;
		// score
		if (x < 0) {
			screen.playerAI.score++;
			reset();
		} else if (x > Boot.INSTANCE.getWidth()) {
			screen.player.score++;
			reset();
		}
		if (y < 64 || y > Boot.INSTANCE.getHeight() - 64) {
			reverseVelY();
		}
	}

	public void reset() {
		this.velY = getRandomDirection();
		this.velX = getRandomDirection();
		this.x = Boot.INSTANCE.getWidth() / 2;
		this.y = Boot.INSTANCE.getHeight() / 2;
		this.speed = 5;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y, width, height);
	}

	public void reverseVelX() {
		this.velX *= -1;
	}

	public void reverseVelY() {
		this.velY *= -1;
	}

	public void incSpeed() {
		this.speed *= 1.1f;
	}
}
