package org.yumamur;

import java.util.Random;

public class HigherLower {
    public static int m1(int a, int b) {
        int result;
        if (a > b)
            result = multiply(a, b);
        else
            result = Integer.sum(a, b);
        return result;
    }
    public static int m2(int a, int b) {
        if (a > b)
            return a * b;
        return a + b;
    }
    private static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Random rand = new Random(7815263);
        long start, end, d1, d2;
        start = System.nanoTime();
//        for (int i = 0; i < 1; ++i)
        m1(rand.nextInt(), rand.nextInt());
        end = System.nanoTime();
        d1 = end - start;
        start = System.nanoTime();
//        for (int i = 0; i < 1; ++i)
        m2(rand.nextInt(), rand.nextInt());
        end = System.nanoTime();
        d2 = end - start;
        System.out.printf("%d\n%d", d1, d2);
    }
}