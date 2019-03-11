package com.ckarlsoft;

import java.util.*;

public class HistoDemo{
    public static void main(String[] argv) {
        String answer = Console.readString("random test or self test ? [r,s] : ");
        if (answer.equals("r")) test2();
        else test1();
    }

    public static void test2() {
        Histogram histo = new Histogram(0, 100, 10);
        // RandomIntGenerator random  = new RandomIntGenerator (0,100) ;
        Random random = new Random();
        int val;
        for (int i = 0; i < 500; i++) {
            // val = random.draw() ;
            val = random.nextInt(100) + 1;
            histo.update(val);
        }
        histo.print();
    }

    public static void test1() {
        double low = Console.readDouble("low : ");
        double high = Console.readDouble("high :");
        int n = Console.readInt("number of cells :");

        Histogram histo = new Histogram(low, high, n);

        System.out.println("Feed doubles, stop by feeding a 0");

        double val = Console.readDouble("value :");
        while (val != 0) {
            histo.update(val);
            val = Console.readDouble("value :");
        }
        histo.print();
    }
}