package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {

    public static void main(String[] args) {
        System.out.println(neighbour("abcdefghij").size());
    }
    private static List<String> neighbour(String str){
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            for (char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String neigh = new String(chars);
                list.add(neigh);
            }
            chars[i] = temp;
        }
        return list;
    }

}
