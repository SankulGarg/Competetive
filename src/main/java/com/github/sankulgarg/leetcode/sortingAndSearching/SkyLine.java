package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class SkyLine {
	public List<List<Integer>> getSkyline(int[][] buildings) {

		int maxX = 0;

		for (int[] bldn : buildings) {
			if (maxX < bldn[1])
				maxX = bldn[1];
		}
		Map<Integer, Integer> buildungX = new TreeMap<>();

		for (int[] bldn : buildings) {
			for (int i = bldn[0]; i < bldn[1]; i++)
				buildungX.put(i, Math.max(buildungX.getOrDefault(i, 0), bldn[2]));
		}
		List<List<Integer>> skyLine = new ArrayList<>();

		int prevHeight = 0;
		for (int i = 0; i < maxX; i++) {
			Integer data = 0;
			if (buildungX.containsKey(i))
				data = buildungX.remove(i);
			if (data != prevHeight) {
				// critical pointO
				skyLine.add(Arrays.asList(i, data));
				prevHeight = data;
			}

		}

		skyLine.add(Arrays.asList(maxX, 0));
		return skyLine;

	}

	public static void main(String[] args) {
		new SkyLine()
				.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } });
	}
}