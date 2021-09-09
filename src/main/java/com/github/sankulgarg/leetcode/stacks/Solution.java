package com.github.sankulgarg.leetcode.stacks;

import java.util.Stack;

import com.github.sankulgarg.leetcode.stacks.Solution.Data;

class Solution {
	class Data {
		int val;
		boolean left;
		int ind;

		Data(int val, int ind, boolean left) {
			this.val = val;
			this.ind = ind;
			this.left = left;
		}
	}

	public int[] maxNumber(int[] num1, int[] num2, int k) {

		Stack<Data> stack = new Stack<>();
		int i = 0;
		int j = 0;

		while (k >= 0 && (i < num1.length || j < num2.length)) {
			Data num;
			if (i < num1.length && num1[i] > num2[j]) {
				num = new Data(num1[i], i, true);
				i++;
			} else {
				num = new Data(num2[j], j, false);
				j++;
			}
			while (!stack.isEmpty() && stack.peek().val < num.val && num1.length + num2.length - k > 0) {
				Data pop = stack.pop();
				if (num.left && !pop.left)
					j = pop.ind;
				else if (!num.left && pop.left)
					i = pop.ind;
			}
			stack.push(num);
			k = stack.size();
			
		}
		int[] result = new int[stack.size()];
		i = stack.size() - 1;
		while (!stack.isEmpty()) {
			result[i] = stack.pop().val;
			i--;
		}
		return result;
	}

	public static void main(String[] args) {
		new Solution().maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 0);
	}
}