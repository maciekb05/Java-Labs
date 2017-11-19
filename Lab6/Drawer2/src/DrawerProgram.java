import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class DrawerProgram extends JFrame{
    public static void main(String [] argv){
        DrawerProgram dp = new DrawerProgram();
        Shape rect = new Rectangle("Prostokat");
        Shape squa = new Square("Kwadrat");
        Shape circ = new Circle("Kolo");
        dp.setSize(450, 450);
        dp.setVisible(true);
        rect.draw(dp.getGraphics());
        circ.draw(dp.getGraphics());
        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
}