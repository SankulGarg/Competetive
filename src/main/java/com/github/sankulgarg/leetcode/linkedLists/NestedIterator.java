package com.github.sankulgarg.leetcode.linkedLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
	PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (b[0] - a[0]));

	LinkedList<Integer> list = new LinkedList<>();

	public void add(List<NestedInteger> nestedList) {
		for (NestedInteger nested : nestedList) {
			if (nested.isInteger())
				list.add(nested.getInteger());
			else
				add(nested.getList());
		}
	}

	public NestedIterator(List<NestedInteger> nestedList) {
		add(nestedList);
	}

	@Override
	public Integer next() {
		return list.poll();
	}

	@Override
	public boolean hasNext() {
		return !list.isEmpty();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */