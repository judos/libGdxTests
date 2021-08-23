package ch.judos.libgdxtests.fonts

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.utils.ScreenUtils
import kotlin.math.pow

/**
 * Distance field fonts example, see: https://github.com/libgdx/libgdx/wiki/Distance-field-fonts
 */
fun main() {
	val config = Lwjgl3ApplicationConfiguration()
	config.setTitle("Font rendering DFF")
	config.setWindowedMode(800, 480)
	Lwjgl3Application(FontRendering3(), config)
}

class FontRendering3 : ApplicationAdapter() {
	
	lateinit var fontShader: ShaderProgram
	lateinit var font: BitmapFont
	lateinit var batch: SpriteBatch
	
	override fun create() {
		batch = SpriteBatch()
		val texture = Texture(Gdx.files.internal("test3/Roboto-Medium-DFF.png"))
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear)
		font =
			BitmapFont(Gdx.files.internal("test3/Roboto-Medium-DFF.fnt"), TextureRegion(texture), false)
		
		fontShader =
			ShaderProgram(Gdx.files.internal("test3/shader/font.vert"), Gdx.files.internal("test3/shader/font.frag"))
		if (!fontShader.isCompiled) {
			Gdx.app.error("fontShader", "compilation failed: 	${fontShader.log}")
		}
	}
	
	override fun render() {
		ScreenUtils.clear(0f, 0f, 0f, 1f)
		batch.begin()
		batch.shader = fontShader;
		for (i in 1..4) {
			batch.transformMatrix =
				Matrix4().trn(50f, 50 + i * 30f * 1.5f.pow(i - 2f), 0f).scl(2f.pow(i - 2f))
			font.draw(batch, "Hello World", 0f, 0f)
		}
		batch.end()
	}
	
	override fun dispose() {
		batch.dispose()
		font.dispose()
	}
}