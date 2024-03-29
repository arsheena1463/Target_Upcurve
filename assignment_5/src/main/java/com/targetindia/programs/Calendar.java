package com.targetindia.programs;

import com.targetindia.util.*;

public class Calendar
{
    public static void main(String[] args)
    {
     int month=KeyboardUtil.getInt("Enter the month:");
     int year=KeyboardUtil.getInt("Enter the year:");
     validateMonthYear(month,year);
     printCalendar(month,year);
    }
    public static void validateMonthYear(int month,int year)
    {
        if(month < 1 || month > 12)
        {
            throw new IllegalArgumentException("Entered invalid value for month! Enter a value between 1 and 12");
        }
        if(year < 1)
        {
            throw new IllegalArgumentException("Entered invalid value for year! Enter a value greater than 1");
        }
    }
    public static void printCalendar(int month, int year)
    {
        int noOfDays= numberOfDays(month,year);
        //Using Zeller's Congruence Algorithm
        if(month < 3)
        {
            year -= 1;
            month += 12;
        }
        int q = 1; // First day of the month
        int m = month;
        int K = year % 100;
        int J = year / 100;
        // Zeller's Congruence formula
        int dayOfWeek = (q + (13 * (m + 1) / 5) + K + (K / 4) + (J / 4) - (2 * J)) % 7;
        //Adjusting the result to Java's convention
        dayOfWeek = ((dayOfWeek + 5) % 7)+1;
        System.out.println("Su Mo Tu We Th Fr Sa");
        for(int i=0; i < dayOfWeek; i++)
            System.out.print("   ");
        int start=1;
        for(int i=dayOfWeek;i <= 6; i++,start++)
        {
            System.out.print(start + "  ");
        }
        System.out.println();
        int count=0;
        for(int i=start;i <= noOfDays; i++)
        {
            if(i < 10)
                System.out.print(i+"  ");
            else
                System.out.print(i+" ");
            count++;
            if(count > 6)
            {
                count=0;
                System.out.println();
            }
        }

    }
    public static int numberOfDays(int month,int year)
    {
        switch (month)
        {
            case 2:
                return isLeap(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 31;
    }
    public static boolean isLeap(int year)
    {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
