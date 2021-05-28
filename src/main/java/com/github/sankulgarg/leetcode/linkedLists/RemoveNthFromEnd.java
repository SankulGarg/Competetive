package com.github.sankulgarg.leetcode.linkedLists;

class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(new RemoveNthFromEnd().removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
		System.out.println(new RemoveNthFromEnd().removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));

		System.out.println(new RemoveNthFromEnd().removeNthFromEnd(
				new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));

	}
}