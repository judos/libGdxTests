package drop2;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import org.lwjgl.opengl.GL20;

public class MainMenuScreen extends ScreenAdapter {

	final Drop game;

	OrthographicCamera camera;
	private float rot;

	public MainMenuScreen(final Drop game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
		game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);

		game.drawer.line(0, 0, 100, 200, 5);
		game.drawer.line(0, 0, 100, 100);
		rot = rot + 0.03f;
		game.drawer.setColor(1, 0, 1, 1);
		game.drawer.filledRectangle(150, 150, 100, 50, rot);

		game.batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}
}