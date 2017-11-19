import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape{
    Circle(String name){
        this.name = name;
    }
    public void draw(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D e = new Ellipse2D.Double(100,100,200,200);
        g.draw(e);
    }
}
