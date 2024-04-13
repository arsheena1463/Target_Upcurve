package com.targetindia.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        List<String> nonIntegerList = new ArrayList<>();
        boolean isInteger = false;
        String choice;
        int sum = 0;
        while( true ){
            System.out.println("Enter an input: ");
            String enteredInput = sc.nextLine();
            //determining if the entered input is an integer
            for(int i = 0; i < enteredInput.length();i++){
                if(Character.isDigit(enteredInput.charAt(i))) {
                    isInteger = true;
                }
                else{
                      isInteger = false;
                      break;
                    }
            }
            //adding entered input to the respective lists
            if (isInteger == true){
                integerList.add(Integer.parseInt(enteredInput));
                sum += Integer.parseInt(enteredInput);
            }
            else{
                nonIntegerList.add(enteredInput);
            }
            System.out.println("Do you want to  continue (yes/no): ");
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("no")){
                break;
            }
        }
        System.out.println("Number of inputs: " + (integerList.size() + nonIntegerList.size()));
        System.out.println("Number of integer inputs: "+ integerList.size());
        System.out.println("Number of non-integer inputs: "+ nonIntegerList.size());
        System.out.println("Sum of all integer inputs: "+ sum);
        System.out.print("The integer inputs: ");
        for(var value: integerList){
            System.out.print(value + ", ");
        }
        System.out.println();
        System.out.print("The non-integer inputs: ");
        for(var value: nonIntegerList){
            System.out.print(value + ", ");
        }
    }
}
