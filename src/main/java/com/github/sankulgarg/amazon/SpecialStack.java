package com.github.sankulgarg.amazon;

import java.util.Stack;

// push, pop and get min all in 0(1)
public class SpecialStack {

	// pick a dummy value say 9999 and always store value in stack as v*d + minSOFar
	//

	int MIN_VAL = Integer.MAX_VALUE;
	int dummy = 9999;

	Stack<Integer> stack = new Stack<>();

	void push(Integer element) {

		if (element < MIN_VAL)
			MIN_VAL = element;

		Integer dataToBeAdded = dummy * element + MIN_VAL;

		System.out.println("data added: " + dataToBeAdded);
		stack.add(dataToBeAdded);

	}

	int getMin() {
		System.out.println("min val: " + MIN_VAL);
		return MIN_VAL;
	}

	int pop() {
		Integer data = stack.pop();
		MIN_VAL = MIN_VAL % dummy;
		System.out.println("datat popped: " + data / dummy);
		return data / dummy;

	}
public static void main(String[] args) {
	SpecialStack sol=new SpecialStack();
	sol.push(3);
	sol.getMin();
	sol.push(1);
	sol.getMin();
	sol.push(4);
	sol.getMin();
	sol.push(2);
	sol.getMin();
	
	sol.pop();
	sol.pop();
	sol.pop();
	sol.pop();
	
}
}
