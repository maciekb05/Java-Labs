package pkg2;

import pkg1.B;

public class C extends B {
    public static void main(String[] args) {
        C obj = new C();
        System.out.println(obj.number);
        System.out.println(obj.name);
    }
}
