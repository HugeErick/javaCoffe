package panels;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private final int cornerRadius;

    public CenterPanel(int radius) {
        super();
        this.cornerRadius = radius;
        this.setOpaque(false);
        Color airForceBlue = new Color(92, 128, 160);
        this.setBackground(airForceBlue);
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draws the rounded panel with borders.
        graphics2D.setColor(getBackground());
        graphics2D.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Paint background
        graphics2D.setColor(getForeground());
        graphics2D.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Paint border
    }
}
