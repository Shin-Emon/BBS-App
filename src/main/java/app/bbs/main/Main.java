package app.bbs.main;

import app.bbs.util.Share;

import javax.swing.*;

/**
 * クラス Main
 * エントリポイント mainメソッドを保有する
 * @author shin
 * @see Share
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Share.init();

        Share.window.add(Share.mainPanel);
        Share.window.setSize(1000, 700);
        Share.window.setLocationRelativeTo(null);

        Share.window.setVisible(true);
    }
}
