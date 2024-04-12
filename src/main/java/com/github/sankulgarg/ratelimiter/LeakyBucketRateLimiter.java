package com.github.sankulgarg.ratelimiter;

import java.util.function.Supplier;

public class LeakyBucketRateLimiter implements RateLimiter {
    private final long bucketCapacity;
    private final int rateAtWhichBucketEmpties;
    private long currentWaterLevel;
    private long lastRefillTime;

    public LeakyBucketRateLimiter(long bucketCapacity, int rateAtWhichBucketEmpties) {
        this.bucketCapacity = bucketCapacity;
        this.rateAtWhichBucketEmpties = rateAtWhichBucketEmpties;
        this.currentWaterLevel = 0;
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public <T> Supplier<T> allowRequest(Supplier<T> supplier){
        return () -> {
            long currentTime = System.currentTimeMillis();
            long timeElapsed = currentTime - lastRefillTime;
            lastRefillTime = currentTime;
            long waterLeaked = timeElapsed * rateAtWhichBucketEmpties / 1000;
            long waterLevel = currentWaterLevel - waterLeaked;
            if(waterLevel < bucketCapacity){
                currentWaterLevel = waterLevel + 1;
                return supplier.get();
            } else {
                throw new RuntimeException("Rate limit exceeded");
            }
        };
    }
}