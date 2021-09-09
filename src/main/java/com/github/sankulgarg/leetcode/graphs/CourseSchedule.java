package com.github.sankulgarg.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph=new ArrayList[numCourses];
        // 0 unvisited 1 visited 2 completed
        int[] visited = new int[numCourses];
       
        int count=0;
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();
        
        
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i=0;i<numCourses;i++){
           if(!dfs(visited,i,graph))
                return false;
        }
        return true;
        
    }
    
    private boolean dfs(int[] visited, int course, List<Integer>[] graph){
        
        if(visited[course]==1)
            return false;
        if(visited[course]==2)
            return true;
        
        visited[course]=1;
        
        for(Integer preReq: graph[course]){
            if(!dfs(visited,preReq,graph)) return false;
        }
         visited[course] = 2;
        
        return true;
    }
}