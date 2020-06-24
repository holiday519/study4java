package com.ee.interview;

public class Demo15 {

    public static void main(String[] args) {
        System.out.println(exponent2(16));
    }

    public static boolean exponent2(int num) {
        return (num & (num-1)) == 0;
    }
}
