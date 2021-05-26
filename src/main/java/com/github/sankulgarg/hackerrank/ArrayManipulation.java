package com.github.sankulgarg.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ArrayManipulation {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		long maxSum = 0;
		int[] arr = new int[n + 1];

		for (int i = 0; i < m; i++) {
			try {

				int[] ops = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.mapToInt(Integer::parseInt).toArray();

				arr[ops[0]] += ops[2];
				if (ops[1] + 1 <= n)
					arr[ops[1] + 1] -= ops[2];

			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}

		long contSum = 0;
		for (int i = 1; i <= n; i++) {
			contSum = contSum + arr[i];
			if (maxSum < contSum)
				maxSum = contSum;

		}

		System.out.print(String.valueOf(maxSum));
		bufferedReader.close();
	}
}
