package com.github.sankulgarg.leetcode.linkedLists;

class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			// odd case
			slow = slow.next;
		}

		ListNode curr = slow;
		ListNode prev = null;

		while (curr != null) {

			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		while (prev != null && head != null) {
			if (prev.val != head.val)
				return false;
			
			prev=prev.next;
			head=head.next;

		}
		return true;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(slow); System.out.println(prev); System.out.println(head);
		 */
		System.out.println(
				new IsPalindrome().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
	}
}