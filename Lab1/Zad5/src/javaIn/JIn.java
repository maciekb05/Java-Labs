package javaIn;

import java.io.*;

public class JIn {
    public static Integer getInteger() {
        int number = 0;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            String text = bfr.readLine();
            number = Integer.valueOf(text);
        }catch(IOException e){e.printStackTrace();}

        return number;
    }
}