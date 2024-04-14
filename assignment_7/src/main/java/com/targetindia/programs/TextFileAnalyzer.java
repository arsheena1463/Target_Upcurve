package com.targetindia.programs;

import com.targetindia.util.KeyboardUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TextFileAnalyzer {
    public static void main(String[] args) {
        String filename = KeyboardUtil.getString("Enter filename:");
        int numberOfLines=0;

        // finding the number of lines in the entered file
        try( FileInputStream file = new FileInputStream(filename);){
            int ch;
            while((ch = file.read()) != -1){
                if((char)ch == '\n'){
                    numberOfLines++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file doesn't exist");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // adding the sentences to an array of length numberOfLines
        try ( FileInputStream file = new FileInputStream(filename); ){
             int ch;
             int index=0;
             String sentence = "";
             String[] fileContent = new String[numberOfLines+1];
             while((ch = file.read()) != -1) {
                 if ((char) ch != '\n' ) {
                     sentence += (char)ch;
                 }
                 else{
                     fileContent[index] = sentence;
                     sentence = "";
                     index++;
                 }
             }
             fileContent[index] = sentence; // adding the last sentence which doesn't end with a newline character
             //printing the contents of the file
            System.out.println("\nContents of the file: ");
             for(var content: fileContent){
                     System.out.println(content);
             }

             //printing the longest line in the file
            String longestLine = findLongestLine(fileContent);
             int lineNumber = 0;
             for( int i=0; i < fileContent.length; i++){
                 if(longestLine.equalsIgnoreCase(fileContent[i])){
                     lineNumber = i+1;
                 }
             }
            System.out.println("\nLongest line: ");
            System.out.printf("Line %d: %s",lineNumber,longestLine);

            //printing the shortest line in the file
            String shortestLine = findShortestLine(fileContent) ;
            for( int i=0; i < fileContent.length; i++){
                if(shortestLine.equalsIgnoreCase(fileContent[i])){
                    lineNumber = i+1;
                }
            }
            System.out.println("\n\nShortest line: ");
            System.out.printf("Line %d: %s",lineNumber,shortestLine);

            //printing the word count for each line
            int[] wordCount = countWords(fileContent);
            System.out.println("\n\nWord count for each line: ");
            for ( int i = 0; i < wordCount.length ; i++){
                System.out.printf("Line %d: %d words\n",i+1, wordCount[i]);
            }

            //printing the sorted word count
            int[] sortedWordCount = sortWordCount(wordCount);
            System.out.println("\nSorted word count: ");
            for ( int i = 0; i < sortedWordCount.length ; i++){
                System.out.printf("Line %d: %d words\n",i+1, sortedWordCount[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file doesn't exist");
        }
        catch (IOException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());

        }
    }
    public static String findLongestLine(String[] lines){
        String longest = lines[0];
        for(var line: lines){
            if(line.length() > longest.length()){
                longest = line;
            }
        }
        return longest;
    }

    public static String findShortestLine(String[] lines){
        String shortest = lines[0];
        for(var line: lines){
            if(line.length() < shortest.length()){
                shortest = line;
            }
        }
        return shortest;
    }

    public static int[] countWords(String[] lines){
        int[] lineWordCount = new int[lines.length];
        for(int i=0;i < lines.length; i++){
            String line = lines[i];
            int count = 0;
            for(int j=0; j < line.length(); j++){
                if( line.charAt(j) == ' '){
                    count++;
                }
            }
            lineWordCount[i] = count + 1;
        }
        return lineWordCount;
    }

    public static int[] sortWordCount(int[] wordCounts){
        int temp;
        for(int i=0; i < wordCounts.length; i++){
            for( int j=0; j < wordCounts.length-i-1 ; j++){
                if (wordCounts[j] > wordCounts[j+1]){
                    temp = wordCounts[j];
                    wordCounts[j] = wordCounts[j+1];
                    wordCounts[j+1] = temp;
                }
            }
        }
        return wordCounts;
    }
}
