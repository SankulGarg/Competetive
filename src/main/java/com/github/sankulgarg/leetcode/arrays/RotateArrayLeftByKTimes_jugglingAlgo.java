package com.github.sankulgarg.leetcode.arrays;

class RotateArrayLeftByKTimes_jugglingAlgo {
    private int gcd(int a,int b){
        if(b==0)
            return a;
        
        else
            return gcd (b,a%b);
    }
    
    public void rotate(int[] nums, int k) {
        
        int gcd=gcd(nums.length,k);
        
        int temp=0;
        for(int i=0;i<gcd;i++){
            temp=nums[i];
            
            int j=i+gcd;
            while(j<nums.length){
              nums[j-gcd]=nums[j];     
              j+=gcd;
            }
            nums[j-gcd]=temp;
        
        }
    
     }


	public static void main(String[] args) {
		RotateArrayLeftByKTimes_jugglingAlgo sol = new RotateArrayLeftByKTimes_jugglingAlgo();
		sol.rotate(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3);
	}
}