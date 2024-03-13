package app.yabrum;

import app.yabrum.music.ThemeSong;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Share.init();

        Share.window.add(Share.mainPanel);
        Share.window.pack();
        Share.window.setLocationRelativeTo(null);

        Share.window.setVisible(true);

        ThemeSong.start();
    }
}
