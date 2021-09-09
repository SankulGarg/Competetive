/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static double getMaxGrain(int [][] grainBag, int w){
		if(grainBag==null || w==0 || grainBag.length==0)
			return 0;
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (int) Math.ceil((double)o2[0]/o2[1] - (double)o1[0]/o2[1]); 
				
			}
		});
	
		for(int [] grain:grainBag)
			queue.add(grain);
		
		System.out.println(Arrays.deepToString(queue.toArray()));
		
		double val=0;
		while(w>0 && !queue.isEmpty()) {
			int [] grain= queue.poll();
			
			int wD= w;
			if(w > grain[1])
				wD = grain[1];
			
			System.out.println("wd: "+wD);
			val+= ((double)grain[0])/grain[1] * wD;
			w-=wD;
			
		}
		return val;
		
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(getMaxGrain(new int [][]{{50,10},{55,10},{60,5}}, 40));
	}
}