import java.awt.*;

public class Square extends Shape {
    Square() {
        this.height = 100;
        this.width = 100;
        this.x = 200;
        this.y = 50;
    }
    public void draw(Graphics graphics){
        graphics.drawRect(x,y,width,height);
        //JComponent parameters (Shape extends JComponent): 
        this.setSize(width,height);
        this.setLocation(x,y);
    }
}