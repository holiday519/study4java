package com.ee.z7z8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrimeDemo {
    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        System.out.println(2);

        int number = 3;
        while (true) {
            boolean isPrime = true;
            for (int prime : primes) {
                if (number % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(number);
                System.out.println(number);
            }
            number ++;
        }
    }
}
