package com.github.sankulgarg.amazon;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PythagorusTriplets {

	static boolean isPythagorusTriplet(int arr[]) {
		
		
		Set<Integer> elements= Arrays.stream(arr).boxed().collect(Collectors.toSet());
		
		for(int i=0;i<arr.length-1;i++) {
			
			for(int j=i+1;j<arr.length;j++)
				if(elements.contains((int)Math.sqrt(Math.pow(arr[i], 2)+ Math.sqrt(arr[j]))))
					return true;
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println(isPythagorusTriplet(new int[] {3, 2, 4, 6, 5 }));
	}
	
}
