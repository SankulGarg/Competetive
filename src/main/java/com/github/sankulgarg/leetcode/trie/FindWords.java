package com.github.sankulgarg.leetcode.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class FindWords {
    class TrieNode {
		char c;
		boolean isWord;
		Map<Character, TrieNode> branches;
        String word=null;

		TrieNode(char c) {
			this.c = c;
		}

	}
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode('0');
        for(String word: words)
            insert(word);
        
        Set<String> wordsInTheBoard= new HashSet<>();
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                  traverseBoard(r,c,board,new boolean[board.length][board[0].length],root,wordsInTheBoard);
            }
        }
        return wordsInTheBoard.stream().collect(Collectors.toList());
    }
    private boolean canVisit(int r, int c, char[][]board, boolean[][] visited, TrieNode curr){
        return r>=0 && c>=0&& r<board.length && c<board[0].length && !visited[r][c] && curr.branches!=null &&                                    curr.branches.containsKey(board[r][c]);
        
    }
    
    
    private void traverseBoard(int r, int c, char[][]board, boolean[][] visited, TrieNode curr, Set<String> wordsInTheBoard)
    {
        if(!canVisit(r,c,board,visited,curr))
            return;
        visited[r][c]=true;
        curr = curr.branches.get(board[r][c]);
        if(curr.isWord)
            wordsInTheBoard.add(curr.word);
        //goLeft
        traverseBoard(r,c-1,board,visited,curr,wordsInTheBoard);
        traverseBoard(r,c+1,board,visited,curr,wordsInTheBoard);
        traverseBoard(r-1,c,board,visited,curr,wordsInTheBoard);
        traverseBoard(r+1,c,board,visited,curr,wordsInTheBoard);
    }
 
	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray())
			curr = insert(c, curr);
		curr.isWord = true;
        curr.word=word;

	}
     private TrieNode insert(char c, TrieNode curr) {
		if (curr.branches == null) {
			curr.branches = new HashMap<>();
		}
		
		return curr.branches.computeIfAbsent(c, TrieNode::new);
	}
     public static void main(String[] args) {
		new FindWords().findWords(new char[][]{
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain","hklf", "hf"});
	}
    
}