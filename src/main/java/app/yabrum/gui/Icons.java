package app.yabrum.gui;

import app.yabrum.Main;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Icons {
    public static ImageIcon HOME = null;
    public static ImageIcon BBS = null;
    public static ImageIcon SETTING = null;
    public static ImageIcon INFORMATION = null;
    public static ImageIcon RELOAD = null;

    static {
        try {
            HOME = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/home.png")),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    50
            ));

            BBS = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/messenger.png")),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    50
            ));

            SETTING = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/setting.png")),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    50
            ));

            INFORMATION = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/information.png")),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    50
            ));

            RELOAD = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/reload.png")),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.FIT_TO_WIDTH,
                    30
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
