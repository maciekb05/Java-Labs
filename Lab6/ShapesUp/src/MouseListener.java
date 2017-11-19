import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private Point p;
    public void mousePressed(MouseEvent e) {
        p = e.getPoint();
        ((UpgradedShape)e.getComponent()).setAlpha(100);
        e.getComponent().repaint();
    }

    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        ((UpgradedShape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((UpgradedShape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        ((UpgradedShape)e.getComponent()).setAlpha(255);
        e.getComponent().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        ((UpgradedShape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((UpgradedShape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        e.getComponent().repaint();
    }
}
