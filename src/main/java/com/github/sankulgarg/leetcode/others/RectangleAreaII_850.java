package com.github.sankulgarg.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RectangleAreaII_850 {
	public int rectangleArea(int[][] rectangles) {
		int OPEN = 0, CLOSE = 1;
		int[][] events = new int[rectangles.length * 2][];
		int t = 0;
		for (int[] rec : rectangles) {
			events[t++] = new int[] { rec[0], OPEN, rec[1], rec[3] };
			events[t++] = new int[] { rec[2], CLOSE, rec[1], rec[3] };
		}

		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> active = new ArrayList();
		int cur_x = events[0][0];
		long ans = 0;
		for (int[] event : events) {
			int x = event[0], typ = event[1], y1 = event[2], y2 = event[3];

			// Calculate query
			long query = 0;
			int cur = -1;
			for (int[] xs : active) {
				cur = Math.max(cur, xs[0]);
				query += Math.max(xs[1] - cur, 0);
				cur = Math.max(cur, xs[1]);
			}

			ans += query * (x - cur_x);

			if (typ == OPEN) {
				active.add(new int[] { y1, y2 });
				Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
			} else {
				for (int i = 0; i < active.size(); ++i)
					if (active.get(i)[0] == y1 && active.get(i)[1] == y2) {
						active.remove(i);
						break;
					}
			}

			cur_x = x;
		}

		ans %= 1_000_000_007;
		return (int) ans;
	}
}