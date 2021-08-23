package core.objects;

import core.GameScreen;

public class PlayerAI extends PlayerPaddle {
	private final GameScreen screen;

	public PlayerAI(float x, float y, GameScreen screen) {
		super(x, y);
		this.screen = screen;
	}

	@Override
	public void update() {
		velY = 0;
		// AI Magic
		if (screen.ball.y - 10 > y) {
			velY = 1;
		} else if (screen.ball.y + 10 < y) {
			velY = -1;
		}
		super.update();
	}
}
