package com.github.sankulgarg.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
	class TrieNode {
		char c;
		boolean isWord;
		Map<Character, TrieNode> branches;

		TrieNode(char c) {
			this.c = c;
		}

	}

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode('0');
	}

	private TrieNode insert(char c, TrieNode curr) {
		if (curr.branches == null) {
			curr.branches = new HashMap<>();
		}
		
		return curr.branches.computeIfAbsent(c, TrieNode::new);
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		
		TrieNode curr = root;
		for (char c : word.toCharArray())
			curr = insert(c, curr);
		curr.isWord = true;

	}

	private TrieNode search(char c, TrieNode curr) {
		if (curr.branches == null || !curr.branches.containsKey(c))
			return null;
		return curr.branches.get(c);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			curr = search(c, curr);
			if (curr == null)
				return false;
		}
		return curr.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			curr = search(c, curr);
			if (curr == null)
				return false;
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */