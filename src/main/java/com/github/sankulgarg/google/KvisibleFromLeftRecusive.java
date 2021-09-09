package com.github.sankulgarg.google;

public class KvisibleFromLeftRecusive {
	int dp[][];

	private int kVisibleFromLeftRec(int n, int k) {

		if (dp[n][k] != 0)
			return dp[n][k];
		else if (n == k) {
			dp[n][k] = 1;

		} else if (k == 1) {
			int ans = 1;
			for (int i = 1; i < n; i++)
				ans *= i;
			dp[n][k] = ans;

		} else {
			dp[n][k] = dp[n - 1][k - 1] + (n - 1) * dp[n - 1][k];
		}
		return dp[n][k];

	}

	public int kVisibleFromLeft(int n, int k) {

		dp = new int[n + 1][k + 1];

		return kVisibleFromLeftRec(n, k);
	}

	public static void main(String[] args) {
		System.out.println(new KvisibleFromLeftRecusive().kVisibleFromLeft(5, 2));
	}

}
