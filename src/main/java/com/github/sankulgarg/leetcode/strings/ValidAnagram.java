package com.github.sankulgarg.leetcode.strings;

class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		int len = s.length();
		if (len != t.length())
			return false;

		int[] counter = new int[26];
		for (int i = 0; i < len; i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}

		 for (int count : counter) {
		        if (count != 0) 
		            return false;
		        }
		    
		return true;
	}
}
