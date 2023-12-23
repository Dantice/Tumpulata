package view;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class CircleBorder extends AbstractBorder {
    private int thickness;
    private Color shadow;
    
    public CircleBorder(int thic, Color shadCol) {
        thickness = thic;
        shadow = shadCol;
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int diameter = Math.min(width - thickness, height - thickness);
        Ellipse2D circle = new Ellipse2D.Double(x + thickness / 2, y + thickness / 2, diameter*0.9, diameter*0.9);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(circle);

        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0); // Nessun margine
    }
}
