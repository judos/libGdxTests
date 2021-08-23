package core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {

	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.useOpenGL3(true, 3, 2);
		config.setIdleFPS(60);
		config.setForegroundFPS(60);
		config.useVsync(true);
		config.setTitle("Tutorial");
		config.setWindowedMode(1000, 700);
		config.setWindowIcon("white.png");
//		config.setResizable(false);
//		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());

		new Lwjgl3Application(Boot.INSTANCE, config);
	}
}
