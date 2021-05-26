package com.github.sankulgarg.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class FindHourGlassSum {
	static int maxSum = Integer.MIN_VALUE;

	public static int hourglassSum(int[][] arr) {

		int length = arr[0].length;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {
				int sum = getSumForHourGlassAtIndex(arr, i, j, length);
				if (sum > maxSum)
					maxSum = sum;

			}
		}
		return maxSum;

	}

	private static int getSumForHourGlassAtIndex(int[][] arr, int i, int j, int length) {
		if (i < 0 || i >= length - 2 || length - j < 0 || j + 2 >= length)
			return maxSum;

		return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
				+ arr[i + 2][j + 2];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[6][6];
		for (int i = 0; i < arr.length; i++) {
			AtomicInteger j = new AtomicInteger(0);
			AtomicInteger iA = new AtomicInteger(i);
			Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).mapToInt(Integer::parseInt)
					.forEach(x -> {

						arr[iA.get()][j.get()] = x;
						j.set(j.get() + 1);
					});

		}

		int result = hourglassSum(arr);
		System.out.print(result);
	}

}
