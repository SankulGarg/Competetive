package com.github.sankulgarg.leetcode.linkedLists;

public class ListNode {
	int val;
	@Override
	public String toString() {
		String s= "[ "+val;
		ListNode temp=next;
		while(temp!=null)
		{
			s+=","+temp.val;
			temp=temp.next;
		}
		s+=" ]";
		return s;
	}

	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}