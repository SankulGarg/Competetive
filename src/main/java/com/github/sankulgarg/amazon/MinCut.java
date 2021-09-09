package com.github.sankulgarg.amazon;

public class MinCut {
	public int minCut(String string, int i, int j) {
		if (i >= j || isPalindrome(string, i, j))
			return 0;
		int ans = Integer.MAX_VALUE, count;
		for (int k = i; k < j; k++) {
			count = minCut(string, i, k) + minCut(string, k + 1, j) + 1;

			ans = Math.min(ans, count);
		}
		return ans;
	}

	private boolean isPalindrome(String str,int start, int end) {
		
		int i = start;
		int j = end;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new MinCut().minCut("baaba",0,4));
	}
}
