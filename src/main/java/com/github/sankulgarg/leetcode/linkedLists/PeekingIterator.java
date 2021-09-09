package com.github.sankulgarg.leetcode.linkedLists;
// Java Iterator interface reference:

// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

	class Node {
		Integer val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	Node head = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		Node curr = null;
		Node prev = null;
		while (iterator.hasNext()) {
			int num = iterator.next();
			curr = new Node(num);
			if (head == null) {
				head = curr;
				prev = new Node(-1);
			}
			if (prev != null)
				prev.next = curr;
			prev = curr;

		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return head.val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (head != null) {
			Integer val=head.val;
			head = head.next;
			return val;
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		return head != null;
	}
	
	public static void main(String[] args) {
		new PeekingIterator(null);
	}
}