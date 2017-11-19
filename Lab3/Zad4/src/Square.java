public class Square extends Shape {
    Square(String name){
        this.name = name;
    }
    public void draw(){
        System.out.println("Square " + name);
    }
}