package app.bbs.util;

import app.bbs.gui.BBSPanel;

import javax.swing.*;
import java.awt.*;

/**
 * クラス Share
 * 共有したい情報を保持する。
 * スレッドセーフでないpublic static変数のため、スレッドを用いる際はgetter/setterに変更すること。
 * (ただし、保有しているデータのうちwindow, mainPanelはインスタンスなので、データが破壊されることはない）
 * @author shin
 * @see javax.swing.JFrame
 * @see javax.swing.JPanel
 */
public class Share {
    public static JFrame window;
    public static JPanel mainPanel;
    // true：ローカルIPアドレスでサーバーに接続
    // false: グローバルIP (ダイナミックDNS) アドレスでサーバーに接続
    public static final boolean DEBUG_MODE = true;

    public static void init() {
        window = new JFrame("掲示板アプリ");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800, 500));
        mainPanel.add(new BBSPanel());
    }
}
