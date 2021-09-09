package com.github.sankulgarg.leetcode.linkedLists;

import java.util.HashMap;

public class LRU {

	private class Node {
		int id;
		Node prev;
		Node next;

		Node(int id) {
			this.id = id;

		}

	}

	Node bottom;
	Node top;
	HashMap<Integer, Node> cache = null;
	int size = -1;

	public void intializeLru(int size) {

		this.size = size;
		cache = new HashMap<>();

	}

	public void put(int page) {

		if (cache.containsKey(page)) {

			System.out.println("already exist "+page);
			Node curr = cache.get(page);
			removeNode(curr);
			addAtTop(curr);

		} else {
			Node curr = new Node(page);

			if (cache.size() == 0)
				bottom = curr;
			if (cache.size() == size)
				removeNode(bottom);

			addAtTop(curr);

			
		}

	}

	Node get(int page) {

		if (cache.containsKey(page)) {

			Node curr = cache.get(page);
			removeNode(curr);
			addAtTop(curr);
			return curr;
		} else {
			
			System.out.println("NO Such element, returning top element instead");
			return top;

		}

	}

	void addAtTop(Node curr) {

		if (top == null)
			top = curr;
		else {
			top.next = curr;
			curr.prev = top;
			top = curr;
		}
		if(bottom==null)
			bottom=curr;
		cache.put(curr.id, curr);
	}

	void removeNode(Node curr) {
		if (curr == bottom)
			bottom = curr.next;
		if (curr.prev != null)
			curr.prev.next = curr.next;
		cache.remove(curr.id);
	}

	public static void main(String[] args) {
		LRU lru = new LRU();

		lru.intializeLru(3);

		lru.put(6);
		System.out.println(lru.get(6).id);
		lru.put(9);
		lru.put(1);
		lru.put(1);
		lru.put(1);
		lru.put(5);
		System.out.println(lru.get(6).id);

	}

}
