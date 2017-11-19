package pkg1;

public class B extends A {
    protected void decrement(){
        number -= 2;
    }
    void changeName(){
        name = "B.changeName";
    }
    private void increment(){
        number += 2;
    }
    public B(){
        super(20, "Utworzona w B");
        System.out.println("B()");
    }
    public static void main(String[] args){
        B obj = new B();
        obj.callChangeName();
        obj.callIncrement();
        System.out.println(obj.name);
        System.out.println(obj.number);
        obj.callDecrement();
        System.out.println(obj.number);
    }
}
