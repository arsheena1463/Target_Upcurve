package com.targetindia.util;

import java.util.Scanner;

public class KeyboardUtil {
    public static String getString(String message){
        System.out.print(message);
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        return s;
    }
    public static int getInt(String message){
        System.out.print(message);
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        return i;
    }
    public static double getDouble(String message){
        System.out.print(message);
        Scanner sc=new Scanner(System.in);
        double d=sc.nextDouble();
        return d;
    }

}
