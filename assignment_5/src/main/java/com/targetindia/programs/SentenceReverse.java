package com.targetindia.programs;

import com.targetindia.util.KeyboardUtil;

public class SentenceReverse {
    public static void main(String[] args) {
        SentenceReverse sr;
        String sentence= KeyboardUtil.getString("Enter a sentence: ");
        sr = new SentenceReverse();
        System.out.println(sr.reverseByWords(sentence));
    }
    public String reverseByWords(String sentence){
        String reverse="";
        var arr = sentence.split(" ");
        for( int i=arr.length - 1 ; i >= 0; i--)
        {
            reverse += arr[i] + " ";
        }
        return reverse;
    }
}
