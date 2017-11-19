public class Rectangle extends Shape {
    Rectangle(){};
    Rectangle(String name){
        this.name = name;
    }
    public void draw(){
        System.out.println("Rectangle " + name);
    }
}