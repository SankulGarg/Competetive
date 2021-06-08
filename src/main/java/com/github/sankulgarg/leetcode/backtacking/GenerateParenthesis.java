package com.github.sankulgarg.leetcode.backtacking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GenerateParenthesis {
	List<String> solution = null;

	private void generateParenthesis(int n, int i, int j, StringBuilder combination) {

		if (combination.length() == 2 * n) {
			solution.add(combination.toString());
			return;
		}

		if (i < n) {
			combination.append("(");
			generateParenthesis(n, i + 1, j, combination);
			combination.deleteCharAt(combination.length() - 1);
		}
		if (j < i) {
			combination.append(")");
			generateParenthesis(n, i, j + 1, combination);
			combination.deleteCharAt(combination.length() - 1);
		}
	}

	private boolean isValid(StringBuilder combination) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < combination.length(); i++) {
			char c = combination.charAt(i);
			if (c == '(')
				stack.add(c);
			else if (stack.isEmpty())
				return false;
			else
				stack.pop();

		}

		return stack.isEmpty();
	}

	public List<String> generateParenthesis(int n) {
		solution = new ArrayList<>();
		generateParenthesis(n, 1, 0, new StringBuilder("("));
		return solution;
	}

}