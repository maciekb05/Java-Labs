package myPackage;

import javaIn.*;

public class HelloWorld {
    public static void main(String [] argv){
        System.out.print("Type a number: ");
        Integer number = JIn.getInteger();
        System.out.println("Hello World");
        for(int i=3; i<number; ++i){
            int sum = 0;
            for(int j=2; j<i; ++j){
                if(i % j == 0){
                    sum++;
                }
            }
            if(sum==0){
                System.out.println(i);
            }
        }
    }
}
