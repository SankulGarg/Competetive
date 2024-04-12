package com.github.sankulgarg.ratelimiter;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FixedTimeWindowRateLimiterTest {
    private final int limit = 2;
    private final int windowSeconds = 1;
    private final Lock lock = new ReentrantLock();
    private final FixedTimeWindowRateLimiter rateLimiter = new FixedTimeWindowRateLimiter(limit, windowSeconds);

    @Test
    public void testAllowRequest() {
        assertEquals("Hello, World!", rateLimiter.allowRequest(supplier).get());
    }

    @Test
    public void testAllowRequestInternal() {
        assertEquals("Hello, World!", rateLimiter.allowRequestInternal(supplier));
    }

    @Test
    public void testRateLimitExceeded() {
        for (int i = 0; i < limit; i++) {
            rateLimiter.allowRequest(supplier).get();
        }
        assertThrows(RuntimeException.class, ()->rateLimiter.allowRequest(supplier).get());
    }

    @Test
    public void testRateLimitExceededMultipleThreads() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.
                newFixedThreadPool(10); // 10 threads
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                for (int j = 0; j < limit + 1; j++) {
                    if (j < limit) {
                        assertTrue(rateLimiter.allowRequest(supplier).get().contains("Hello"));
                    } else {
                        assertThrows(RuntimeException.class, () -> rateLimiter.allowRequest(supplier).get());
                    }
                }
            }).get();

        }
        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS);
    }

    private Supplier<String> supplier = () -> {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello, World!";
    };
}