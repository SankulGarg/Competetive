package com.github.sankulgarg.leetcode.others;

import java.util.ArrayList;
import java.util.List;

class ValidParanthesis {
	public boolean isValid(String s) {
		List<Character> charList = new ArrayList<>();
		char prev = '0';

		for (int i = 0; i < s.length(); i++) {
			if ((prev == '0' || prev == '{' || prev == '(' || prev == '[')
					&& (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['))
				charList.add(s.charAt(i));
			else if (((s.charAt(i) == '}' && prev == '{') || (s.charAt(i) == ']' && prev == '[')
					|| (s.charAt(i) == ')' && prev == '(')) &&charList.size()>0 )
				charList.remove(charList.size() - 1);
			else
				return false;
			if (charList.size() - 1 >= 0)
				prev = charList.get(charList.size() - 1);
		}
		return charList.isEmpty();

	}

	public static void main(String[] args) {
		new ValidParanthesis().isValid("}");
	}
}