import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private Point p;
    public void mousePressed(MouseEvent e) {
        p = e.getPoint();
        e.getComponent().repaint();
    }
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        ((Shape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((Shape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        e.getComponent().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        ((Shape) e.getComponent()).setX(e.getComponent().getX() + e.getX() - p.x);
        ((Shape) e.getComponent()).setY(e.getComponent().getY() + e.getY() - p.y);
        e.getComponent().repaint();
    }
}
