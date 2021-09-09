package com.github.sankulgarg.leetcode.STrees;

public class SegmentTree {
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

		// main busiiness logic, if we want max within a range
		segTrees[pos] = Math.max(segTrees[(pos * 2) + 1], segTrees[(pos * 2) + 2]);

	}

	void query(int start, int end) {
		System.out.println(rangeQuery(start, end, 0, inputSize - 1, 0));
	}

	int rangeQuery(int qStart, int qEnd, int low, int high, int pos) {
		if (qStart <= low && qEnd >= high)
			return segTrees[pos];
		else if (qStart > high || qEnd < low)
			return Integer.MIN_VALUE;
		int mid = (low + high) / 2;
		return Math.max(rangeQuery(qStart, qEnd, low, mid, 2 * pos + 1),
				rangeQuery(qStart, qEnd, mid + 1, high, 2 * pos + 2));
	}

	public static void main(String[] args) {
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.createSegmentTree(new int[] { -1, 2, 4, 0, 9 });
		segmentTree.query(0, 2);
		segmentTree.query(2, 4);
	}
}
