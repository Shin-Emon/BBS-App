package app.bbs.gui;

import app.bbs.main.Main;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * クラス Icons
 * アイコンファイルの処理・保持を行う。
 * @author shin
 * @see javax.swing.ImageIcon
 * @see javax.imageio.ImageIO
 * @see org.imgscalr.Scalr
 */
public class Icons {
    public static ImageIcon BBS = null;
    public static ImageIcon RELOAD = null;

    static {
        try {

            BBS = new ImageIcon(Scalr.resize(
                    ImageIO.read(Main.class.getClassLoader().getResource("icons/messenger.png")),
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
