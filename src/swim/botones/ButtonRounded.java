package swim.botones;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonRounded extends JButton {
    

  

    public ButtonRounded() {
        this.setContentAreaFilled(false);
        this.setBorder(new EmptyBorder(10, 30, 10, 30));
        this.setBackground(new Color(0, 0, 0, 0));

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(this.getBackground());
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 35, 35);

        super.paintComponent(g);
    }

}
