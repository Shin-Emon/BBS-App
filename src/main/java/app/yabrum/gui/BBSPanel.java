package app.yabrum.gui;

import app.yabrum.bbs.BBS_DAO;
import app.yabrum.data.Post;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class BBSPanel extends JPanel {
    private JPanel postsPane = new JPanel();
    private JPanel center = new JPanel();
    public BBSPanel() {
        center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
        setLayout(new BorderLayout());

        var top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        postsPane.setLayout(new BoxLayout(postsPane, BoxLayout.Y_AXIS));

        var title = new JLabel("掲示板");
        title.setFont(new Font("メイリオ", Font.PLAIN, 25));
        top.add(title);

        var scrollPane = new JScrollPane(center);

        var under = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        var reload = new JButton(Icons.RELOAD);
        reload.setFocusPainted(false);
        reload.addActionListener(e -> updatePosts());
        under.add(reload);

        center.add(new PostForm(this));
        center.add(postsPane);
        center.add(Box.createVerticalGlue());

        // MAIN
        initPosts();

        add(top, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(under, BorderLayout.SOUTH);
    }

    public void initPosts() {
        BBS_DAO.getAllPosts().forEach(post -> postsPane.add(new PostPanel(post.id(), post.name(), post.content()), 0));
    }

    public void updatePosts() {
        BBS_DAO.getNewPosts().forEach(post -> postsPane.add(new PostPanel(post.id(), post.name(), post.content()), 0));
    }
}
