package ch.judos.libgdxtests

import ch.judos.libgdxtests.screens.MenuScreen
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import space.earlygrey.shapedrawer.ShapeDrawer


class DropGame : Game() {
	lateinit var font2: BitmapFont
	lateinit var batch: SpriteBatch
	lateinit var font: BitmapFont
	lateinit var drawer: ShapeDrawer
	
	override fun create() {
		font = BitmapFont(Gdx.files.internal("fonts/Amble-Regular-26.fnt"))
		
		batch = SpriteBatch()
		val pixmap = Pixmap(1, 1, Pixmap.Format.RGBA8888)
		pixmap.setColor(Color.WHITE)
		pixmap.drawPixel(0, 0)
		val texture = Texture(pixmap) //remember to dispose of later
		pixmap.dispose()
		val region = TextureRegion(texture, 0, 0, 1, 1)
		drawer = ShapeDrawer(batch, region)
		setScreen(MenuScreen(this))
	}
	
	override fun render() {
		super.render() // important!
	}
	
	override fun dispose() {
		batch.dispose()
		font.dispose()
	}
	
}
