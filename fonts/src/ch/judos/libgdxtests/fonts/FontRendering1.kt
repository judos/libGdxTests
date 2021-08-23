package ch.judos.libgdxtests.fonts

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.utils.ScreenUtils

/**
 * Simple rendering of text with fnt + png file
 */
fun main() {
	val config = Lwjgl3ApplicationConfiguration()
	config.setTitle("Font rendering")
	config.setWindowedMode(800, 480)
	Lwjgl3Application(FontRendering1(), config)
}

class FontRendering1 : ApplicationAdapter() {
	
	lateinit var font: BitmapFont
	lateinit var batch: SpriteBatch
	
	override fun create() {
		batch = SpriteBatch()
		font = BitmapFont(Gdx.files.internal("test1/Amble-Regular-26.fnt"))
	}
	
	override fun render() {
		ScreenUtils.clear(0f, 0f, 0f, 1f)
		batch.begin()
		batch.transformMatrix = Matrix4().scl(2f)
		font.draw(batch, "Hello World", 100f, 100f)
		batch.end()
	}
	
	override fun dispose() {
		batch.dispose()
		font.dispose()
	}
}