import java.awt.*;

public class Square extends Shape {
    Square(String name){
        this.name = name;
    }
    public void draw(Graphics graphics){
        graphics.drawRect(100, 100, 200, 200);
    }
}