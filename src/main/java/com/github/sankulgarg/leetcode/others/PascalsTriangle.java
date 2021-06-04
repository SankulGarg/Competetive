package com.github.sankulgarg.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalTriangle = new ArrayList<>();

		pascalTriangle.add(Arrays.asList(1));

		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = pascalTriangle.get(i - 1);
			List<Integer> curr=new ArrayList<>();
			curr.add(1);
			for(int j=1;j<prev.size();j++) {
				curr.add(prev.get(j-1)+prev.get(j));
				
			}
			curr.add(1);
			pascalTriangle.add(curr);
			
		}

		return pascalTriangle;

	}
	
	public static void main(String[] args) {
		new PascalsTriangle().generate(7);
	}
}