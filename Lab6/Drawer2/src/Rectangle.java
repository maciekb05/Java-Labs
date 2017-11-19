import java.awt.*;

public class Rectangle extends Shape {
    Rectangle(String name){
        this.name = name;
    }
    public void draw(Graphics graphics){
        graphics.drawRect(100, 100, 200, 300);
    }
}