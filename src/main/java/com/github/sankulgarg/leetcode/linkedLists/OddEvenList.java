package com.github.sankulgarg.leetcode.linkedLists;

class OddEvenList {
	public ListNode oddEvenList(ListNode head) {

		if(head==null)
			return head;
		
		ListNode odd = head;
		ListNode prev = odd;
		ListNode even = head.next;
		ListNode evenHead = head.next;

		
		
		while (odd != null || even != null) {

			if (odd != null && odd.next != null) {
				odd.next = odd.next.next;

			}

			if (odd != null) {
				prev = odd;
				odd = odd.next;
			}
			if (even != null && even.next != null) {
				even.next = even.next.next;
				even = even.next;
			}
			else if(even!=null)
				even = even.next;
			
		}
		
		prev.next = evenHead;
		return head;

	}

	public static void main(String[] args) {
		new OddEvenList().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
	}
}