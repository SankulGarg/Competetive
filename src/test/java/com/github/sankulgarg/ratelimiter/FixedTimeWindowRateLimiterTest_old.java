package com.github.sankulgarg.ratelimiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FixedTimeWindowRateLimiterTest_old {

    @Test
    public void testRateLimiterMultipleThreads() throws InterruptedException, ExecutionException {
        int limit = 5;
        int windowSeconds = 1;
        FixedTimeWindowRateLimiter rateLimiter = new FixedTimeWindowRateLimiter(limit, windowSeconds);
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 threads
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(executor.submit(() -> {
                for (int j = 0; j < limit + 1; j++) {
                    if (j < limit) {
                        // Expecting no exception
                        assertDoesNotThrow(() -> rateLimiter.allowRequest(supplier).get());
                    } else {
                        // Expecting RuntimeException due to rate limit exceeded
                        assertThrows(RuntimeException.class, () -> rateLimiter.allowRequest(supplier).get());
                    }
                }
            }));
        }

        // Wait for all tasks to complete and check their results
        for (Future<?> future : futures) {
            future.get();
        }

        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS);
    }

    Supplier<Boolean> supplier = () -> {
        System.out.println("Thread: " + Thread.currentThread().getName() + " Hello");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true; // Supplier that always returns true
    };
}
