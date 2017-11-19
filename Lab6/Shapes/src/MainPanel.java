import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;

public class MainPanel extends JPanel {
    private LinkedList<Shape> objectsList = new LinkedList<>();
    MainPanel() {
        super();
        this.setBackground(Color.GRAY);
        objectsList.add(new Triangle());
        objectsList.add(new Rectangle());
        objectsList.add(new Circle());
        objectsList.add(new Square());
        for (Shape shape : objectsList) {
            //Adding Listeners
            MyMouseListener listener = new MyMouseListener();
            shape.addMouseListener(listener);
            shape.addMouseMotionListener(listener);
            //Adding shapes to JPanel
            this.add(shape);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape x : objectsList) {
            x.draw(g);
        }
    }

}
