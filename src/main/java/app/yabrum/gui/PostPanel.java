package app.yabrum.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PostPanel extends JPanel {
    public PostPanel(int id, String name, String content) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        var main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        var l_id = new JLabel();
        l_id.setFont(new Font("メイリオ", Font.ITALIC, 13));

        var l_name = new JLabel();
        l_name.setFont(new Font("メイリオ", Font.ITALIC, 13));

        var l_content = new JLabel();
        l_content.setFont(new Font("メイリオ", Font.BOLD, 15));

        l_id.setText("ID: " + id);
        l_id.setForeground(Color.BLUE);
        l_name.setText(name);
        l_content.setText(content);

        var top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        var contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        top.add(l_id);
        top.add(l_name);

        var toLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toLeft.add(l_content);
        contentPanel.add(toLeft);

        main.add(top);
        main.add(contentPanel);

        this.add(main);
    }
}
