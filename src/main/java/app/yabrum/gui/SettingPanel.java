package app.yabrum.gui;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {
    public SettingPanel() {
        setLayout(new BorderLayout());

        var top = new JPanel(new FlowLayout());
        var title = new JLabel("設定");
        title.setFont(new Font("メイリオ", Font.PLAIN, 25));
        top.add(title);


        var center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        var sounds = new JPanel();
        var soundOnOff = new JCheckBox();



        add(top, BorderLayout.NORTH);
    }
}
