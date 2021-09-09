package com.github.sankulgarg.leetcode.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class ScheduleCourse3 {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int time=0;
        for(int i=0;i<courses.length;i++){
            time+= courses[i][0];
            pq.add(courses[i][0]);
            if(time>courses[i][1])
                time-=pq.poll();
        }
        return pq.size();
        
    }
}