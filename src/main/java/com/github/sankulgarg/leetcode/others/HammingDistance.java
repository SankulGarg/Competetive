package com.github.sankulgarg.leetcode.others;
class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}