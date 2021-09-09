package com.github.sankulgarg.leetcode.linkedLists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    Map<Integer,ListNode> map;
    Random random=new Random();
    public Solution(ListNode head) {
        map= new HashMap<>();
        ListNode curr=head;
        Integer key=1;
        while(curr!=null)
        {
            map.put(key,curr);
            curr=curr.next;
            key++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return map.get(random.nextInt(map.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */