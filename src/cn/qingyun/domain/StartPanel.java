package cn.qingyun.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartPanel extends JPanel {
    int times = 0;
    int userCount = 0;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 800, 400);
        if (times % 2 == 0) {
            g.setColor(Color.red);
            Font myFont = new Font(Font.MONOSPACED, Font.BOLD, 30);
            g.setFont(myFont);
            g.drawString("You need " + (4 - userCount) + " members in the battle", 150, 120);
        }
    }

    public void updateUserCount(int userCount) {
        this.userCount = userCount;
        this.repaint();
    }
}
