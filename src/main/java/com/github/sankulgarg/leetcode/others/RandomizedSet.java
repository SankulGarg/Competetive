package com.github.sankulgarg.leetcode.others;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

	/** Initialize your data structure here. */
	Set<Integer> set;

	public RandomizedSet() {
		set = new LinkedHashSet<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (set.contains(val))
			return false;
		set.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		return set.remove(val);
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(0);
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */