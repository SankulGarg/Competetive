package com.github.sankulgarg.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class RateLimiterTest {
    public static void main(String[] args) {
        System.out.println("RateLimiterTest");

        FixedTimeWindowRateLimiter fixedTimeWindowRateLimiter = new FixedTimeWindowRateLimiter(2, 1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println(fixedTimeWindowRateLimiter.allowRequest(supplier).get());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }

//        LeakyBucketRateLimiter leakyBucketRateLimiter = new LeakyBucketRateLimiter(2, 2);
//        for (int i = 0; i < 100; i++) {
//            executorService.submit(() -> {
//                try {
//                    System.out.println("Leaky: " +leakyBucketRateLimiter.allowRequest(supplier).get());
//                } catch (Exception e) {
//                    System.out.println("Leaky: " + e.getMessage());
//                }
//            });
//        }

        executorService.shutdown();
    }


    static Supplier<String> supplier = () -> {
        return "Thread " + Thread.currentThread().getName() + " Hello";
    };
}
