package app.yabrum.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {
    private List<JButton> sideButtons = new ArrayList<>();
    private int index = 0;
    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private HomePanel homePanel = new HomePanel();
    private BBSPanel bbsPanel = new BBSPanel();
    private SettingPanel settingPanel = new SettingPanel();
    private JButton home = new JButton(Icons.HOME);
    private JButton bbs = new JButton(Icons.BBS);
    private JButton setting = new JButton(Icons.SETTING);
    private JButton information = new JButton(Icons.INFORMATION);
    private CardLayout layout = new CardLayout();
    private final Color SELECTED_COLOR = Color.LIGHT_GRAY;

    public MainPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 500));

        add(sideBar(), BorderLayout.WEST);
        add(mainPanel(), BorderLayout.CENTER);
    }

    private JPanel mainPanel() {
        mainPanel.setLayout(layout);

        mainPanel.add(homePanel, "home");
        mainPanel.add(bbsPanel, "bbs");
        mainPanel.add(settingPanel, "setting");

        return mainPanel;
    }

    private JPanel sideBar() {
        var pane = new JPanel();
        var flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);

        pane.setBackground(Color.WHITE);

        pane.setLayout(flowLayout);
        pane.setPreferredSize(new Dimension(100, 500));

        var vertical = new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setBackground(Color.WHITE);

        home.setBorderPainted(false);
        home.setBackground(SELECTED_COLOR);
        home.setPreferredSize(new Dimension(90, 90));

        home.addActionListener(this::sideButtonListener);
        home.setActionCommand("home");
        home.setFocusPainted(false);
        sideButtons.add(home);
        vertical.add(home);

        bbs.setBorderPainted(false);
        bbs.setBackground(Color.WHITE);
        bbs.setPreferredSize(new Dimension(90, 90));

        bbs.addActionListener(this::sideButtonListener);
        bbs.setActionCommand("bbs");
        bbs.setFocusPainted(false);
        sideButtons.add(bbs);
        vertical.add(bbs);

        setting.setBorderPainted(false);
        setting.setBackground(Color.WHITE);
        setting.setPreferredSize(new Dimension(90, 90));

        setting.addActionListener(this::sideButtonListener);
        setting.setActionCommand("setting");
        setting.setFocusPainted(false);
        sideButtons.add(setting);
        vertical.add(setting);

        pane.add(vertical);

        return pane;
    }

    private void sideButtonListener(ActionEvent event) {
        var cmd = event.getActionCommand();

        sideButtons.forEach(btn -> btn.setBackground(Color.WHITE));

        switch (cmd) {
            case "home" -> home.setBackground(SELECTED_COLOR);
            case "bbs" -> bbs.setBackground(SELECTED_COLOR);
            case "setting" -> setting.setBackground(SELECTED_COLOR);
        }

        layout.show(mainPanel, cmd);
    }
}
