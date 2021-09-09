package com.github.sankulgarg.leetcode.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

class MinRefuelStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {

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
}