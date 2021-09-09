package com.github.sankulgarg.leetcode.dp;
class MinLadder {
    public int jump(int[] nums) {
        if(nums.length<=1)
            return 0;
        int ladder = nums[0]; //keep track of largest ladder that you have
        int stairs = nums[0]; //keep track of stairs in current ladder
        
        int jump = 1;
        
        for(int level = 1; level < nums.length; level++) {
            if(level == nums.length - 1)
                return jump;
            stairs--; //consuming one stairs at a time
            ladder--; //consuming one stairs of the ladder at a time
            if(nums[level] > ladder) { // if new ladder is bigger than the current one, store the new ladder
                ladder = nums[level]; //build up the ladder
            }
            if(stairs == 0) {
                jump++; //no stairs left,so jump now
                stairs = ladder; //get the new sets of stairs from the ladder
            }
        }
        return jump;
    }
    public static void main(String[] args) {
		System.out.println(new MinLadder().jump(new int []{2,3,1,1,4}));
	}
    
	/**	level 0: jump 0, s, 2, l: 2
	 * jump++;
	 *  level 1: jump:1 s:1 , l:3
	 *  level 2: jump:2 s:0, l;2
	 *  s:l:2
	 *  level 3: s:1, l:1
	 *  level 4: 
	 * 
	 * 
	 */
}
