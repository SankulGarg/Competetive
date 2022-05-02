package com.github.sankulgarg.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class MinRefuelStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		  Arrays.sort(stations,(a,b)->a[1]-b[1]);
		if (stations.length == 0)
			if (target > startFuel)
				return -1;
			else
				return 0;
		int minStops = -1;
		int currentFuel = 0;
		int distanceTravelled = 0;
		PriorityQueue<Integer> maxStopSoFar = new PriorityQueue<>(Collections.reverseOrder());
		maxStopSoFar.add(startFuel);
		for (int i = 0; i < stations.length; i++) {
			int distanceToTravel = stations[i][0] - distanceTravelled;

			if (distanceToTravel > currentFuel) {
				while (!maxStopSoFar.isEmpty() && currentFuel < distanceToTravel) {
					currentFuel += maxStopSoFar.poll();
					minStops++;
				}
				if (maxStopSoFar.isEmpty() && currentFuel < distanceToTravel)
					return -1;
			}
			currentFuel -= distanceToTravel;
			distanceTravelled = stations[i][0];
			maxStopSoFar.add(stations[i][1]);
		}

		if (target > distanceTravelled + currentFuel) {
			while (!maxStopSoFar.isEmpty() && target > distanceTravelled + currentFuel) {
				currentFuel += maxStopSoFar.poll();
				minStops++;
			}
			if (target <= distanceTravelled + currentFuel)
				return minStops;
			else
				return -1;
		}
		return minStops > 0 ? minStops : 0;
	}

	public static void main(String[] args) {
		System.out.println(new MinRefuelStops().minRefuelStops(1000000, 70768,
				new int[][] { { 12575, 171159 }, { 81909, 101253 }, { 163732, 164401 }, { 190025, 65493 },
						{ 442889, 31147 }, { 481202, 166081 }, { 586028, 206379 }, { 591952, 52748 }, { 595013, 9163 },
						{ 611883, 217156 } }));
	}
}