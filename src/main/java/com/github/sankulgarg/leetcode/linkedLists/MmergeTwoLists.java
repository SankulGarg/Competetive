package com.github.sankulgarg.leetcode.linkedLists;

class MmergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1==null)
			return l2;
		else if (l2==null)
			return l1;
		ListNode finalList = new ListNode();
		ListNode head = finalList;
		while (l2 != null && l1 != null) {
			if (l1.val <= l2.val) {

				finalList.next = l1;
				l1 = l1.next;
				finalList = finalList.next;
			} else {

				finalList.next = l2;
				l2 = l2.next;
				finalList = finalList.next;

			}

			if (l1 == null)
				finalList.next = l2;
			else if (l2 == null)
				finalList.next = l1;

		}
		return head.next;
	}
}