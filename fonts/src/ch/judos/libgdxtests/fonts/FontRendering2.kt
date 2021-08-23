package ch.judos.libgdxtests.fonts

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.utils.ScreenUtils

/**
 * Use ttf file and FreeTypeFontGenerator to create BitMapFont in various sizes
 */
fun main() {
	val config = Lwjgl3ApplicationConfiguration()
	config.setTitle("Font rendering")
	config.setWindowedMode(800, 480)
	Lwjgl3Application(FontRendering2(), config)
}

class FontRendering2 : ApplicationAdapter() {
	
	private lateinit var font2: BitmapFont
	lateinit var font: BitmapFont
	lateinit var batch: SpriteBatch
	
	override fun create() {
		batch = SpriteBatch()
		val file = Gdx.files.internal("test2/Roboto-Medium.ttf")!!
		Gdx.app.log("", "Font length: ${file.length()}")
		val generator = FreeTypeFontGenerator(file)
		font = createFont(generator, 32f)
		font2 = createFont(generator, 96f)
		generator.dispose()
	}
	
	private fun createFont(generator: FreeTypeFontGenerator, dp: Float): BitmapFont {
		val parameter = FreeTypeFontGenerator.FreeTypeFontParameter()
		val fontSize = (dp * Gdx.graphics.density).toInt()
		parameter.size = fontSize
		Gdx.app.log("", "Font size: " + fontSize + "px")
		return generator.generateFont(parameter)!!
	}
	
	override fun render() {
		ScreenUtils.clear(0f, 0f, 0f, 1f)
		batch.begin()
		font.draw(batch, "Hello World", 100f, 100f)
		font2.draw(batch, "Hello World", 100f, 150f)
		batch.end()
	}
	
	override fun dispose() {
		batch.dispose()
		font.dispose()
	}
}