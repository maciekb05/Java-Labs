import java.awt.*;
import java.util.Random;

public class Triangle extends UpgradedShape {

    public Triangle() {
        Random rand = new Random();
        this.width = 100;
        this.height = 100;

        this.x = rand.nextInt(1280 - this.width);
        this.y = rand.nextInt(720 - this.height - 30);

        color_r = rand.nextInt(255);
        color_g = rand.nextInt(255);
        color_b = rand.nextInt(255);

        this.alpha = 255;
    }

    @Override
    public void draw(Graphics in) {
        in.setColor(new Color(color_r, color_g, color_b, alpha));
        in.fillPolygon(new int[]{this.x, this.x + this.width, x + width / 2},
                new int[]{this.y + height, this.y + height, this.y}, 3);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}
