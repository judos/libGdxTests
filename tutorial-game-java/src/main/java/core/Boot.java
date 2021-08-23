package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Boot extends Game {

	public static Boot INSTANCE = new Boot();
	private int w, h;
//	private OrthographicCamera camera;

	private Boot() {
	}


	@Override
	public void create() {
		this.w = Gdx.graphics.getWidth();
		this.h = Gdx.graphics.getHeight();
//		this.camera = new OrthographicCamera();
//		this.camera.setToOrtho(false, w, h);

		setScreen(new GameScreen());
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
}
