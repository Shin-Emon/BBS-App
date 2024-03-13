package app.yabrum.gui;

import app.yabrum.bbs.BBS_DAO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PostForm extends JPanel {
    public PostForm(BBSPanel bbsPanel) {
        var line = new LineBorder(Color.GRAY, 1);
        setBorder(new TitledBorder(line, "投稿", TitledBorder.CENTER, TitledBorder.TOP));
        var main = new JPanel();
        var layout = new BoxLayout(main, BoxLayout.Y_AXIS);
        main.setLayout(layout);


        var namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        var nameLabel = new JLabel("名前");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        var nameInput = new JTextField(20);
        nameLabel.setLabelFor(nameInput);

        namePanel.add(nameLabel);

        var contentLabelPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        var contentLabel = new JLabel("内容");
        var contentInput = new JTextArea(10, 5);
        contentLabel.setLabelFor(contentInput);
        contentInput.setBorder(new LineBorder(Color.GRAY, 1));

        contentLabelPane.add(contentLabel);

        var sendButtonPanel = new JPanel(new FlowLayout());
        var sendButton = new JButton("送信");
        sendButton.setFont(new Font("メイリオ", Font.PLAIN, 15));
        sendButton.setPreferredSize(new Dimension(80, 45));
        sendButton.addActionListener(e -> {
            BBS_DAO.insert(nameInput.getText(), contentInput.getText());
            bbsPanel.updatePosts();
            contentInput.setText("");
        });
        sendButton.setFocusPainted(false);
        sendButtonPanel.add(sendButton);

        main.add(namePanel);
        main.add(nameInput);
        main.add(contentLabelPane);
        main.add(contentInput);
        main.add(sendButtonPanel);

        add(main);
    }
}
