package pkg2;

import pkg1.B;

public class C extends B {
    void changeName(){
        //!name = "C.changeName";
    }
    public static void main(String[] args){
        C obj = new C();
        obj.callChangeName();
        obj.callIncrement();
        //!System.out.println(obj.name);
        System.out.println(obj.number);
        obj.callDecrement();
        System.out.println(obj.number);
    }
}
