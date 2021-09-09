package com.github.sankulgarg.leetcode.arrays;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountConnections {

	// Complete the countConnections function below.
	static int connCount = 0;

	static int countConnections(List<List<Integer>> matrix) {
		connCount = 0;

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(0).size(); j++) {
				if (matrix.get(i).get(j) == 1)
					checkNeighbours(matrix, i, j);
			}
		}
		return connCount;

	}

	static void checkNeighbours(List<List<Integer>> matrix, int i, int j) {

		// check right
		if (j + 1 < matrix.get(0).size() && matrix.get(i).get(j + 1) == 1) {
			System.out.println("(" + i + "," + j + ") -> (" + i + "," + (j + 1) + ")");
			connCount++;
		}
		// check top right
		if (i - 1 >= 0 && j + 1 < matrix.get(0).size() && matrix.get(i - 1).get(j + 1) == 1) {
			System.out.println("(" + i + "," + j + ") -> (" + (i - 1) + "," + (j + 1) + ")");
			connCount++;
		}
		// check bottom right
		if (i + 1 < matrix.size() && j + 1 < matrix.get(0).size() && matrix.get(i + 1).get(j + 1) == 1) {
			System.out.println("(" + i + "," + j + ") -> (" + (i + 1) + "," + (j + 1) + ")");
			connCount++;
		}

		// check bottom
		if (i + 1 < matrix.size() && matrix.get(i + 1).get(j) == 1) {
			System.out.println("(" + i + "," + j + ") -> (" + (i + 1) + "," + j + ")");
			connCount++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
		int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> matrix = new ArrayList<>();

		IntStream.range(0, matrixRows).forEach(i -> {
			try {
				matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int res = countConnections(matrix);

	}
}
