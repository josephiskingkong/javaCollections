package org.example;

import java.util.Iterator;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 100;
        PrimesGenerator primesGenerator = new PrimesGenerator(N);

        System.out.println("Primes in order:");
        for (int prime : primesGenerator) {
            System.out.print(prime + " ");
        }

        System.out.println("\nPrimes in reverse order:");
        Iterator<Integer> reverseIterator = primesGenerator.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
    }
}