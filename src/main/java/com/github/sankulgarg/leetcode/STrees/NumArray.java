package com.github.sankulgarg.leetcode.STrees;

class NumArray {

	int segTrees[];
	int inputSize = 0;

	void createSegmentTree(int arr[]) {
		inputSize = arr.length;
		int temp = (int) (Math.ceil(Math.log(inputSize) / Math.log(2)));
		int treeSize = (int) (2 * Math.pow(2, temp) - 1);
		segTrees = new int[treeSize];
		populateSegmenTree(arr, 0, inputSize - 1, 0);
	}

	void populateSegmenTree(int arr[], int low, int high, int pos) {

		if (low == high) {
			segTrees[pos] = arr[low];
			return;
		}
		int mid = (low + high) / 2;
		// construct left
		populateSegmenTree(arr, low, mid, (2 * pos) + 1);
		populateSegmenTree(arr, mid + 1, high, (2 * pos) + 2);

		segTrees[pos] = segTrees[(pos * 2) + 1] + segTrees[(pos * 2) + 2];

	}

	int rangeQuery(int qStart, int qEnd, int low, int high, int pos) {
		if (qStart <= low && qEnd >= high)
			return segTrees[pos];
		else if (qStart > high || qEnd < low)
			return 0;
		int mid = (low + high) / 2;
		return rangeQuery(qStart, qEnd, low, mid, 2 * pos + 1) + rangeQuery(qStart, qEnd, mid + 1, high, 2 * pos + 2);
	}

	public NumArray(int[] nums) {
		createSegmentTree(nums);
	}

	void update(int val, int low, int high, int pos, int idx) {

		if (low == high) {
			segTrees[pos] = val;
			return;
		}
		int mid = (low + high) / 2;

		if (idx <= mid)
			update(val, low, mid, (2 * pos) + 1, idx);
		else
			update(val, mid + 1, high, (2 * pos) + 2, idx);

		segTrees[pos] = segTrees[(pos * 2) + 1] + segTrees[(pos * 2) + 2];

	}

	public void update(int pos, int val) {

		update(val, 0, inputSize - 1, 0, pos);
	}

	public int sumRange(int left, int right) {
		return rangeQuery(left, right, 0, inputSize - 1, 0);

	}

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		numArray.sumRange(0, 2);
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));
	}

}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(index,val); int param_2 =
 * obj.sumRange(left,right);
 */