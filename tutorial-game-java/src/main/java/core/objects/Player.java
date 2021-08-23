package core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends PlayerPaddle {

	public Player(float x, float y) {
		super(x, y);
		score = 15;
	}

	@Override
	public void update() {
		velY = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			velY = 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			velY = -1;
		}
		super.update();
	}
}
