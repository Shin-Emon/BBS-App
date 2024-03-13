package app.yabrum;

import app.yabrum.gui.MainPanel;
import app.yabrum.gui.MainWindow;

public class Share {
    public static MainWindow window;
    public static MainPanel mainPanel;
    public static final String VERSION = "1.0.1";
    public static final boolean DEBUG_MODE = true;

    public static void init() {
        window = new MainWindow();

        mainPanel = new MainPanel();
    }
}
