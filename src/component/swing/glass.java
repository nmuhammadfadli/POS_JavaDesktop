package component.swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class glass extends JComponent {

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public glass() {
    }

    private float alpha = 0f;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.gray);
        g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 5, 5);
//        g2.fillRect(5, 5, getWidth() - 10, getHeight() - 10);
        g2.dispose();
        super.paintComponent(g);
    }
}
