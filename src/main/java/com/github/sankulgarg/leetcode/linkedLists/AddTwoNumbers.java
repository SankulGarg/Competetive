package com.github.sankulgarg.leetcode.linkedLists;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode sol=new ListNode(0);
		ListNode p = sol;
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(carry % 10);
			carry /= 10;
			p = p.next;
		}
		return sol.next;
	}

	public static void main(String[] args) {
		new AddTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
				new ListNode(5, new ListNode(6, new ListNode(4))));
	}
}
