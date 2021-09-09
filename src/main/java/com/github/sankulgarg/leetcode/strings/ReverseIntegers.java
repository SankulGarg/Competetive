package com.github.sankulgarg.leetcode.strings;

class ReverseIntegers {
	public int reverse(int x) {

		int sol=0;
		int y=0;
		while (x!=0) {
			y=x%10;
			x=x/10;
			
 			try{sol= Math.multiplyExact(sol, 10) +y ;
 			}
 			
 			catch(ArithmeticException e) {
	                return 0;}
			
		}
		return sol;

	}

	public static void main(String[] args) {
		ReverseIntegers sol = new ReverseIntegers();
		System.out.println(sol.reverse(153423646));

	}
}