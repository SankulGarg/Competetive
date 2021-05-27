package com.github.sankulgarg.leetcode.strings;

class AToi {
	public int myAtoi(String s) {

		s = s.trim();
		if (s.length() == 0)
			return 0;
		int sol = 0;
		int ind = 0;
		boolean neg = false;
		if (s.charAt(0) == '-') {
			ind = 1;
			neg = true;
		} else if (s.charAt(0) == '+')
			ind = 1;
		for (int i = ind; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ' ' || c > '9' || c < '0')
				break;

			try {
				sol = Math.addExact(Math.multiplyExact(sol, 10) , (c - 48));
			}

			catch (ArithmeticException e) {
				if (neg)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;

			}

		}

		if (neg)
			return sol * -1;
		else
			return sol;

	}
	
	public static void main(String[] args) {
		System.out.println(new AToi().myAtoi("2147483648"));
	}
}