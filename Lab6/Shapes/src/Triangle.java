import java.awt.*;

public class Triangle extends Shape {
    Triangle() {
        this.height = 100;
        this.width = 100;
        this.x = 50;
        this.y = 200;
    }
    public void draw(Graphics graphics){
        graphics.drawPolygon(new int[]{this.x, this.x + this.width, x + width / 2},
                new int[]{this.y + height, this.y + height, this.y}, 3);
        //JComponent parameters (Shape extends JComponent): 
        this.setSize(width,height);
        this.setLocation(x,y);
    }
}