package me.eyxz;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {

    public static List<Long> getPrimeFactors(long number) {
        List<Long> factors = new ArrayList<>();
        long current = number;

        while (current % 2 == 0) {
            factors.add(2L);
            current /= 2;
        }

        for (long divisor = 3; divisor * divisor <= current; divisor += 2) {
            while (current % divisor == 0) {
                factors.add(divisor);
                current /= divisor;
            }
        }

        if (current > 2) {
            factors.add(current);
        }

        return factors;
    }
}