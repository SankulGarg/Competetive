package com.github.sankulgarg.leetcode.strings;

class StrStr {
	public int strStr(String haystack, String needle) {
		if (haystack.length() == 0 || needle.length() == 0)
			return 0;

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				boolean isPresent = false;
				while (j < needle.length() && j + i < haystack.length()) {
					if (haystack.charAt(j + i) != needle.charAt(j))
						break;
					else {
						
						j++;
						if (j == needle.length())
							isPresent = true;

					}
				}

				if (isPresent)
					return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		new StrStr().strStr("hello", "ll");
	}
}