import javax.swing.*;
import java.awt.*;


public abstract class Shape extends JComponent {
    int width;
    int height;
    int x;
    int y;

    abstract void draw(Graphics graphics);

    @Override
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
