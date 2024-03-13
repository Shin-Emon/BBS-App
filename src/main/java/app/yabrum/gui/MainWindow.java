package app.yabrum.gui;

import app.yabrum.Share;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("ヤブラム教の神聖なアプリ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var menuBar = new JMenuBar();

        var file = new JMenu("ファイル");
        var exit = new JMenuItem("終了");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        var information = new JMenu("情報");
        var about = new JMenuItem("このアプリについて");
        about.addActionListener(e -> JOptionPane.showMessageDialog(this, String.format("ヤブラム教のアプリ\nVer. %s", Share.VERSION), "このアプリについて", JOptionPane.INFORMATION_MESSAGE));
        information.add(about);

        menuBar.add(file);
        menuBar.add(information);

        setJMenuBar(menuBar);

        pack();
    }
}
