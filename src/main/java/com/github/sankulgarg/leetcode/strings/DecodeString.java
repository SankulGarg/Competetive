package com.github.sankulgarg.leetcode.strings;

import java.util.Stack;

class DecodeString {
	public String decodeString(String s) {

		Stack<Character> encodedStack = new Stack<>();
		String decodedString = "";
		for (char c : s.toCharArray()) {

			if (c != ']')
				encodedStack.push(c);
			else {
				Character pattern = encodedStack.pop();
				String patt = "";
				while (!Character.isDigit(pattern)) {
					if (pattern != '[')
						patt = pattern + patt;
					pattern = encodedStack.pop();
				}
				String repeat = "";
				while (Character.isDigit(pattern) && !encodedStack.isEmpty()) {
					repeat = pattern + repeat;
					pattern = encodedStack.pop();
				}
				if (Character.isDigit(pattern))
					repeat = pattern + repeat;
				else
					encodedStack.push(pattern);
				int num = Integer.valueOf(repeat);
				StringBuilder repeatingString = new StringBuilder();
				while (num > 0) {

					repeatingString.append(patt);
					num--;
				}

				repeatingString.chars().forEach(p -> encodedStack.push((char) p));
			}

		}
		while (!encodedStack.isEmpty())
			decodedString = encodedStack.pop() + decodedString;
		return decodedString;

	}

	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("100[leetcode]"));
	}
}