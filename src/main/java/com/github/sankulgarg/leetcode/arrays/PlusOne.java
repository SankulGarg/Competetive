package com.github.sankulgarg.leetcode.arrays;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int maxInd=digits.length-1;
        digits[maxInd]+=1;
        
        while ( maxInd>0 && digits[maxInd]>9 ){
             digits[maxInd]=0;
             maxInd--;
             digits[maxInd]+=1;
        }
        
        if(maxInd==0 && digits[0]>9)
        {
        	  digits[0]=0;
        	  int newdigits[]= new int[digits.length+1];
        	  newdigits[0]=1;
        	  
        	  for(int i=0;i<digits.length;i++)
        		  newdigits[i+1]=digits[i];
        	  
        	  return newdigits;
        }
        
        return digits;
    
    }
    public static void main(String[] args) {
		PlusOne sol=new PlusOne();
		sol.plusOne(new int[] {9});
	}
}