package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import core.objects.Ball;
import core.objects.Player;
import core.objects.PlayerAI;
import core.objects.Wall;
import org.lwjgl.opengl.GL20;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameScreen extends ScreenAdapter {

	//	private final OrthographicCamera camera;
	private final SpriteBatch batch;
	private final Wall wallTop;
	private final Wall wallBottom;
	private final ShapeDrawer drawer;

	private TextureRegion[] numbers;

	public PlayerAI playerAI;
	public Player player;
	public Ball ball;
	private float rot;

	public GameScreen() {
//		this.camera = camera;
//		this.camera.position
//				.set(new Vector3(Boot.INSTANCE.getWidth() / 2, Boot.INSTANCE.getHeight() / 2, 0));
		this.batch = new SpriteBatch();

		this.player = new Player(16, Boot.INSTANCE.getHeight() / 2);
		this.playerAI = new PlayerAI(Boot.INSTANCE.getWidth() - 16, Boot.INSTANCE.getHeight() / 2,
				this);
		this.ball = new Ball(this);
		this.wallTop = new Wall(32);
		this.wallBottom = new Wall(Boot.INSTANCE.getHeight() - 32);
		this.numbers = loadTextureSprite("numbers.png", 10);

		Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.drawPixel(0, 0);
		Texture texture = new Texture(pixmap); //remember to dispose of later
		pixmap.dispose();
		TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
		drawer = new ShapeDrawer(batch, region);
	}

	private void drawNumbers(SpriteBatch batch, int number, float x, float y, float width,
			float height) {
		if (number < 10) {
			batch.draw(numbers[number], x, y, width, height);
		} else {
			batch.draw(numbers[number % 10], x + 20, y, width, height);
			batch.draw(numbers[number / 10], x, y, width, height);
		}
	}


	public void update() {

//		camera.update();
		player.update();
		playerAI.update();
		ball.update();

//		batch.setProjectionMatrix(camera.combined);
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
			ball.reset();
			player.score = 0;
			playerAI.score = 0;
		}
	}

	@Override
	public void render(float delta) {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		player.render(batch);
		playerAI.render(batch);
		this.ball.render(batch);
		wallTop.render(batch);
//		wallBottom.render(batch);

//		drawer.line(0, 0, 100, 200, 5);
//		drawer.line(0, 0, 100, 100);
//		rot = 1.8f;
//		drawer.setColor(1, 0, 1, 1);
//		drawer.filledRectangle(150, 150, 100, 50, rot);

		drawNumbers(batch, player.score, 64, Boot.INSTANCE.getHeight() - 55, 30, 42);
		drawNumbers(batch, playerAI.score, Boot.INSTANCE.getWidth() - 96, Boot.INSTANCE.getHeight()
				- 55, 30, 42);
//		batch.draw
		batch.end();
	}

	private TextureRegion[] loadTextureSprite(String filename, int columns) {
		Texture texture = new Texture(filename);
		return TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight())[0];
	}

}
