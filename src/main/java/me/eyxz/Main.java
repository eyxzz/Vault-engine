package me.eyxz;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== VAULT ENGINE - MULTITHREADED PRIME FACTORIZER ===");
        System.out.println("Developer: eyxz | Runtime: Java 27 Virtual Threads");

        int taskCount = 100;
        Random random = new Random();
        LongAdder completedTasks = new LongAdder();

        Instant startTime = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < taskCount; i++) {
                long targetNumber = 1_000_000_000_000_000L + (long) (random.nextDouble() * 8_000_000_000_000_000L);

                executor.submit(() -> {
                    List<Long> factors = PrimeCalculator.getPrimeFactors(targetNumber);
                    completedTasks.increment();

                    System.out.printf("[Task %d] Number: %d | Factors Count: %d | Thread: %s%n",
                            completedTasks.sum(), targetNumber, factors.size(), Thread.currentThread());
                });
            }
        }

        Instant endTime = Instant.now();
        long totalTime = Duration.between(startTime, endTime).toMillis();

        System.out.println("\n=============================================");
        System.out.println("EXECUTION SUMMARY");
        System.out.println("Total Tasks Processed: " + completedTasks.sum());
        System.out.println("Total Time: " + totalTime + " ms");
        System.out.println("Average Time per Task: " + (totalTime / (double) taskCount) + " ms");
        System.out.println("=============================================");
    }
}