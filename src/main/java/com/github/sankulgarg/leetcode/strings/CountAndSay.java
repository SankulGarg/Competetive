package com.github.sankulgarg.leetcode.strings;

class CountAndSay {
	public String countAndSay(int n) {
		String lastNo = "1";

		for (int i = 1; i < n; i++) {
			StringBuilder currNo = new StringBuilder();
			for (int j = 0; j < lastNo.length(); j++) {
				int count = 1;
				int last = lastNo.charAt(j);
				while (++j < lastNo.length()) {
					if (last == lastNo.charAt(j))
						count++;
					else {
						j--;
						break;
					}
				}
				currNo.append(count).append(last - '0');
			}
			lastNo = currNo.toString();

		}
		return lastNo;
	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(10));
	}
}