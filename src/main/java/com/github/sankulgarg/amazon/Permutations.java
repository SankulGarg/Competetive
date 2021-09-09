package com.github.sankulgarg.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutations {
    
    private void permutations(List<String> permutations,String permutation,String s,Set<Character> visited){
        if(permutation.length()==s.length())
        {
            permutations.add(permutation);
            return;
            
        }
        
        for(int i=0;i<s.length();i++){
            if(!visited.contains(s.charAt(i)))
            {
                visited.add(s.charAt(i));
                permutations(permutations,permutation+s.charAt(i),s,visited);
                visited.remove(s.charAt(i));
                
            }
        }
        
    }
    
    public List<String> find_permutation(String S) {
        
        List<String> permutations=new ArrayList<>();
          permutations(permutations,"",S,new HashSet<>());
        return permutations;
        
    }
}