import java.awt.*;

public class Circle extends Shape {
    Circle() {
        this.height = 100;
        this.width = 100;
        this.x = 50;
        this.y = 50;
    }
    public void draw(Graphics graphics){
        graphics.drawOval(x,y,width,height);
        //JComponent parameters (Shape extends JComponent):
        this.setSize(width,height);
        this.setLocation(x,y);
    }
}
