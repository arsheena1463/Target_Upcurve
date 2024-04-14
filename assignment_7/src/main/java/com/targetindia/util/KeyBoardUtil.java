package com.targetindia.util;

import java.util.Scanner;

public class KeyboardUtil {

    public static int getInt(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }
    public static String getString(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

}
