import java.awt.*;

public class Rectangle extends Shape {
    Rectangle() {
        this.height = 100;
        this.width = 50;
        this.x = 200;
        this.y = 200;
    }
    public void draw(Graphics graphics){
        graphics.drawRect(x,y,width,height);
        //JComponent parameters (Shape extends JComponent): 
        this.setSize(width,height);
        this.setLocation(x,y);
    }
}