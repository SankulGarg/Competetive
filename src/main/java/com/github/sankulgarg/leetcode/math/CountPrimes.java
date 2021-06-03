package com.github.sankulgarg.leetcode.math;

class CountPrimes {

	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		

		for (int i = 2; i * i < n; i++) {
			
			for (Integer j = i * i; j < n; j = j +i) {
				isPrime[j] = true;
			
			}

		}
		int count = 0;
		for (int i = 2; i < n; i++)
			if (!isPrime[i])
				count++;

		return count;

	}

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(10));
	}
}