package com.github.sankulgarg.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static final int[][] directions = {new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};

    boolean checkValidIndex(int x, int y, int[][] grid) {
        return x < grid.length && y < grid[0].length && x >= 0 && y >= 0 && grid[x][y] != 2 && grid[x][y] != 0;
    }

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int totalOranges = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if (grid[i][j] != 0)
                    totalOranges++;
            }
        if (totalOranges == 0) return 0;

        int min = 0, rottedOranges = 0;
        while (!queue.isEmpty()) {
            int rottenOrangesSize = queue.size();
            rottedOranges += queue.size();
            while (rottenOrangesSize > 0) {
                int[] rottenOrange = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = rottenOrange[0] + directions[i][0];
                    int y = rottenOrange[1] + directions[i][1];
                    if (checkValidIndex(x, y, grid)) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
                rottenOrangesSize--;
            }
            min++;
        }
        if (totalOranges == rottedOranges)
            return min;
        else return -1;

    }

}
