public class Circle extends Shape {
    Circle(String name){
        this.name = name;
    }
    public void draw(){
        System.out.println("Circle " + name);
    }
}
