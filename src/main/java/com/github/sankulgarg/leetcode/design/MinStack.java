package com.github.sankulgarg.leetcode.design;

class MinStack {
	Node curr;
	
	  /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
    	if(curr==null)
    		curr=new Node(null, val, val);
    	else
    		curr=new Node(curr,val, Math.min(val, curr.min));
        
    }
    
    public void pop() {
    curr=curr.prev;    
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return curr.min;
    }
	
	
	
	
	
	private class Node {

		Node prev;
		int min, val;

		Node(Node prev, int val, int min) {
			this.val = val;
			this.min = min;
			this.prev = prev;
		}

	}

}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */