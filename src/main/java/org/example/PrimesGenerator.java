package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PrimesGenerator implements Iterable<Integer> {
    private List<Integer> primes;

    public PrimesGenerator(int n) {
        primes = new ArrayList<>();
        generatePrimes(n);
    }

    private void generatePrimes(int n) {
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                primes.add(number);
                count++;
            }
            number++;
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    public Iterator<Integer> reverseIterator() {
        return new Iterator<Integer>() {
            private int currentIndex = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public Integer next() {
                return primes.get(currentIndex--);
            }
        };
    }
}