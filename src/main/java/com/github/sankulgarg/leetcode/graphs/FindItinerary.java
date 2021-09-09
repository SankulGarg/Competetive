package com.github.sankulgarg.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class FindItinerary {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph= new HashMap<>();
        LinkedList<String> path= new LinkedList<>();
        for(List<String> itinerary: tickets)
        {
            String from= itinerary.get(0);
            String to= itinerary.get(1);  
            graph.computeIfAbsent(from,f->new PriorityQueue<>());
            graph.get(from).add(to);

        }
        dfs(graph, "JFK",path);
        return path;
        
    }
    
    void dfs( Map<String,PriorityQueue<String>> graph, String from,LinkedList<String> path ){
        
        while(graph.get(from)!=null && !graph.get(from).isEmpty()){           
            dfs(graph,graph.get(from).poll(),path);      
        }
          path.addFirst(from);
     
    }
}