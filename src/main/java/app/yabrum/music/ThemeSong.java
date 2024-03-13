package app.yabrum.music;

import app.yabrum.Main;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;

import java.io.InputStream;

public class ThemeSong {
    private static BasicPlayer player = new BasicPlayer();
    private static BasicController control = player;
    private static final InputStream playFile = Main.class.getClassLoader().getResourceAsStream("music/theme.mp3");
    public static void start() throws Exception {
        control.open(playFile);

        control.play();
        control.setGain(0.50);
        control.setPan(0.0);
    }

    public static void pause() throws Exception {
        control.pause();
    }

    public static void resume() throws Exception {
        control.resume();
    }
}
