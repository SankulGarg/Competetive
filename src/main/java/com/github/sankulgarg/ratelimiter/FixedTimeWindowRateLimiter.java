package com.github.sankulgarg.ratelimiter;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

// Fixed Time Window Rate Limiter
public class FixedTimeWindowRateLimiter implements RateLimiter {
    private final int limit; // Maximum number of requests allowed within the time window
    private final int windowSeconds; // Duration of the time window in seconds
    private final Queue<Instant> requestQueue; // Queue to store request timestamps
    private final Lock lock = new ReentrantLock();


    FixedTimeWindowRateLimiter(int limit, int windowSeconds) {
        this.limit = limit;
        this.windowSeconds = windowSeconds;
        this.requestQueue = new ArrayDeque<>(limit);
    }

    @Override
    public <T> Supplier<T> allowRequest(Supplier<T> supplier) {
        return () -> {
            lock.lock();
            try {
                clearExpiredRequests();
                return allowRequestInternal(supplier);
            } finally {
                lock.unlock();
            }
        };
    }

    <T> T allowRequestInternal(Supplier<T> supplier) {
        if (requestQueue.size() < limit) {
            requestQueue.add(Instant.now()); // Add current request timestamp to the queue
            return supplier.get(); // Request is allowed
        } else {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Rate limit exceeded");
            throw new RuntimeException("Rate limit exceeded");
        }
    }


    private void clearExpiredRequests() {
        Instant currentTime = Instant.now();
        Instant windowStart = currentTime.minusSeconds(windowSeconds);
        while (!requestQueue.isEmpty() && requestQueue.peek().isBefore(windowStart)) {
            requestQueue.poll();
        }
    }

}