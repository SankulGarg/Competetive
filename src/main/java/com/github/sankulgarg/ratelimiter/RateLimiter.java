package com.github.sankulgarg.ratelimiter;

import java.util.function.Supplier;

public interface RateLimiter {
    <T> Supplier<T> allowRequest(Supplier<T> supplier);
}
