package ch.judos.libgdxtests.screens

import ch.judos.libgdxtests.DropGame
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import org.lwjgl.opengl.GL20

class MenuScreen(
		val game: DropGame
) : ScreenAdapter() {
	
	var camera: OrthographicCamera = OrthographicCamera()
	private var rot = 0f
	
	init {
		camera.setToOrtho(false, 800f, 480f)
	}
	
	override fun render(delta: Float) {
		Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		camera.update()
		game.batch.projectionMatrix = camera.combined
		game.batch.begin()
		game.font.draw(game.batch, "Welcome to Drop!!! ", 100f, 150f)
		game.font.draw(game.batch, "Tap anywhere to begin!", 100f, 100f)
		
		// game.font2.draw(game.batch, "Welcome to Drop!!! ", 100f, 200f)
		// game.font2.draw(game.batch, "Welcome to Drop!!! ", 100f, 250f)
		
		game.drawer.line(0f, 0f, 100f, 200f, 5f)
		game.drawer.line(0f, 0f, 100f, 100f)
		rot += 0.03f
		game.drawer.setColor(1f, 0f, 1f, 1f)
		game.drawer.filledRectangle(150f, 150f, 100f, 50f, rot)
		game.batch.end()
		if (Gdx.input.isTouched) {
			game.screen = GameScreen(game)
			dispose()
		}
	}
	
}