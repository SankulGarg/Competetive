package com.github.sankulgarg.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class GinieSwiggy {

	private static long maximiseRevenue(List<Long> pickup, List<Long> drop, List<Integer> tip, long amountEarned,
			int currentParcelIndex, long kmsTravelled) {

		if (currentParcelIndex >= pickup.size() || kmsTravelled > pickup.get(currentParcelIndex)
				|| kmsTravelled >= drop.get(currentParcelIndex))
			return amountEarned;

		amountEarned = amountEarned + drop.get(currentParcelIndex) - pickup.get(currentParcelIndex)
				+ tip.get(currentParcelIndex);

		kmsTravelled = drop.get(currentParcelIndex);

		long amountEarnedSkippedNext = maximiseRevenue(pickup, drop, tip, amountEarned, currentParcelIndex + 2,
				kmsTravelled);

		long amountEarnedWithoutSkippingNext = maximiseRevenue(pickup, drop, tip, amountEarned, currentParcelIndex + 1,
				kmsTravelled);

		if (amountEarnedWithoutSkippingNext > amountEarnedSkippedNext)
			return amountEarnedWithoutSkippingNext;
		else
			return amountEarnedSkippedNext;

	}

	public static long maximiseRevenue(List<Long> pickup, List<Long> drop, List<Integer> tip) {

		long amountEarnedSkippedNext = maximiseRevenue(pickup, drop, tip, 0, 1, 0);

		long amountEarnedWithoutSkippingNext = maximiseRevenue(pickup, drop, tip, 0, 0, 0);

		if (amountEarnedWithoutSkippingNext > amountEarnedSkippedNext)
			return amountEarnedWithoutSkippingNext;
		else
			return amountEarnedSkippedNext;

	}

	public static void main(String[] args) throws IOException {
		Scanner bufferedReader = new Scanner(System.in);
		
		int pickupCount = bufferedReader.nextInt();

		List<Long> pickup = IntStream.range(0, pickupCount).mapToObj(i -> {
			return bufferedReader.nextLine().replaceAll("\\s+$", "");
		}).map(String::trim).map(Long::parseLong).collect(toList());

		int dropCount = Integer.parseInt(bufferedReader.nextLine().trim());

		List<Long> drop = IntStream.range(0, dropCount).mapToObj(i -> {
			return bufferedReader.nextLine().replaceAll("\\s+$", "");
		}).map(String::trim).map(Long::parseLong).collect(toList());

		int tipCount = Integer.parseInt(bufferedReader.nextLine().trim());

		List<Integer> tip = IntStream.range(0, tipCount).mapToObj(i -> {
			return bufferedReader.nextLine().replaceAll("\\s+$", "");
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = maximiseRevenue(pickup, drop, tip);
		System.out.println(result);
		bufferedReader.close();
	}
}
