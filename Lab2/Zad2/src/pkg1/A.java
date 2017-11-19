package pkg1;

public class A {
    protected int number;
    String name;
    public A(int number, String name){
        System.out.println("A()");
        this.number = number;
        this.name = name;
    }
    public void callDecrement(){
        decrement();
    }
    public void callChangeName(){
        changeName();
    }
    public void callIncrement(){
        increment();
    }
    private void increment(){
        number += 1;
    }
    protected void decrement(){
        number -= 1;
    }
    void changeName(){
        name = "A.ChangeName";
    }
    public static void main(String[] args){
        A obj = new A(20,"Nazwa");
        obj.callChangeName();
        obj.callIncrement();
        System.out.println(obj.name);
        System.out.println(obj.number);
        obj.callDecrement();
        System.out.println(obj.number);
    }
}
