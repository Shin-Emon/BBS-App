package app.yabrum.gui;

import app.yabrum.Main;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class HomePanel extends JPanel {
    private BufferedImage[] slideImages = new BufferedImage[3];
    private JLabel currentImage = new JLabel();
    private Timer slideTimer = new Timer(4500, this::slide);
    private int index = 0;

    private void slide(ActionEvent actionEvent) {
        if (index > 2) {
            index = 0;
        }

        currentImage.setIcon(new ImageIcon(slideImages[index]));

        index++;
    }

    private void initImages() {
        try {
            for (int i = 0; i < 3; i++) {
                slideImages[i] = Scalr.resize(
                        ImageIO.read(Main.class.getClassLoader().getResource("images/top-image" + (i+1) + ".jpg")),
                        Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_TO_WIDTH,
                        620
                );

                currentImage.setIcon(new ImageIcon(slideImages[index]));
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HomePanel() {
        initImages();

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(0x2D3250));
        setPreferredSize(new Dimension(700, 500));

        var title = new JLabel("ヤブラム教");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("メイリオ", Font.PLAIN, 30));
        add(title);

        add(currentImage);

        slideTimer.start();
    }
}
