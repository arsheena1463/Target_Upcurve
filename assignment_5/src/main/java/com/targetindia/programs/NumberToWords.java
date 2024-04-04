package com.targetindia.programs;

//import com.targetindia.util.KeyboardUtil;

public class NumberToWords {
    public static void main(String[] args) {
        //int number= KeyboardUtil.getInt("Enter a number");
        NumberToWords obj = new NumberToWords();
        //System.out.println(obj.inWords(number));
        System.out.println(obj.inWords(7));
        System.out.println(obj.inWords(10));
        System.out.println(obj.inWords(13));
        System.out.println(obj.inWords(52));
        System.out.println(obj.inWords(998));
        System.out.println(obj.inWords(5670));
        System.out.println(obj.inWords(9999));
        System.out.println(obj.inWords(14400));
        System.out.println(obj.inWords(99999));
        System.out.println(obj.inWords(699999));
        System.out.println(obj.inWords(198999));
        System.out.println(obj.inWords(7777777));
        System.out.println(obj.inWords(26678900));
        System.out.println(obj.inWords(700013700));
    }

    public String inWords(int num) {
        String[] s1 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] s2 = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] s3 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (num <= 10) {
            return s1[num];
        } else if (num < 20) {
            return s2[num - 10];
        } else if (num < 100) {
            return s3[num / 10] + " " + inWords(num % 10);
        } else if (num < 1000) {
            return s1[num / 100] + " " + "hundred" + " " + inWords(num % 100);
        } else if (num < 10000) {
            return s1[num / 1000] + " " + "thousand" + " " + inWords(num % 1000);
        } else if (num < 100000) {
            return inWords(num / 1000) + " " + "thousand" + " " + inWords(num % 1000);
        } else if (num < 1000000) {
            return s1[num / 100000] + " " + "lakh" + " " + inWords(num % 100000);
        } else if (num < 10000000) {
            return inWords(num / 100000) + " " + "lakh" +" " + inWords(num % 100000);
        } else if(num < 100000000){
            return s1[num / 10000000] + " " + "crore" + " " + inWords(num % 10000000);
        }else
            return inWords(num / 10000000) + " " + "crore" + " " + inWords(num % 10000000);
    }
}
