package com.github.sankulgarg.leetcode.strings;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FirstUniqChar {
	
	private class CountAndIndex{
		int count=1;
		int ind;
		CountAndIndex(int ind){
			this.ind=ind;
		}
		CountAndIndex incCount() {
			count++;
			return this;
		}
		@Override
		public String toString() {
			return "CountAndIndex [count=" + count + ", ind=" + ind + "]";
		}
		
	}
	public int firstUniqChar(String s) {
		int ind = s.length();

		/*
		 * Map<Character, Long> map = IntStream.range(0, ind).boxed()
		 * .collect(Collectors.groupingBy(i -> s.charAt(i), Collectors.counting()));
		 */
		Map<Character, int[]> map2 = IntStream.range(0, ind).boxed().collect(Collectors.toMap(i -> s.charAt(i),
				i -> new int[] { 1, i }, (o1, o2) -> new int[] { o1[0] + 1, o1[1] }));

		
		Map<Character, CountAndIndex> map3 = IntStream.range(0, ind).boxed().collect(Collectors.toMap(i -> s.charAt(i),
				i -> new CountAndIndex (i ), (o1, o2) -> o1.incCount()));

		System.out.println(map3);
		
		for (Map.Entry<Character, int[]> entry : map2.entrySet()) {

			System.out.println(entry.getKey() + " : " + entry.getValue()[0] + " " + entry.getValue()[1]);
			
			if(entry.getValue()[0]==1 && entry.getValue()[1]<ind)
				ind=entry.getValue()[1];
		}

		return ind;
		
	}

	public static void main(String[] args) {
		FirstUniqChar sol = new FirstUniqChar();
		System.out.println(sol.firstUniqChar("geeksforgeeks"));
	}
}