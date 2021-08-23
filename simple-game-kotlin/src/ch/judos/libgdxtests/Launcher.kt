package ch.judos.libgdxtests

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


fun main() {
	val config = Lwjgl3ApplicationConfiguration()
	config.setTitle("Drop")
	config.setWindowedMode(800, 480)
	Lwjgl3Application(DropGame(), config)
}
