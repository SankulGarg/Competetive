package com.github.sankulgarg.leetcode.linkedLists;
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
    	
    	ListNode curr=head;
    	ListNode prev=null;
    	ListNode next=null;
    	while(curr!=null) {
    		next=curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=next;
    		
    	}
    	System.gc();
		return prev;
        
    }
    public static void main(String[] args) {
		System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))));
	}
}