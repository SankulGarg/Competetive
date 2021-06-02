package com.github.sankulgarg.leetcode.sortingAndSearching;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
	public int firstBadVersion(int n) {
		int leastBadVersion = 1;
		int uppBoundary = n;
		while (leastBadVersion < uppBoundary) {
			int mid = leastBadVersion + (uppBoundary - leastBadVersion) / 2;

			if (isBadVersion(mid)) {
				uppBoundary = mid;
			} else
				leastBadVersion = mid + 1;

		}

		return leastBadVersion;
	}
}